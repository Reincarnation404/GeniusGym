package com.example.geniusgym.notification.model

import java.sql.Timestamp
import java.io.Serializable

class Notification (
    var or_id: Int?,
    var m_id: String?,
    var or_amt: Short?,
    var or_total: Short?,
    var or_buy_time: Timestamp?
        ):Serializable