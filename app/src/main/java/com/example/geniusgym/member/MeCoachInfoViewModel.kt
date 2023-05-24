package com.example.geniusgym.member

import androidx.lifecycle.ViewModel

class MeCoachInfoViewModel : ViewModel() {

    private var _coachinfos: MutableList<CoachBean>? = null
    val coachinfos : List<CoachBean>? = _coachinfos

}