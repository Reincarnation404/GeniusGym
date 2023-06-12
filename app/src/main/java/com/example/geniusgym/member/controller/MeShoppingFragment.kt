package com.example.geniusgym.member.controller

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ImageSpan
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geniusgym.R
import com.example.geniusgym.databinding.DialogShopitemBinding
import com.example.geniusgym.databinding.FragmentMeShoppingBinding
import com.example.geniusgym.member.adapter.MeShoppingAdapter
import com.example.geniusgym.member.adapter.MeShoppingSearchExpandableListViewAdapter
import com.example.geniusgym.member.viewmodel.MeShoppingViewModel
import com.example.geniusgym.sharedata.MeShareData

class MeShoppingFragment : Fragment() {

    private lateinit var binding : FragmentMeShoppingBinding
    private lateinit var containerView: ViewGroup
    private lateinit var meAdapter: MeShoppingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        containerView = container!!
        val viewModel: MeShoppingViewModel = ViewModelProvider(this)[MeShoppingViewModel::class.java]
        binding = FragmentMeShoppingBinding.inflate(LayoutInflater.from(requireContext()))
        binding.viewModel = viewModel
//        TODO: 資料重複、品項沒有間隔
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMenu()
        Log.d("test2", MeShareData.branchName)
        with(binding){
            viewModel?.branchName?.value = MeShareData.branchName
            meShoppingRecycle.layoutManager = LinearLayoutManager(requireContext())
            meAdapter = viewModel!!.shopitems.value?.let {
                Log.d( "adapter", it.toString())
                MeShoppingAdapter(
                    it
                )
            }!!
            meShoppingRecycle.adapter = meAdapter
//          TODO: 將Fragmet設定手勢，只要由左向右滑就判定要打開drawlayout

//            root.onTouchEvent()
        }

    }



    private fun setMenu(){
        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_shop, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when(menuItem.itemId){

                    R.id.meShoppingCartIcon -> {
                        Navigation.findNavController(binding.root).navigate(R.id.action_meShoppingFragment_to_meShopCartFragment)
                    }

                    R.id.meShoppingFilterIcon -> {
                        val dialog = createDiaglog(requireContext())
                        dialog.show()
                    }


                }
                return false
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    @SuppressLint("ResourceType")
    private fun createDiaglog(context : Context) : Dialog{
        val dialog = Dialog(context)
        val bindingDialog : DialogShopitemBinding = DialogShopitemBinding.inflate(LayoutInflater.from(context))

        //        設定dialog
        val window = dialog.window
        window?.setGravity(Gravity.CENTER)
        window?.setContentView(bindingDialog.root)
        window?.setWindowAnimations(R.xml.dialog_style)
//        TODO:動畫執行失敗、設定dialog大小失敗
        val lp = window?.attributes
//        lp?.width = WindowManager.LayoutParams.MATCH_PARENT
//        lp?.height = containerView.layoutParams.height



        //        設定提示文字附加圖片
        val imageHint = ImageSpan(context, R.drawable.baseline_search_24)
        val spannableString = SpannableString(context.getString(R.string.meSearchViewLessonName))
        spannableString.setSpan(imageHint, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        bindingDialog.edtMeShoppingSearch.hint = spannableString
        val adapter =
            MeShoppingSearchExpandableListViewAdapter(
                requireContext(),
                binding.viewModel!!.sportbigcats,
                binding.viewModel!!.sportcats
            )
        bindingDialog.elvMeShopping.setAdapter(adapter)
        bindingDialog.btnMeShoppingConfirm.setOnClickListener {
            val filterId = adapter.getAllKindId()
            binding.viewModel?.search(filterId, bindingDialog.edtMeShoppingSearch.text.toString())
            binding.viewModel?.shopitems?.value?.let { it1 -> meAdapter.update(it1) }
            adapter.clearSet()
            dialog.dismiss()
        }

        bindingDialog.btnMeShoppingCancel.setOnClickListener {
            adapter.clearSet()
            dialog.dismiss()
        }
        return dialog
    }



//    ImageSpan imageHint = new ImageSpan(mContext, R.drawable.icon_hint);
//    SpannableString spannableString = new SpannableString("_I'm the hint");
//    spannableString.setSpan(imageHint, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//    mEditor.setHint(spannableString);
}