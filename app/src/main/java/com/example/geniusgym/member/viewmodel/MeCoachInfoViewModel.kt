package com.example.geniusgym.member.viewmodel

import androidx.lifecycle.ViewModel
import com.example.geniusgym.member.model.CoachBean

class MeCoachInfoViewModel : ViewModel() {


    private val _coachinfos: MutableList<CoachBean> by lazy { mutableListOf() }
    val coachinfos : List<CoachBean> = _coachinfos

//    fun update(){
//        _coachinfos.add(CoachBean())
//    }

    init {
        update()
    }
    fun update(){

        _coachinfos.add(CoachBean("王曉明", null, 1, "大家好，我是博博，我的專業是教大家如何用螺旋突刺，在家裡可以把所有東西刺的不要不要的"))
        _coachinfos.add(CoachBean("張小喵", null, 0, "大家好，我是喵喵，喵~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"))
        _coachinfos.add(CoachBean("余阿汪", null, 1, "大家好，我是汪汪，汪汪汪汪汪汪汪汪汪汪汪汪汪汪汪汪汪汪汪汪汪汪汪汪"))
        _coachinfos.add(CoachBean("Andy",null, 1, "不要問我，我不知道，你是誰?我是誰?"))
        _coachinfos.add(CoachBean("Stephen", null, 1, "您好，我是Android小幫手，只要出什麼問題，記得第一步就是把專案重開就會好了"))
        _coachinfos.add(CoachBean("Sam", null, 1, "抱歉我走錯地方了"))

    }
}