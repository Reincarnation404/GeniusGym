package com.example.geniusgym.business

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentBuAddNotificationBinding

class BuAddNotificationFragment : Fragment() {
    private lateinit var binding: FragmentBuAddNotificationBinding
    private lateinit var viewModel: BuAddNotificationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuAddNotificationBinding.inflate(inflater, container, false)
        val viewModel: BuAddNotificationViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        with(binding){
            spBuAddChooseBranch.setOnClickListener {
                spBuAddChooseBranch.showSoftInputOnFocus = false
                showBranchselection()
            }
            spBuAddChooseTarget.setOnClickListener {
                spBuAddChooseTarget.showSoftInputOnFocus = false
                showTargetselection()
            }

            btBuAddNotiCancel.setOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }

            btBuAddNotiSaveNoti.setOnClickListener {
                Toast.makeText(activity, "發送成功", Toast.LENGTH_LONG).show()

            }
        }
    }

    private fun showBranchselection(){
        var choice = arrayOf("分店A","分店B","分店C","分店D")
        var selectchoice = booleanArrayOf(false,false,false,false)


        AlertDialog.Builder(view?.context)
            // 設定標題文字
            .setTitle(R.string.spBuAddChooseBranch)
            .setMultiChoiceItems(choice,selectchoice){ dialogInterface: DialogInterface, position: Int, check: Boolean ->
                if(check){
                    Toast.makeText(activity, "選擇"+choice[position], Toast.LENGTH_SHORT).show()
                }
            }
            // false代表要點擊按鈕方能關閉，預設為true
            .setCancelable(true)
            .show()
    }

    private fun showTargetselection(){
        var choice = arrayOf("會員","教練","員工")
        var selectchoice = booleanArrayOf(false,false,false)


        AlertDialog.Builder(view?.context)
            // 設定標題文字
            .setTitle(R.string.spBuAddChooseTarget)
            .setMultiChoiceItems(choice,selectchoice){ dialogInterface: DialogInterface, position: Int, check: Boolean ->
                if(check){
                    Toast.makeText(activity, "選擇"+choice[position], Toast.LENGTH_SHORT).show()
                }
            }
            // false代表要點擊按鈕方能關閉，預設為true
            .setCancelable(true)
            .show()
    }
}