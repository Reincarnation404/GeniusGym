package com.example.geniusgym.util

import android.provider.Settings.System.getString
import android.widget.Toast
import com.example.geniusgym.R
import com.example.geniusgym.sharedata.MeShareData.javaWebUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.ConnectException
import java.net.HttpURLConnection
import java.net.URL
class WebRequestSpencer {
    suspend fun httpGet(
        servlet: String,
    ): String {
        var jsonIn = ""
        val url = javaWebUrl + servlet
        withContext(Dispatchers.IO) {
                (URL(url).openConnection() as? HttpURLConnection)?.run {
                    if (responseCode == 200) {
                        inputStream.bufferedReader().useLines { lines ->
                            jsonIn = lines.fold("") { text, line -> "$text$line" }
                        }
                    }
                }
        }
        return jsonIn
    }

    suspend fun httpPost(
        servlet: String,
        jsonOut: String
    ): String {
        val url = javaWebUrl + servlet
        var jsonIn = ""
        withContext(Dispatchers.IO) {
            (URL(url).openConnection() as? HttpURLConnection)?.run {
                doInput = true
                doOutput = true
                setChunkedStreamingMode(0)
                useCaches = false
                requestMethod = "POST"
                setRequestProperty("content-type", "application/json")
                setRequestProperty("charset", "utf-8")

                outputStream.bufferedWriter().use {
                    it.write(jsonOut)
                }
                if (responseCode == 200) {
                    inputStream.bufferedReader().useLines { lines ->
                        jsonIn = lines.fold("") { text, line -> "$text$line" }
                    }
                }
            }
        }
        return jsonIn
    }
}