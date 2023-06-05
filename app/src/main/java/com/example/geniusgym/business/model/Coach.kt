package com.example.geniusgym.business.model

import java.sql.Timestamp

class Coach(
    var c_id: String?,
    var bh_id: Int?,
    var c_pwd: String?,
    var c_name: String?,
    var c_gen: Int?,
    var c_cell: String?,
    var c_twid: String?,
    var c_addr: String?,
    var c_start_time: Timestamp?,
    var c_add_time: Timestamp?,
    var c_modi_time: Timestamp?,
    var b_id: String?,
    var c_email: String?,
    var c_intro: String?,
    var c_pic: Byte?,
    var c_sus: Boolean?
    ): java.io.Serializable

class testBuCoach(
    var c_id: String?,
    var bh_id: String?,    //原本是Int 要加判斷轉字串
    var c_pwd: String?,
    var c_name: String?,
    var c_gen: String?,     //原本是Int 要加判斷轉字串
    var c_cell: String?,
    var c_twid: String?,
    var c_addr: String?,
    var c_start_time: String?,
    var c_add_time: String?,
    var c_modi_time: String?,
    var b_id: String?,
    var c_email: String?,
    var c_intro: String?,
    var c_pic: Int?,
    var c_sus: Boolean?): java.io.Serializable