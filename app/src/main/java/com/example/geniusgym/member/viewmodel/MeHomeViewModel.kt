package com.example.geniusgym.member.viewmodel

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.sharedata.MeShareData
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class MeHomeViewModel : ViewModel() {

    fun getUrlFromNow() : String{
        val localTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val time = formatter.format(localTime)
        Log.d("time", time)
        val urlstring = MeShareData.javaWebUrl + "member/home?message="
        return try {
                    val str = URLEncoder.encode(time, java.nio.charset.StandardCharsets.UTF_8.toString())
                    Log.d("timereturn", str)
                    urlstring + str
                }catch (e : UnsupportedEncodingException){
                    e.printStackTrace()
                    ""
                }
    }

    fun createPic(url : String) : Bitmap {
        val encoder = BarcodeEncoder()
        return encoder.encodeBitmap(url, BarcodeFormat.QR_CODE, 380, 380)
    }

}