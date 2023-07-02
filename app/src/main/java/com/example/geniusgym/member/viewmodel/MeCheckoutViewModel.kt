package com.example.geniusgym.member.viewmodel

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.geniusgym.R
import com.example.geniusgym.databinding.DialogMeCheckoutBinding
import com.example.geniusgym.databinding.FragmentMeCheckoutBinding
import com.example.geniusgym.member.model.ClassInfo
import com.example.geniusgym.member.model.Point
import com.example.geniusgym.sharedata.MeShareData
import tw.idv.william.androidwebserver.core.service.requestTask

class MeCheckoutViewModel : ViewModel() {
    var buylist : ArrayList<ClassInfo> = ArrayList()

    var mePoint = Point()

    fun getPoint(){
        val point = requestTask<Point>(MeShareData.javaWebUrl + "", "GET")
        point?.let {
            mePoint = it
        }
    }

    fun calculateTotalCost() : Int{
        var total = 0
        buylist.forEach{ClassInfo ->
            ClassInfo.ci_cost?.let {
                total += it
            }
        }
        return total
    }

    fun changeMemberPoint(point : Int){
//        requestTask<>()
    }

    fun checkoutDialog(context : Context, containerDialog: ViewGroup, binding : FragmentMeCheckoutBinding) : Dialog {
        //                結帳成功畫面
        val dialog = Dialog(context)
        dialog.setCancelable(false)
        val bindingDialog = DialogMeCheckoutBinding.inflate(LayoutInflater.from(context), containerDialog, false)
        val window = dialog.window
        window?.setContentView(bindingDialog.root)
        val lp = window?.attributes
        lp?.width = WindowManager.LayoutParams.MATCH_PARENT
        lp?.height = WindowManager.LayoutParams.MATCH_PARENT
        bindingDialog.btMeShoppingBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_meCheckoutFragment_to_meShoppingFragment)
            dialog.dismiss()
        }
        bindingDialog.btMeGoToShoppingRecord.setOnClickListener {
            dialog.dismiss()
        }
        return dialog
    }

    fun checkingDialog(dialogCheck: Dialog, context: Context) : Dialog{
        //                結帳中畫面
        val dialoganim = Dialog(context)
        val windowanim = dialoganim.window
        windowanim?.setContentView(R.layout.dialog_me_loading)
//        動畫
        val iv : ImageView? = windowanim?.findViewById(R.id.ivMeShoppingLoading)
        iv?.setImageResource(R.drawable.loading)
        val anim = iv?.drawable as AnimationDrawable
        anim.start()

        val timer = object : CountDownTimer(2000, 1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                dialoganim.dismiss()
                dialogCheck.show()
            }
        }
        timer.start()
        return dialoganim
    }

}