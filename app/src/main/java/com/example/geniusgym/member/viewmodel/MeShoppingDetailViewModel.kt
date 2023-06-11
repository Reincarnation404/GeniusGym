package com.example.geniusgym.member.viewmodel

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.Navigation
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMeShoppingDetailBinding
import com.example.geniusgym.member.model.ClassInfo
import com.example.geniusgym.util.IOImpl
import com.example.geniusgym.util.IOImpl.Internal
import com.google.gson.JsonArray
import com.google.gson.JsonObject

class MeShoppingDetailViewModel : ViewModel() {

    var _clasinfo : ClassInfo? = null

    fun update(info : ClassInfo){
        _clasinfo = info
    }

    fun setTextToCell(binding: FragmentMeShoppingDetailBinding){
        with(binding){
            include.tvMeCoachName.text = _clasinfo?.c_id
            include.tvMeLessonDate.text = _clasinfo?.ci_date
            include.tvMeLessonName.text
            include.tvMePoint.text = _clasinfo?.ci_cost.toString()
            val timeText = _clasinfo?.ci_start_time + "~" +  _clasinfo?.ci_ed_time
            include.tvMeLessonTime.text = timeText
        }
    }

    fun putToShoppingCart(view : View){
        val internal = Internal(view.context)
        var jsonArray = internal.loadArrayFile("meShoppingCart", IOImpl.Mode.MODE_MEMORY, true)
        if (jsonArray == null){
            jsonArray = JsonArray()
        }
        val jsonObject = JsonObject()
        jsonObject.addProperty("c_id", _clasinfo?.c_id)
        jsonObject.addProperty("c_date", _clasinfo?.ci_date)
//        jsonObject.addProperty("c_id", _clasinfo?.c_id)
        jsonObject.addProperty("c_cost", _clasinfo?.ci_cost.toString())
        jsonObject.addProperty("c_timeText", _clasinfo?.ci_start_time + "~" +  _clasinfo?.ci_ed_time)
        jsonArray.add(jsonObject)
        try {
            internal.saveFile(jsonArray, "meShoppingCart", IOImpl.Mode.MODE_MEMORY, true)
            Toast.makeText(view.context, "添加成功!!", Toast.LENGTH_SHORT).show()
        }catch (e : Exception){
            Toast.makeText(view.context, "添加失敗，請在試一次", Toast.LENGTH_SHORT).show()
        }
    }

    fun directBuy(view: View){
        val bundle = Bundle()
        bundle.putSerializable("classinfo", _clasinfo)
        bundle.putSerializable("direct?", false)
        Navigation.findNavController(view).navigate(R.id.action_meShoppingDetailFragment_to_meShopCartFragment, bundle)
    }







}