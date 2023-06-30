package com.example.geniusgym.member.controller

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMeShopCartBinding
import com.example.geniusgym.member.adapter.MeShoppingCartAdapter
import com.example.geniusgym.member.model.ClassInfo
import com.example.geniusgym.member.viewmodel.MeShopCartViewModel
import com.example.geniusgym.util.IOImpl
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken

class MeShopCartFragment : Fragment() {

    private val viewModel: MeShopCartViewModel by viewModels()
    private lateinit var binding: FragmentMeShopCartBinding
    private var directBuy : Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeShopCartBinding.inflate(LayoutInflater.from(requireContext()))

        directBuy = arguments?.getBoolean("direct?") == true
//        判定是直接購買還是點擊購物車
        if (directBuy){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                val list : MutableList<ClassInfo> = mutableListOf()
                arguments?.getSerializable("classinfo", ClassInfo::class.java)
                    ?.let {
                        list.add(it)
                    }
                viewModel.classInfos.value = list
            }else{
                val list = mutableListOf<ClassInfo>()
                list.add(arguments?.getSerializable("classinfo") as ClassInfo)
                viewModel.classInfos.value = list
            }
        }else{
            val cartListText = IOImpl.Internal(requireContext()).loadArrayFile("meShoppingCart",IOImpl.Mode.MODE_MEMORY, true)
            val type = object : TypeToken<MutableList<ClassInfo>>(){}.type
            val cartList = Gson().fromJson<MutableList<ClassInfo>>(cartListText, type)
            viewModel.classInfos.value = cartList
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){

            val adapter = MeShoppingCartAdapter(viewModel.classInfos.value!!)
            Log.d("CartAdapter", viewModel.classInfos.value.toString())
            rcMeShoppingCart.adapter = adapter
            rcMeShoppingCart.layoutManager = LinearLayoutManager(requireContext())
            cbMeShoppingAllCheck.setOnClickListener {
                if (cbMeShoppingAllCheck.isChecked){
                    adapter.allCheck()
                }else{
                    adapter.clear()
                }

            }

            btMeShoppingConfirmBuy.setOnClickListener {
                val buyList : ArrayList<ClassInfo> = ArrayList(adapter.getCheckSet())
                if (buyList.isEmpty()){
                    return@setOnClickListener
                }
                val bundle = Bundle()
                bundle.putParcelableArrayList("buyItems", buyList)
                bundle.putBoolean("directBuyFromCart", directBuy)
                Navigation.findNavController(it).navigate(R.id.action_meShopCartFragment_to_meCheckoutFragment, bundle)
            }
        }
    }
}