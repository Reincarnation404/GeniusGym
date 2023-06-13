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



     private var mepointlist = listOf<MePointBean>()
     val mepointitem : MutableLiveData<List<MePointBean>> by lazy { MutableLiveData<List<MePointBean>>() }
     init {
         loadItem()
     }
     private fun loadItem(){
          val mepointlist = mutableListOf<MePointBean>()

          mepointlist.add(
          MePointBean(
          ptid = "01",
          ptdate="2023-06-12",
          ptindecre = "-800點"
          ))

          mepointlist.add(
          MePointBean(
          ptid = "02",
          ptdate="2023-06-13",
          ptindecre = "-300點"
               ))

          mepointlist.add(
          MePointBean(
          ptid = "03",
          ptdate="2023-06-14",
          ptindecre= "-300點"
               ))

          mepointlist.add(
               MePointBean(
          ptid = "04",
          ptdate="2023-06-15",
          ptindecre = "-600點"
               ))

          mepointlist.add(
               MePointBean(
          ptid = "05",
          ptdate="2023-06-16",
           ptindecre = "+800點"
               ))
          this.mepointlist = mepointlist
          this.mepointitem.value = this.mepointlist

     }

}



