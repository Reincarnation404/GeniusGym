package com.example.geniusgym.member

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.geniusgym.databinding.FragmentMeMapDirectBinding
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.Task
import java.io.IOException

class MeMapDirectFragment : Fragment() {

    private val viewModel: MeMapDirectViewModel by viewModels()
    private lateinit var binding: FragmentMeMapDirectBinding
    private lateinit var map: GoogleMap
    private lateinit var latLng: LatLng

    private val myTag = "TAG_${javaClass.simpleName}"
    private var fusedLocationClient: FusedLocationProviderClient? = null
    private lateinit var locationCallback: LocationCallback
    private lateinit var locationRequest: LocationRequest
    private var lastLocation: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        locationRequest = LocationRequest.Builder(
            Priority.PRIORITY_HIGH_ACCURACY,
            10000
        )
//                移動的位置超過設定的數據
            .setMinUpdateDistanceMeters(1000f).build()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())

        locationCallback = object : LocationCallback() {
            //          如果沒超過設定的距離，就不會重新更新畫面
            override fun onLocationResult(locationResult: LocationResult) {
                lastLocation = locationResult.lastLocation
                lastLocation?.let {
                    latLng = LatLng(it.latitude, it.longitude)
                    moveMap(latLng)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeMapDirectBinding.inflate(LayoutInflater.from(requireContext()))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val locationName = arguments?.getString("branchlocation")

        checkLocationSettings()

        with(binding){
            mapView.onCreate(savedInstanceState)
            mapView.onStart()
            mapView.getMapAsync{ googleMap ->
                map = googleMap
            }
            if (locationName != null) {
                geocode(locationName)?.let { addressDestination ->
                    direct(
                        latLng.latitude,
                        latLng.longitude,
                        addressDestination.latitude,
                        addressDestination.longitude
                    )
                }
            }else{
                Toast.makeText(requireContext(), "載入錯誤，請重新啟動app", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onStart() {
        super.onStart()
//        如果允許後，切到app的設定在關掉時，在oStart()請求再次允許
        requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    private fun updateMyLocation() {

        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_DENIED
        ) {
            Toast.makeText(requireContext(), "尚未同意取得目前位置", Toast.LENGTH_SHORT).show()
            return
        }

        fusedLocationClient?.lastLocation?.addOnCompleteListener { task: Task<Location> ->
            if (task.isSuccessful) {
                lastLocation = task.result
                lastLocation?.let {
                    latLng = LatLng(it.latitude, it.longitude)
                    Log.d(myTag, "task_is_successful${it.latitude}, ${it.longitude}")
                }
            }
        }

        fusedLocationClient?.requestLocationUpdates(
            locationRequest, locationCallback, Looper.getMainLooper()
        )
    }

    private fun moveMap(latLng: LatLng) {
        val cameraPosition = CameraPosition.builder()
            .target(latLng)
            .zoom(50f)
            .build()
        val cameraUpdate = CameraUpdateFactory
            .newCameraPosition(cameraPosition)
        map.animateCamera(cameraUpdate)
    }

    private fun direct(
        fromLat: Double, fromLng: Double, toLat: Double,
        toLng: Double,
    ) {
        val uriStr = "https://www.google.com/maps/dir/?api=1" +
                "&origin=$fromLat,$fromLng&destination=$toLat,$toLng" +
                // 不打下面這一段的話可以自己解析經緯度，會回傳一個json格式的物件
                "&travelmode=driving"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uriStr))
        intent.setClassName(
            "com.google.android.apps.maps",
            "com.google.android.maps.MapsActivity"
        )
        startActivity(intent)
    }

    private fun geocode(locationName: String): Address? {
        val geocoder = Geocoder(requireContext())
        var addressList: List<Address?>? = null
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                geocoder.getFromLocationName(locationName, 1
                ) {
                    addressList = it
                }
            }else{
                addressList = geocoder.getFromLocationName(locationName, 1)
            }
        } catch (e: IOException) {
            Log.e(myTag, e.toString())
        }
        return if (addressList == null || addressList!!.isEmpty()) {
            null
        } else {
            addressList!![0]
        }
    }

    //請求權限
    private val resolutionForResult =
        registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { activtyresult ->
            if (activtyresult.resultCode == Activity.RESULT_OK) {
                updateMyLocation()
                moveMap(latLng)
            } else {
                Toast.makeText(requireContext(), "尚未同意取得目前位置", Toast.LENGTH_SHORT).show()
            }
        }

    private var requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                updateMyLocation()
                moveMap(latLng)
            } else {
                Toast.makeText(requireContext(), "尚未同意取得目前位置", Toast.LENGTH_SHORT).show()
            }
        }

    private fun checkLocationSettings() {
//        必須將LocationRequest設定加入檢查
        val builder = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)

        val task = LocationServices.getSettingsClient(requireContext())
            .checkLocationSettings(builder.build())

        task.addOnSuccessListener(requireActivity()) {
            updateMyLocation()
        }

        task.addOnFailureListener { e: Exception ->
            if (e is ResolvableApiException) {
                Log.e(myTag, e.message ?: "ResolvableApiException")
                resolutionForResult.launch(IntentSenderRequest.Builder(e.resolution).build())
            }
        }
    }

}