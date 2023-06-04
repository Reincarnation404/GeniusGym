package com.example.geniusgym.coach.calendarMemberListDetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberList.model.BodyDataItem
import com.example.geniusgym.coach.calendarMemberList.model.ExerciseItem
import java.time.LocalDate

class CoCalenderMemberStaticViewModel : ViewModel() {
 //   val memberName : MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val memberStatistic : MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val textDate: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val date: MutableLiveData<LocalDate> by lazy { MutableLiveData<LocalDate>() }
    private var itemList = listOf<ExerciseItem>()
    val exerciseItems: MutableLiveData<List<ExerciseItem>> by lazy { MutableLiveData<List<ExerciseItem>>() }
    val exerciseItem: MutableLiveData<ExerciseItem> by lazy { MutableLiveData<ExerciseItem>() }
    private var exerciseLists = listOf<ExerciseItem>()
    init {
        load()
    }
    fun search(input: String?) {
        val searchList = if (input == null || input.isEmpty()) {
            println("input == null || input.isEmpty()")
            itemList
        } else {
            println("!input == null && !input.isEmpty()")
            itemList.filter { item ->
                searchItem(item, input.trim())
            }
        }
        exerciseItems.value = searchList
    }

    private fun searchItem(item: ExerciseItem, searchText: String): Boolean {
        val answers = item.sportUpdateTime.contains(searchText, ignoreCase = true)
        return answers
    }
    private fun load(){
        val exerciseList = mutableListOf<ExerciseItem>()
        memberStatistic.value ="生理性別：戰鬥直升機\n年齡：19\n身高：169 cm\n體重：169 kg\n體脂：40 %"
        exerciseList.add(
            ExerciseItem(
                memberId = "R05221016",
                sportName = "旋轉無養",
                sportUpdateTime = "2023-05-30 23:59:59",
                sportWeight = "100",
                sportFreq = "4",
                sportSet = "3",
                sportCoach = "田聖潔"
            )
        )
        exerciseList.add(
            ExerciseItem(
                memberId = "R05221017",
                sportName = "旋轉有養",
                sportUpdateTime = "2023-05-30 23:59:59",
                sportWeight = "100",
                sportFreq = "4",
                sportSet = "3",
                sportCoach = "聖潔聖潔"
            )
        )

        this.itemList =  exerciseList
        this.exerciseItems.value =  this.itemList
    }
}