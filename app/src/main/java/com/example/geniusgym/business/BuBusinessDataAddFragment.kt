package com.example.geniusgym.business

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.geniusgym.business.viewModel.BuBusinessDataAddViewModel
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentBuBusinessDataAddBinding
import java.text.SimpleDateFormat
import java.util.*

class BuBusinessDataAddFragment : Fragment() {
    private lateinit var binding: FragmentBuBusinessDataAddBinding
    private val calendar = Calendar.getInstance()
    private lateinit var viewModel: BuBusinessDataAddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuBusinessDataAddBinding.inflate(inflater, container, false)
        val viewModel: BuBusinessDataAddViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            tvBuAddBuzDataBranch.setOnClickListener {
                showBranchSelection()
            }

            tvBuAddBuzDataOBDate.setOnClickListener {
                tvBuAddBuzDataOBDate.showSoftInputOnFocus = false
                openDateTimeDialogs()
            }

            //todo btBuAddBuzDataSave的資料儲存與頁面跳轉

            btBuAddBuzDataCancel.setOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }
        }
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
                    updateTvBuAddBuzChooseBranch(selectedBranch)
                }
            }
            // false代表要點擊按鈕方能關閉，預設為true
            .setCancelable(true)
            .show()
    }
    private fun updateTvBuAddBuzChooseBranch(branch: String) {
        binding.tvBuAddBuzDataBranch.text = branch
        binding.tvBuAddBuzDataBranch.setTextColor(Color.BLACK)
    }



    private fun openDateTimeDialogs() {
        val dateListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            updateTvBuAddChooseCoaOBDate()
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
    private fun updateTvBuAddChooseCoaOBDate() {
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val dateTime = format.format(calendar.time)
        binding.tvBuAddBuzDataOBDate.text = dateTime
        binding.tvBuAddBuzDataOBDate.setTextColor(Color.BLACK)
    }
}


