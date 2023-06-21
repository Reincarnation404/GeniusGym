package com.example.geniusgym.member.controller

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMeCheckoutBinding
import com.example.geniusgym.member.adapter.MeShoppingAdapter
import com.example.geniusgym.member.model.ClassInfo
import com.example.geniusgym.member.viewmodel.MeCheckoutViewModel
import com.example.geniusgym.sharedata.MeShareData
import com.example.geniusgym.util.IOImpl
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject

class MeCheckoutFragment : Fragment() {

    private val viewModel: MeCheckoutViewModel by viewModels()
    private lateinit var binding : FragmentMeCheckoutBinding
    private lateinit var containerDialog: ViewGroup
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeCheckoutBinding.inflate(LayoutInflater.from(requireContext()))
        containerDialog = container!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments?.getBoolean("directBuyFromCart") == true){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                arguments?.getParcelableArrayList("buyItems", ClassInfo::class.java)?.let {
                    viewModel.buylist = it
                }
            } else {
                val buylist : ArrayList<ClassInfo> = arguments?.getParcelableArrayList("buyItems")?: ArrayList()
                viewModel.buylist = buylist
            }
            val total = viewModel.calculateTotalCost()
            with(binding){
                val adapter = MeShoppingAdapter(viewModel.buylist)
                adapter.unclickable()
                meRecycleShoppingCart.adapter = adapter
                meRecycleShoppingCart.layoutManager = LinearLayoutManager(requireContext())
                tvMeShoppingPointNeed.text = total.toString()
                meShoppingPointHave.text = MeShareData.personPoint.toString()
                btMeShoppingCheckout.setOnClickListener(directcheckoutlistener)
                btCheckoutSaveMoney.setOnClickListener {
                    Navigation.findNavController(it).navigate(R.id.action_meCheckoutFragment_to_meBuyPointsFragment)
                }
            }
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                arguments?.getParcelableArrayList("buyItems", ClassInfo::class.java)?.let {
                    viewModel.buylist = it
                }
            }else{
                val buylist : ArrayList<ClassInfo> = arguments?.getParcelableArrayList("buyItems")?: ArrayList()
                viewModel.buylist = buylist
            }
            with(binding){
                val adapter = MeShoppingAdapter(viewModel.buylist)
                adapter.unclickable()
                meRecycleShoppingCart.adapter = adapter
                meRecycleShoppingCart.layoutManager = LinearLayoutManager(requireContext())
                val total = viewModel.calculateTotalCost()
                binding.tvMeShoppingPointNeed.text = total.toString()
                binding.meShoppingPointHave.text = MeShareData.personPoint.toString()

                btMeShoppingCheckout.setOnClickListener(checkoutlistener)
                btCheckoutSaveMoney.setOnClickListener {
                    Navigation.findNavController(it).navigate(R.id.action_meCheckoutFragment_to_meBuyPointsFragment)
                }
            }
        }
    }

    private val directcheckoutlistener = View.OnClickListener {
        val total = binding.tvMeShoppingPointNeed.text.toString().toInt()
        //      TODO: 需要更正成修改後端
        MeShareData.personPoint -= total
        //      結帳的dialog
        val dialogCheck = viewModel.checkoutDialog(requireContext(), containerDialog, binding)
        //      結帳的動畫
        val dialogCheckingAnim = viewModel.checkingDialog(dialogCheck, requireContext())
        dialogCheckingAnim.show()
    }

    private val checkoutlistener = View.OnClickListener {
        val total = binding.tvMeShoppingPointNeed.text.toString().toInt()
        if (MeShareData.personPoint < total){
            binding.tvMeShoppingError.text = getString(R.string.meShoppoingCheckoutNoMony)
            return@OnClickListener
        }else{
//      TODO: 需要更正成修改後端
            MeShareData.personPoint -= total
//            讀取資料
            val cartListText = IOImpl.Internal(requireContext()).loadArrayFile("meShoppingCart",
                IOImpl.Mode.MODE_MEMORY, true)
            val cartList : MutableList<ClassInfo>  = mutableListOf()
            cartListText?.forEach {
                val jsonObject = Gson().fromJson(it, JsonObject::class.java)
                val classInfo = ClassInfo()
                with(jsonObject){
                    classInfo.sc_id = get("sc_id").asInt
                    classInfo.ci_name = get("ci_name").asString
                    classInfo.c_id = get("c_id").asString
                    classInfo.ci_date = get("c_date").asString
                    classInfo.ci_cost = get("c_cost").asInt
                    classInfo.ci_ed_time = get("ci_ed_time").asString
                    classInfo.ci_start_time = get("ci_ed_time").asString
                }
                cartList.add(classInfo)
            }
//            移除已結帳的所有物件
            viewModel.buylist.forEach{
                if (cartList.contains(it)){
                    cartList.remove(it)
                }
            }
//            在將未結帳的部分存回內存
            val jsonArray = JsonArray()
            cartList.forEach{classde ->
                val jsonObject = JsonObject()
                jsonObject.addProperty("c_id", classde.c_id)
                jsonObject.addProperty("c_date", classde .ci_date)
                jsonObject.addProperty("sc_id", classde.sc_id)
                jsonObject.addProperty("ci_name", classde.ci_name)
                jsonObject.addProperty("c_cost", classde.ci_cost.toString())
                jsonObject.addProperty("ci_start_time", classde.ci_start_time)
                jsonObject.addProperty("ci_ed_time", classde.ci_ed_time)
                jsonArray.add(jsonObject)
            }
            IOImpl.Internal(requireContext()).saveFile(jsonArray, "meShoppingCart", IOImpl.Mode.MODE_MEMORY, true)
        }

//      結帳的dialog
        val dialogCheck = viewModel.checkoutDialog(requireContext(), containerDialog, binding)
//      結帳的動畫
        val dialogCheckingAnim = viewModel.checkingDialog(dialogCheck, requireContext())
        dialogCheckingAnim.show()

    }

}