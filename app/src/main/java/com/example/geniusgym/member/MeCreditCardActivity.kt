package com.example.geniusgym.member

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import com.example.geniusgym.R
import com.example.geniusgym.databinding.ActivityMeCreditCardBinding
import tech.cherri.tpdirect.api.TPDCard
import tech.cherri.tpdirect.api.TPDGooglePay
import tech.cherri.tpdirect.api.TPDServerType
import tech.cherri.tpdirect.api.TPDSetup

class MeCreditCardActivity : AppCompatActivity() {
    private val myTag = "TAG_${javaClass.simpleName}"
    private val requestCode = 101
    private lateinit var binding: ActivityMeCreditCardBinding
    private lateinit var tpdGooglePay: TPDGooglePay
    private lateinit var btGooglePay: RelativeLayout
    // 測試環境網址
    private val sandbox = "https://sandbox.tappaysdk.com/"

    // 取得Prime後跟TapPay確定支付的連線網址
    private val primeUrl = "tpc/payment/pay-by-prime"

    // 信用卡種類
    private val cardTypes = arrayOf(
        TPDCard.CardType.Visa,
        TPDCard.CardType.MasterCard,
        TPDCard.CardType.JCB,
        TPDCard.CardType.AmericanExpress
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_me_credit_card)

        Log.d(myTag, "SDK version is " + TPDSetup.getVersion())
        TPDSetup.initInstance(
            this,
            getString(R.string.TapPay_AppID).toInt(),
            getString(R.string.TapPay_AppKey),
            TPDServerType.Sandbox
        )
        // include元件必須使用findViewById()取得，而不能使用binding物件取得
        btGooglePay = findViewById(R.id.btGooglePay)
        /* 先將Google Pay按鈕設定為不可點擊，
           之後執行prepareGooglePay()檢查可使用Google Pay時再改成可點擊 */
        btGooglePay.isEnabled = false
        prepareGooglePay()
        // 先將「確認付款」按鈕設定為不可點擊，
        // 之後onActivityResult()取得本機支付資訊後再改成可點擊
        binding.btConfirm.isEnabled = false



    }
}