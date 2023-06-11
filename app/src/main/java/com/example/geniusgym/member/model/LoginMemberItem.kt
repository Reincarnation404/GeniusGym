package com.example.geniusgym.member.model
import java.io.Serializable

class LoginMemberItem (
    var m_id: String,
    var m_pwd: String,
    var m_name: String,
    var pass: Boolean? = null
        ):Serializable