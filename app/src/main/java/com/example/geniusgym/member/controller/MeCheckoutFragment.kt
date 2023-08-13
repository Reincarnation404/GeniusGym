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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelableArrayList("buyItems", ClassInfo::class.java)?.let {
                viewModel.buylist = it
            }
        }else{
            val buylist : ArrayList<ClassInfo> = arguments?.getParcelableArrayList("buyItems")?: ArrayList()
            viewModel.buylist = buylist
        }
        val adapter = MeShoppingAdapter(viewModel.buylist)
        setController(binding, adapter)

        if (arguments?.getBoolean("directBuyFromCart") == true){
            binding.btMeShoppingCheckout.setOnClickListener(directcheckoutlistener)
        }else{
            binding.btMeShoppingCheckout.setOnClickListener(checkoutlistener)
        }
        binding.btCheckoutSaveMoney.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_meCheckoutFragment_to_meBuyPointsFragment)
        }
    }

    private fun setController(binding: FragmentMeCheckoutBinding, adapter: MeShoppingAdapter){
        with(binding){
            adapter.unclickable()
            meRecycleShoppingCart.adapter = adapter
            meRecycleShoppingCart.layoutManager = LinearLayoutManager(requireContext())
            val total = viewModel.calculateTotalCost()
            tvMeShoppingPointNeed.text = total.toString()
            viewModel.getPoint()
//            meShoppingPointHave.text = MeShareData.personPoint.toString()
            meShoppingPointHave.text = viewModel.mePoint.p_left.toString()
        }
    }



    private val directcheckoutlistener = View.OnClickListener {
        //      結帳的dialog
        val dialogCheck = viewModel.checkoutDialog(requireContext(), containerDialog, binding)
        //      結帳的動畫
        val dialogCheckingAnim = viewModel.checkingDialog(dialogCheck, requireContext())
        dialogCheckingAnim.show()
    }

    private val checkoutlistener = View.OnClickListener {
        val total = binding.tvMeShoppingPointNeed.text.toString().toInt()
        if (viewModel.mePoint.p_left < total){
            binding.tvMeShoppingError.text = getString(R.string.meShoppoingCheckoutNoMony)
            return@OnClickListener
        }
//      結帳的dialog
        val dialogCheck = viewModel.checkoutDialog(requireContext(), containerDialog, binding)
//      結帳的動畫
        val dialogCheckingAnim = viewModel.checkingDialog(dialogCheck, requireContext())
        dialogCheckingAnim.show()

    }



}