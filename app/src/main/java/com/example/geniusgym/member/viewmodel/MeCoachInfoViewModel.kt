package com.example.geniusgym.member.viewmodel

import androidx.lifecycle.ViewModel
import com.example.geniusgym.member.model.CoachBean

class MeCoachInfoViewModel : ViewModel() {


    private val _coachinfos: MutableList<CoachBean> by lazy { mutableListOf() }
    val coachinfos : List<CoachBean> = _coachinfos

    fun update(){
        _coachinfos.add(CoachBean())
    }
}