package com.example.geniusgym.notification

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.notification.model.Notification

class NotificationViewModel : ViewModel() {
    val items: MutableLiveData<Notification> by lazy { MutableLiveData<Notification>() }
    val item: MutableLiveData<List<Notification>> by lazy { MutableLiveData<List<Notification>>() }

    init {
        load()
    }
    private fun load() {
        val notificationList: MutableList<Notification> = mutableListOf<Notification>()

        notificationList.add(Notification(1,"m123456", 2, 600, "2023/06/16"))
        notificationList.add(Notification(2, "m123456", 1, 300, "2023/06/15"))
        notificationList.add(Notification(3, "m123456", 5, 1450, "2023/06/14"))

        this.item.value = notificationList
    }
}