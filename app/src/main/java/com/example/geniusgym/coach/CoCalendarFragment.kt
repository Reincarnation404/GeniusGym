package com.example.geniusgym.coach

import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentCoCalendarBinding
import com.example.geniusgym.databinding.FragmentCoCalenderClassListBinding
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE
import java.time.temporal.TemporalAdjusters
import java.util.*

class CoCalendarFragment : Fragment(), View.OnClickListener {
    val CoCaCLviewModel: CoCalendarClassListViewModel by viewModels()
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
            viewModel?.textDate?.value = LocalDate.now().format(ISO_LOCAL_DATE).toString()
            weekList = mutableListOf(
                weekDay(tvCoCaDayOf1,firstDayOrWeek),
                weekDay(tvCoCaDayOf2,firstDayOrWeek.plusDays(1)),
                weekDay(tvCoCaDayOf3,firstDayOrWeek.plusDays(2)),
                weekDay(tvCoCaDayOf4,firstDayOrWeek.plusDays(3)),
                weekDay(tvCoCaDayOf5,firstDayOrWeek.plusDays(4)),
                weekDay(tvCoCaDayOf6,firstDayOrWeek.plusDays(5)),
                weekDay(tvCoCaDayOf7,firstDayOrWeek.plusDays(6))
            )
            tvDate.setOnClickListener(this@CoCalendarFragment)
            for(textview in weekList){
                textview.textview.setOnClickListener(this@CoCalendarFragment)
            }
            val dayOfWeek = date.dayOfWeek.value
            if (dayOfWeek != null) {
                selectDay(dayOfWeek)
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
                            viewModel?.Date?.value = LocalDate.parse("$year-${pad(month+1)}-${pad(day)}")
                            val firstDayOfWeek = viewModel?.Date?.value?.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                            firstDayOfWeek?.let {
                                for(i in 0..6){
                                    weekList[i].date = it.plusDays(i.toLong())
                                }
                            }
                            val dayOfWeek = viewModel?.Date?.value?.dayOfWeek?.value
                            if (dayOfWeek != null) {
                                selectDay(dayOfWeek)
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    )

                    datePickerDialog.show()
                }
                R.id.tvCoCaDayOf1 -> {
                    selectDay(1)

                }
                R.id.tvCoCaDayOf2 -> {
                    selectDay(2)
                    CoCaCLviewModel.search(viewModel?.textDate?.value)
                }
                R.id.tvCoCaDayOf3 -> {
                    selectDay(3)
                    CoCaCLviewModel.search("")
                }
                R.id.tvCoCaDayOf4 -> selectDay(4)
                R.id.tvCoCaDayOf5 -> selectDay(5)
                R.id.tvCoCaDayOf6 -> selectDay(6)
                R.id.tvCoCaDayOf7 -> selectDay(7)
                else ->{}
            }
        }
    }
    private fun selectDay(index:Int){
        for (day in weekList){
            day.textview.setBackgroundColor(Color.parseColor("#1C1B1F"))
        }
        weekList[index-1].textview.setBackgroundResource(R.color.teal_700)
        binding.viewModel?.textDate?.value = weekList[index-1].date.toString()
    }
    private class weekDay(var textview:android.widget.TextView, var date:LocalDate )
}