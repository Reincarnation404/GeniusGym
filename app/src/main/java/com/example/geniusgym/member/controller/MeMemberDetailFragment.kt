package com.example.geniusgym.member.controller

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMeMemberDetailBinding
import com.example.geniusgym.member.viewmodel.MeMemberDetailViewModel


class MeMemberDetailFragment : Fragment() {
    // 延遲初始化一個 FragmentMeMemberDetailBinding 的實例
    private lateinit var binding: FragmentMeMemberDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 創建一個 MeMemberDetailViewModel 的實例，這裡使用 viewModels() 函數來創建 ViewModel
        val viewModel: MeMemberDetailViewModel by viewModels()
        binding = FragmentMeMemberDetailBinding.inflate(inflater, container ,false)
        // 將 ViewModel 賦值給綁定的 viewModel 變數
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // 調用 setupMenu 方法，傳入 view 作為引數
        with(binding){
           setupMenu(view)
       }
    }

    // 設置選單的方法，接受一個 View 作為引數
    private fun setupMenu(view: View) {
        // 將當前的 Fragment 轉換為 MenuHost，然後添加 MenuProvider
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider{
            // 當創建選單時調用
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // 填充選單資源
                menuInflater.inflate(R.menu.mem_optionsmenu,menu)
            }

            // 當選單項目被點擊時調用
            override fun onMenuItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    // 當選單項目為 R.id.toolbar_mem_info 時
                    R.id.toolbar_mem_info -> {
                        val fragment = MeMemberDetailFragment()
                        // 創建 MeMemberDetailFragment 的實例並導航到該 Fragment
                        Navigation.findNavController(view).navigate(R.id.meMemberDetailFragment)

                    }

                    // 當選單項目為 R.id.toolbar_mem_points 時
                    R.id.toolbar_mem_class -> {
                        val fragment = MePersonalTrain()
                        // 創建 MePointsFragment 的實例並導航到該 Fragment
                        Navigation.findNavController(view).navigate(R.id.mePersonalTrain)

                    }

                    R.id.toolbar_mem_points ->{
                       val fragment  = MePointsFragment()
                       Navigation.findNavController(view).navigate(R.id.mePointsFragment)
                    }


                    else -> {}
                }
                return true
            }
            // 在準備選單時調用
            override fun onPrepareMenu(menu: Menu) {
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}
// Lifecycle.State.RESUMED：
//這是生命周期的一個狀態，表示 Fragment 正在活躍且位於最上層。
// 在這個狀態下，Fragment 的視圖已經被創建並顯示，並且可以進行交互和更新。















