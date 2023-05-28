package com.example.geniusgym.coach.calendarMemberList.model
import java.io.Serializable

class ExerciseItem (
    val memberId:String,
    val sportName: String,
    val sportUpdateTime:String,
    val sportWeight: String,
    val sportFreq : String,
    val sportSet: String,
    val sportCoach : String
    ):Serializable