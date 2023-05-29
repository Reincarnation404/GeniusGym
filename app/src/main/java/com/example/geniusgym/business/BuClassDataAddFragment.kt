package com.example.geniusgym.business

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.geniusgym.business.viewModel.BuClassDataAddViewModel
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentBuClassDataAddBinding
import java.text.SimpleDateFormat
import java.util.*

class BuClassDataAddFragment : Fragment() {

    private lateinit var binding: FragmentBuClassDataAddBinding
    private val calendar = Calendar.getInstance()
    private lateinit var viewModel: BuClassDataAddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuClassDataAddBinding.inflate(inflater, container, false)
        val viewModel: BuClassDataAddViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            tietBuAddClassDataName.setTextColor(Color.BLACK)

            tietBuAddClassDataID.setTextColor(Color.BLACK)

            tvBuAddClassDataStartTime.setOnClickListener {
                tvBuAddClassDataStartTime.showSoftInputOnFocus = false
                openDateTimeDialogs()
                tvBuAddClassDataStartTime.text = updateTime()
                tvBuAddClassDataStartTime.setTextColor(Color.BLACK)
            }




            tvBuAddClassDataEndTime.setOnClickListener {
                tvBuAddClassDataEndTime.showSoftInputOnFocus = false
            }

            tvBuAddClassDataBranch.setOnClickListener {
                tvBuAddClassDataBranch.showSoftInputOnFocus = false
            }

            tietBuAddClassDataPlace.setTextColor(Color.BLACK)

            tietBuAddClassDataPoint.setTextColor(Color.BLACK)

            tietBuAddClassDataLimit.setTextColor(Color.BLACK)

            tvBuAddClassDataRegiStartTime.setOnClickListener {
                tvBuAddClassDataRegiStartTime.showSoftInputOnFocus = false
            }

            tvBuAddClassDataRegiEndTime.setOnClickListener {
                tvBuAddClassDataRegiEndTime.showSoftInputOnFocus = false
            }

            tietBuAddClassDataIntro.setTextColor(Color.BLACK)

            //todo btBuAddClassDataSave的資料儲存與頁面跳轉

            btBuAddClassDataCancel.setOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }
        }
    }

    private fun openDateTimeDialogs() {
        val dateListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            openTimePickerDialog()
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
    private fun openTimePickerDialog() {
        val timeListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minute)
            updateTime()

        }
        val timePickerDialog = TimePickerDialog(
            requireContext(),
            timeListener,
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        )
        timePickerDialog.show()
    }
    private fun updateTime(): String {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        return format.format(calendar.time)
    }



}