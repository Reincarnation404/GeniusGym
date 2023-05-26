package com.example.geniusgym.member.viewmodel

import androidx.lifecycle.ViewModel
import com.example.geniusgym.member.CoachBean

class MeCoachInfoViewModel : ViewModel() {

    private var _coachinfos: MutableList<CoachBean>? = null
    val coachinfos : List<CoachBean>? = _coachinfos

}