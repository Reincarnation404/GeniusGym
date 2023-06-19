package com.example.geniusgym.coach

import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.geniusgym.R
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportRecordBigItem
import com.example.geniusgym.databinding.ActivityCoBinding
import com.google.gson.GsonBuilder
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.coroutines.runBlocking
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class CoActivity : AppCompatActivity() {

    public lateinit var binding: ActivityCoBinding
    private lateinit var navigateController: NavController
    public var memberSportRecord = mutableListOf<SportRecordBigItem>()
    public var memberSportBigRecord: SportRecordBigItem? = null
    public lateinit var homeQrcodeMap: Bitmap
    private val mWriter: MultiFormatWriter = MultiFormatWriter()
    private val mEncoder: BarcodeEncoder = BarcodeEncoder()
    lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CoViewModel by viewModels()
        binding = ActivityCoBinding.inflate(LayoutInflater.from(this))
        binding.viewModel = viewModel
        setContentView(binding.root)

        var now = LocalTime.now()
        var fiveMinutes = LocalTime.of(0, 5, 0)
        val nowFormatter = DateTimeFormatter.ofPattern("hh:mm:ss")
        val formatter = DateTimeFormatter.ofPattern("mm:ss")
        val second = 1000L
        val minute = 60 * second
        var nowString = now.format(nowFormatter)
        var mMatrix : BitMatrix = mWriter.encode("example_$nowString" , BarcodeFormat.QR_CODE,300,300)
        binding.viewModel?.homeQrcodeMap?.value = mEncoder.createBitmap(mMatrix)
        timer = object : CountDownTimer(5 * minute, 1 * second) {
            // 每過一秒，該方法會被呼叫一次
            override fun onTick(millisUntilFinished: Long) {
                //millisUntilFinished / second
                fiveMinutes = fiveMinutes.minusSeconds(1)
                binding.viewModel?.homeTimerString?.value = fiveMinutes.format(formatter)
            }

            // 計時器結束時，該方法會被呼叫
            override fun onFinish() {
                runBlocking {
                    fiveMinutes = LocalTime.of(0, 5, 0)
                    now = LocalTime.now()
                    nowString = now.format(nowFormatter)
                    mMatrix = mWriter.encode("example_$nowString" , BarcodeFormat.QR_CODE,300,300)
                    binding.viewModel?.homeQrcodeMap?.value = mEncoder.createBitmap(mMatrix)
                    binding.viewModel?.homeTimerString?.value = fiveMinutes.format(formatter)
                    timer.start()
                }
            }
        }
        timer.start()
    }

    override fun onStart() {
        super.onStart()
        this.binding.viewModel?.loadSportFromPreference(this)
        this.binding.viewModel?.loadSportSmallItem(this)
        this.binding.viewModel?.loadSportBigItem(this)

        navigateController = findNavController(R.id.fragmentCoContainerView)
        with(binding) {
            includeHome.homeMontionLayout.progress = 1f
            tvCoActivityHead.text = "首頁"
            includeHome.homeMontionLayout.setOnClickListener {
                if (includeHome.homeMontionLayout.progress == 0f) {
                    MotionToZero()
                    includeHome.homeMontionLayout.transitionToEnd()
                }
                tvCoActivityHead.text = "首頁"
                llCoActivityHead.visibility = View.VISIBLE
                navigateController.navigate(R.id.coHomeFragment)
            }
            includeCalendar.coachMotionLayout.setOnClickListener {
                tvCoActivityHead.text = "行事曆"
                llCoActivityHead.visibility = View.VISIBLE
                if (includeCalendar.coachMotionLayout.progress == 0f) {
                    MotionToZero()
                    includeCalendar.coachMotionLayout.transitionToEnd()
                }
                navigateController.navigate(R.id.coCalendarClassFragment)
            }
            includeSocial.socialMontionLayout.setOnClickListener {
                if (includeSocial.socialMontionLayout.progress == 0f) {
                    MotionToZero()
                    includeSocial.socialMontionLayout.transitionToEnd()
                }
                llCoActivityHead.visibility = View.GONE
                navigateController.navigate(R.id.socialNavFragment)
            }
            includeNotification.notificationMontionLayout.setOnClickListener {
                if (includeNotification.notificationMontionLayout.progress == 0f) {
                    MotionToZero()
                    includeNotification.notificationMontionLayout.transitionToEnd()
                }
                tvCoActivityHead.text = "通知"
                llCoActivityHead.visibility = View.VISIBLE
                navigateController.navigate(R.id.notificationFragment)
            }
            includeInformation.memberMontionLayout.setOnClickListener {
                if (includeInformation.memberMontionLayout.progress == 0f) {
                    MotionToZero()
                    includeInformation.memberMontionLayout.transitionToEnd()
                }
                tvCoActivityHead.text = "資訊"
                llCoActivityHead.visibility = View.VISIBLE
                navigateController.navigate(R.id.coCoachFragment)
            }
        }
    }

    private fun MotionToZero() {
        with(binding) {
            includeHome.homeMontionLayout.progress = 0f
            includeCalendar.coachMotionLayout.progress = 0f
            includeSocial.socialMontionLayout.progress = 0f
            includeNotification.notificationMontionLayout.progress = 0f
            includeInformation.memberMontionLayout.progress = 0f
        }
    }

    override fun onPause() {
        super.onPause()
        val gson = GsonBuilder().create()
        val sportSmallItemsJson = gson.toJson(this.binding.viewModel?.sportSmallItems?.value)
        val sportBigItems = gson.toJson(this.binding.viewModel?.sportBigItems?.value)
        this.getPreferences(Context.MODE_PRIVATE).edit()
            .putString("sportSmallItems", sportSmallItemsJson)
            .putString("sportBigItems", sportBigItems)
            .apply()
        println("Write prefernece successful!")
    }

}