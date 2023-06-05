package com.example.geniusgym.business

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.geniusgym.business.viewModel.BuMemberDataAddViewModel
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentBuMemberDataAddBinding
import java.text.SimpleDateFormat
import java.util.*

class BuMemberDataAddFragment : Fragment() {
    private lateinit var binding: FragmentBuMemberDataAddBinding
    private val calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuMemberDataAddBinding.inflate(inflater, container, false)
        val viewModel: BuMemberDataAddViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            tietBuAddMemDataExpireDate.setOnClickListener {
                tietBuAddMemDataExpireDate.showSoftInputOnFocus = false
                openDateTimeDialogs()
            }

            btBuAddMemDataCancel.setOnClickListener {
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
            updateTvBuAddChooseDate()
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
    private fun updateTvBuAddChooseDate() {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val dateTime = format.format(calendar.time)
        binding.tietBuAddMemDataExpireDate.text = dateTime
        binding.tietBuAddMemDataExpireDate.setTextColor(Color.BLACK)
    }

}