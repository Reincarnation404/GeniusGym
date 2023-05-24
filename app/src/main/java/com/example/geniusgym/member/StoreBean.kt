package com.example.geniusgym.member

import java.time.LocalDateTime

data class StoreBean(
    var bh_id : Int,
    var bh_name: String,
    var bh_address: String,
    var bh_cell: String,
    var bh_start_time: LocalDateTime,
    var bh_ed_time: LocalDateTime

)