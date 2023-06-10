package com.example.geniusgym.member.model

import java.sql.Timestamp
import java.time.LocalDateTime

data class ClassInfo(
    val ci_id: Int = -1,
    val ci_name: String = "阿姆斯特壤螺旋有氧舞蹈",
    val ci_start_time: String = "09:00",
    val ci_ed_time: String = "18:00",
    val ci_place: String = "緯育分店",
    val ci_cost: Int? = 99999999,
    val sc_id : Int? = 1,
//    val ci_date: Timestamp = Timestamp.valueOf(LocalDateTime.now().toString()),
    val ci_date: String = "2023/12/31",
    val ci_text: String = "本課程希望大家能認真學習",
    val ci_limit: Int = 87,
//    val ci_add_time: Timestamp = Timestamp.valueOf(LocalDateTime.now().toString()),
    val bh_id: Int = -1,
//    val ci_regi_time: Timestamp = Timestamp.valueOf(LocalDateTime.now().toString()),
//    val ci_regi_ed_time: Timestamp = Timestamp.valueOf(LocalDateTime.now().toString()),
    val c_id : String = "我是誰我在哪",
    val b_id: String = "123456"
) : java.io.Serializable