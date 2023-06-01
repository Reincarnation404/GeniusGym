package com.example.geniusgym.business.model

import java.sql.Timestamp

class BuBusiness(
    var b_id: String?,
    var bh_id: Int?,
    var b_pwd: String?,
    var b_name: String?,
    var b_gen: Int?,
    var b_cell: String?,
    var b_twid: String?,
    var b_addr: String?,
    var b_start_time: Timestamp?,
    var b_add_time: Timestamp?,
    var b_modi_time: Timestamp?,
    var b_modi_id: String?,
    var b_email: String?,
    var b_intro: String?,
    var b_pic: Byte?,
    var b_sus: Boolean?
    ): java.io.Serializable

class testBuBusiness(
    var b_id: String?,
    var bh_id: String?,   //原本是Int 要加判斷轉字串
    var b_pwd: String?,
    var b_name: String?,
    var b_gen: String?,   //原本是Int 要加判斷轉字串
    var b_cell: String?,
    var b_twid: String?,
    var b_addr: String?,
    var b_start_date: String?,
    var b_add_time: String?,
    var b_modi_time: String?,
    var b_modi_id: String?,
    var b_email: String?,
    var b_pic: Int?,
    var b_sus: Boolean?
    ): java.io.Serializable