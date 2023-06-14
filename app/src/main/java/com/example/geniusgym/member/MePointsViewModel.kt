package com.example.geniusgym.member

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.member.model.MePointBean
import com.example.geniusgym.member.model.MetrainBean
import java.time.LocalDate

class MePointsViewModel : ViewModel() {
     private val PointSum = MutableLiveData<Int>()
     val pointsum : LiveData<Int> get() = PointSum
     fun addToPointSum(points: Int){
          PointSum.value = (PointSum.value ?: 0) + points
     }

     val mepointitem : MutableList<MePointBean> = mutableListOf()
     init {
         loadItem()
     }
     private fun loadItem(){

          mepointitem.add(
          MePointBean(
          ptid = "01",
          ptdate="2023-06-12",
          ptindecre = "-800點"
          ))

          mepointitem.add(
          MePointBean(
          ptid = "02",
          ptdate="2023-06-13",
          ptindecre = "-300點"
               ))

          mepointitem.add(
          MePointBean(
          ptid = "03",
          ptdate="2023-06-14",
          ptindecre= "-300點"
               ))

          mepointitem.add(
               MePointBean(
          ptid = "04",
          ptdate="2023-06-15",
          ptindecre = "-600點"
               ))

          mepointitem.add(
               MePointBean(
          ptid = "05",
          ptdate="2023-06-16",
           ptindecre = "+800點"
               ))


     }

}



