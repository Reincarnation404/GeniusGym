package com.example.geniusgym.member.controller

import android.app.DatePickerDialog
import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMePersonalTrainBinding
import com.example.geniusgym.member.MePersonalTrainViewModel
import com.example.geniusgym.member.adapter.MeTrainShowAdapter
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import java.util.*

class MePersonalTrain : Fragment(), View.OnClickListener {
    // 延遲初始化 FragmentMePersonalTrainBinding 和 classlist
    private lateinit var binding: FragmentMePersonalTrainBinding
    private lateinit var classlist: MutableList<weeklyDay>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // 創建一個 MePersonalTrainViewModel 的實例，這裡使用 viewModels() 函數來創建 ViewModel
        val viewModel: MePersonalTrainViewModel by viewModels()

        binding = FragmentMePersonalTrainBinding.inflate(inflater, container, false)
        // 將 ViewModel 賦值給綁定的 viewModel 變數
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 獲取當前日期
        val date = LocalDate.now()
        // 獲取本週的第一天（星期一）
        val WeekDayOne = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))

        // 使用 binding 來設置 UI
        with(binding) {
            // 設置 classname 的值為當前日期的 ISO_LOCAL_DATE 格式
            viewmodel?.classname?.value =
                LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE).toString()

            // 創建 classlist，包含每個星期幾的日期對象
            classlist = mutableListOf(
                weeklyDay(tvPerTrainDay1, WeekDayOne),
                weeklyDay(tvPerTrainDay2, WeekDayOne.plusDays(1)),
                weeklyDay(tvPerTrainDay3, WeekDayOne.plusDays(2)),
                weeklyDay(tvPerTrainDay4, WeekDayOne.plusDays(3)),
                weeklyDay(tvPerTrainDay5, WeekDayOne.plusDays(4)),
                weeklyDay(tvPerTrainDay6, WeekDayOne.plusDays(5)),
                weeklyDay(tvPerTrainDay7, WeekDayOne.plusDays(6))
            )

            // 設置點擊監聽器
            tvPersonalTrainDate.setOnClickListener(this@MePersonalTrain)
            //迴圈， 每個 weeklyDay 物件都有一個 TextView 元素，代表一周的某一天。
            //為每個 TextView 元素設定點擊監聽器，並將當前的 MePersonalTrain Fragment 作為監聽器的實現
            for (textview in classlist) {
                textview.textview.setOnClickListener(this@MePersonalTrain)
            }

            // 獲取當前日期是星期幾，然後選中相對應的天數
            val dayOfWeek = date.dayOfWeek.value
            selectDays(dayOfWeek)

            // 設置 RecyclerView 的佈局管理器
            rvPersonalTrain.layoutManager = LinearLayoutManager(requireContext())
            // 觀察 metrainitem 數據並更新 RecyclerView 的適配器
            viewmodel?.metrainitem?.observe(viewLifecycleOwner){ items ->
            // 如果 RecyclerView 的適配器為空，則創建一個新的 MeTrainShowAdapter 並設置給 RecyclerView
                if (rvPersonalTrain.adapter == null){
                    rvPersonalTrain.adapter = MeTrainShowAdapter(items)
                }else {
                    // 如果 RecyclerView 已經有適配器，則調用適配器的 updateItem 方法更新數據
                    (rvPersonalTrain.adapter as MeTrainShowAdapter).updateItem(items)
                }
            }
        }
    }

    // 填充數字，如果數字小於10，則在前面加0
    private fun pad(number: Int): String {
        // 如果數字大於等於10，則直接將數字轉換為字串
        return if (number >= 10) {
            number.toString()
        } else {
            // 如果數字小於10，則在前面補0，例如：7 => "07"
            "0$number"
        }
    }

    // 點擊事件處理
    override fun onClick(v: View?) {
        with(binding) {
            // 當點擊了日期框
            when (v?.id) {
                R.id.tvPersonalTrainDate -> {
                    // 創建一個 Calendar 實例，用於顯示 DatePickerDialog
                    val calendar = Calendar.getInstance()
                    // 創建 DatePickerDialog，用戶選擇日期後觸發回調
                    val datePickerDialog = DatePickerDialog(
                        requireContext(),
                        { _, year, month, day ->
                            // 更新 ViewModel 中的日期相關數據
                            viewmodel?.classname?.value = "$year-${pad(month + 1)}-${pad(day)}"
                            viewmodel?.classtime?.value =
                                LocalDate.parse("$year-${pad(month + 1)}-${pad(day)}")

                            // 計算本週的第一天（星期一）的日期
                            val firstDayOfWeek = viewmodel?.classtime?.value?.with(
                                TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)
                            )

                            firstDayOfWeek?.let {
                                // 更新 classlist 中的日期
                                for (i in 0..6) {
                                    classlist[i].date = it.plusDays(i.toLong())
                                }
                            }

                            // 獲取所選日期的星期幾，並執行選擇相應天數的操作
                            val dayOfWeek = viewmodel?.classtime?.value?.dayOfWeek?.value
                            if (dayOfWeek != null) {
                                selectDays(dayOfWeek)
                            }
                        },

                        // 設置 DatePickerDialog 初始日期
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    )
                    // 顯示 DatePickerDialog
                    datePickerDialog.show()
                }
                // 點擊了某個具體的課程日期框
                R.id.tvPerTrainDay1 -> selectDays(1)
                R.id.tvPerTrainDay2 -> selectDays(2)
                R.id.tvPerTrainDay3 -> selectDays(3)
                R.id.tvPerTrainDay4 -> selectDays(4)
                R.id.tvPerTrainDay5 -> selectDays(5)
                R.id.tvPerTrainDay6 -> selectDays(6)
                R.id.tvPerTrainDay7 -> selectDays(7)
            }
            // 觀察 metrainitem 數據並更新 RecyclerView 的適配器
            viewmodel?.metrainitem?.observe(viewLifecycleOwner) { items ->
                if (rvPersonalTrain.adapter == null) {
                    // 如果適配器為空，則創建一個新的適配器並設置給 RecyclerView
                    rvPersonalTrain.adapter = MeTrainShowAdapter(items)
                } else {
                    // 否則，更新適配器中的數據
                    (rvPersonalTrain.adapter as MeTrainShowAdapter).updateItem(items)
                }
            }
        }
    }


    // 將所有日期框的背景色設置為指定顏色（R.color.teal_700）
    private fun selectDays(index: Int) {
        for (day in classlist) {
            day.textview.setBackgroundColor(Color.parseColor("#1C1B1F"))
        }
        classlist[index - 1].textview.setBackgroundResource(R.color.teal_700)
        // 更新 ViewModel 中的 classname 數據為被選中的日期
        binding.viewmodel?.classname?.value = classlist[index - 1].date.toString()
        // 調用 ViewModel 中的 search 方法，傳遞被選中的日期，可能是為了進行搜索相關的操作
        binding.viewmodel?.search(binding.viewmodel?.classname?.value)
    }

    class weeklyDay(var textview: TextView, var date: LocalDate)


}

