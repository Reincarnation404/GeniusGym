package com.example.geniusgym.member.model

import java.sql.Timestamp

data class ClassInfo(
    val ci_id: Int?,
    val ci_name: String?,
    val ci_start_time: Timestamp?,
    val ci_ed_time: Timestamp?,
    val ci_place: String?,
    val ci_cost: Int?,
    val ci_date: Timestamp?,
    val ci_text: String?,
    val ci_limit: Int?,
    val ci_add_time: Timestamp?,
    val bh_id: Int?,
    val ci_regi_time: Timestamp?,
    val ci_regi_ed_time: Timestamp?,
    val b_id: String?
)