package com.example.geniusgym.business.model

import java.sql.Timestamp

class BuMember(
    var m_id: String,
    var m_pwd: String,
    var m_name: String,
    var m_gen: Int,
    var m_cell: String,
    var m_twid: String,
    var m_addr: String,
    var m_add_time: Timestamp,
    var m_ed_time: Timestamp,
    var m_modi_time: Timestamp,
    var b_id: String,
    var m_email: String,
    var m_pic: Byte,
    var m_sus: Boolean
    ): java.io.Serializable

class testBuMember(
    var m_id: String?,
    var m_pwd: String?,
    var m_name: String?,
    var m_gen: String?,   //原本是Int 要加判斷轉字串
    var m_cell: String?,
    var m_twid: String?,
    var m_addr: String?,
    var m_add_time: String?,
    var m_ed_time: String?,
    var m_modi_time: String?,
    var b_id: String?,
    var m_email: String?,
    var m_pic: Int?,
    var m_sus: Boolean?): java.io.Serializable