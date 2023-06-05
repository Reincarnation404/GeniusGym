package com.example.geniusgym.coach.calendarMemberListDetail.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter.ofPattern

class SportRecordItem(
    var m_id: String?,         // 會員 ID
    var m_name: String?,         // 會員名字
    var sc_id: String,         // 運動 ID
    var sc_name: String?,        // 運動名字
    var sc_weight: String? = "", // 重量
    var sc_freq: String? = "",   // 次數
    var c_id: String = "",      // 教練 ID
    var updateTime: String?
)

class SportRecordBigItem(
    var data: MutableList< SportRecordItem>,
    var m_id: String?,
    var name: String?,
    var time: String?,
    var count: String?
)