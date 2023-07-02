package com.example.geniusgym.util

import android.view.View
import android.view.View.OnClickListener
import com.example.geniusgym.sharedata.MeShareData
import kotlinx.coroutines.*

abstract class OnRepeatClickListener : OnClickListener {

    override fun onClick(v: View?) {
        v?.isClickable = false
        onSingleClick(v)
        val mainScope = MainScope()
        mainScope.launch {
            cantClick(v)
        }
        mainScope.cancel()
//        val nowTime = System.currentTimeMillis()
//        if ((nowTime - mLastClickTime) > timeInterval || mLastClickTime == 0L){
//            onSingleClick(v)
//        }
//        mLastClickTime = nowTime
    }

    protected abstract fun onSingleClick(v : View?)

    private suspend fun cantClick(v: View?){
        withContext(Dispatchers.IO){
            delay(MeShareData.RepeatClickTime)
            withContext(Dispatchers.Main){
                v?.isClickable = true
            }
        }
    }

}