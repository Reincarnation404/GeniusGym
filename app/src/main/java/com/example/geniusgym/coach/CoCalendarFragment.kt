package com.example.geniusgym.coach

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentCoCalendarBinding
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE
import java.time.temporal.TemporalAdjusters
import java.util.*

class CoCalendarFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentCoCalendarBinding
    private lateinit var weekList: MutableList<weekDay>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel: CoCalendarViewModel by viewModels()
        binding = FragmentCoCalendarBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val date = LocalDate.now()
        val firstDayOrWeek = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))

        with(binding) {
            weekList = mutableListOf(
                weekDay(tvCoCaDayOf1,LocalDate.now()),
                weekDay(tvCoCaDayOf2,LocalDate.now()),
                weekDay(tvCoCaDayOf3,LocalDate.now()),
                weekDay(tvCoCaDayOf4,LocalDate.now()),
                weekDay(tvCoCaDayOf5,LocalDate.now()),
                weekDay(tvCoCaDayOf6,LocalDate.now()),
                weekDay(tvCoCaDayOf7,LocalDate.now())
            )

            viewModel?.textDate?.value = LocalDate.now().format(ISO_LOCAL_DATE).toString()
            tvDate.setOnClickListener(this@CoCalendarFragment)
            for(textview in weekList){
                textview.textview.setOnClickListener(this@CoCalendarFragment)
            }

        }
    }

    private fun pad(number: Int): String {
        return if (number >= 10) {
            number.toString()
        } else {
            "0$number"
        }
    }

    override fun onClick(v: View?) {
        with(binding){
            when(v?.id){
                R.id.tvDate ->{
                    val calendar = Calendar.getInstance()
                    val datePickerDialog = DatePickerDialog(
                        requireContext(),
                        { _, year, month, day ->
                            viewModel?.textDate?.value = "$year-${pad(month+1)}-${pad(day)}"
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    )
                    datePickerDialog.show()
                }
                R.id.tvCoCaDayOf1 -> selectDay(1)
                R.id.tvCoCaDayOf2 -> selectDay(2)
                R.id.tvCoCaDayOf3 -> selectDay(3)
                R.id.tvCoCaDayOf4 -> selectDay(4)
                R.id.tvCoCaDayOf5 -> selectDay(5)
                R.id.tvCoCaDayOf6 -> selectDay(6)
                R.id.tvCoCaDayOf7 -> selectDay(7)
            }
        }
    }
    private fun selectDay(index:Int){
        for (day in weekList){
            day.textview.setBackgroundResource(R.color.black)
        }
        weekList[index-1].textview.setBackgroundResource(R.color.teal_700)
        binding.viewModel?.textDate?.value = weekList[index-1].date.toString()
    }
    private class weekDay(var textview:android.widget.TextView, var date:LocalDate )
}