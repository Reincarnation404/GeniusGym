package com.example.geniusgym.util
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class webRequest_spencer {
    suspend fun httpGet(
        url: String
    ): String {
        var jsonIn = ""
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
        url: String,
        jsonOut: String
    ): String {

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
                    it.write(jsonOut) }
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