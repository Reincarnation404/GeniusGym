package com.example.geniusgym.business

import android.app.DatePickerDialog
import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.geniusgym.business.viewModel.BuCoachDataAddViewModel
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentBuCoachDataAddBinding
import java.text.SimpleDateFormat
import java.util.*

class BuCoachDataAddFragment : Fragment() {
    private lateinit var binding: FragmentBuCoachDataAddBinding

    private val calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuCoachDataAddBinding.inflate(inflater, container, false)
        val viewModel: BuCoachDataAddViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            tietBuAddCoaDataName.setTextColor(Color.BLACK)

            tietBuAddCoaDataID.setTextColor(Color.BLACK)

            tietBuAddCoaDataPwd.setTextColor(Color.BLACK)

            tietBuAddCoaDataGen.setTextColor(Color.BLACK)

            tietBuAddCoaDataCell.setTextColor(Color.BLACK)

            tietBuAddCoaDataTwid.setTextColor(Color.BLACK)

            tietBuAddCoaDataAddr.setTextColor(Color.BLACK)

            tietBuAddCoaDataEmail.setTextColor(Color.BLACK)

            tvBuAddCoaDataOBDate.setOnClickListener {
                tvBuAddCoaDataOBDate.showSoftInputOnFocus = false
                openDateTimeDialogs()
            }

            tietBuAddCoaDataIntro.setTextColor(Color.BLACK)

            //todo btBuAddCoaDataSave的資料儲存與頁面跳轉

            btBuAddCoaDataCancel.setOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }
        }
    }

    private fun openDateTimeDialogs() {
        val dateListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            updateTvBuAddChooseCoaOBDate()
        }

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            dateListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }
    private fun updateTvBuAddChooseCoaOBDate() {
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val dateTime = format.format(calendar.time)
        binding.tvBuAddCoaDataOBDate.text = dateTime
        binding.tvBuAddCoaDataOBDate.setTextColor(Color.BLACK)
    }



}