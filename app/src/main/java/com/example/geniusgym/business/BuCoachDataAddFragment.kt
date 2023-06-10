package com.example.geniusgym.business

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.geniusgym.business.viewModel.BuCoachDataAddViewModel
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentBuCoachDataAddBinding
import java.text.SimpleDateFormat
import java.util.*

class BuCoachDataAddFragment : Fragment() {
    private lateinit var binding: FragmentBuCoachDataAddBinding
    private val calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuCoachDataAddBinding.inflate(inflater, container, false)
        val viewModel: BuCoachDataAddViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){

            tvBuAddCoaDataOBDate.setOnClickListener {
                tvBuAddCoaDataOBDate.showSoftInputOnFocus = false
                openDateTimeDialogs()
            }

            spBuAddCoaDataChooseBranch.setOnClickListener {
                spBuAddCoaDataChooseBranch.showSoftInputOnFocus = false
                showBranchSelection()
            }

            //todo btBuAddCoaDataSave的資料儲存與頁面跳轉

            btBuAddCoaDataCancel.setOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }
        }


    }

    private fun openDateTimeDialogs() {
        val dateListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            openTimePickerDialog()
        }

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            dateListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }
    private fun openTimePickerDialog() {
        val timeListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minute)
            updateTvBuAddChooseCoaOBDate()
        }

        val timePickerDialog = TimePickerDialog(
            requireContext(),
            timeListener,
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        )
        timePickerDialog.show()
    }
    private fun updateTvBuAddChooseCoaOBDate() {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val dateTime = format.format(calendar.time)
        binding.tvBuAddCoaDataOBDate.text = dateTime
        binding.tvBuAddCoaDataOBDate.setTextColor(Color.BLACK)
    }


    private fun showBranchSelection(){
        var choice = arrayOf("分店A","分店B","分店C","分店D")
        var selectItem = -1


        AlertDialog.Builder(view?.context)
            // 設定標題文字
            .setTitle(R.string.spBuAddChooseBranch)
            .setSingleChoiceItems(choice,selectItem){ _, position->
                selectItem = position
            }
            .setPositiveButton(R.string.bu_add_choose_branch_confirm){ _, _ ->
                if (selectItem != -1) {
                    val selectedBranch = choice[selectItem]
                    updateSpBuAddChooseBranch(selectedBranch)
                }
            }
            // false代表要點擊按鈕方能關閉，預設為true
            .setCancelable(true)
            .show()
    }
    private fun updateSpBuAddChooseBranch(branch: String) {
        binding.spBuAddCoaDataChooseBranch.text = branch
    }

    // 這是送出資料的那個葉面
//    frafdf : fragmwnt(){
//        val branchMap = mapOf<String,Int>("分店 A" to 1, "分店 B" to 2)
//        branchMap[branch]
//
//    }
}