package com.example.geniusgym.business

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.example.geniusgym.R
import com.example.geniusgym.business.viewModel.BuNotificationManageViewModel
import com.example.geniusgym.databinding.FragmentBuNotificaitonManageBinding

class BuNotificationManageFragment : Fragment() {
    private lateinit var binding: FragmentBuNotificaitonManageBinding
    private lateinit var viewModel: BuNotificationManageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().setTitle(R.string.btBuMenuNotification)
        binding = FragmentBuNotificaitonManageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            setupMenu()
            fabBuNotiManageAddNotification.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_buNotificaitonManage_to_buAddNotification)
            }
        }
    }
    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.bu_option_menu_filter_add_search, menu)

            }


            override fun onMenuItemSelected(item: MenuItem): Boolean {
                // Validate and handle the selected menu item
                when (item.itemId) {
                    R.id.toolbar_search -> Toast.makeText(activity,"search", Toast.LENGTH_LONG).show()
                    //R.id.toolbar_add -> Navigation.findNavController(it).navigate(R.id.action_buMenu_to_buMemberData)
                    R.id.toolbar_filter -> {
                        Toast.makeText(activity,"filter", Toast.LENGTH_LONG).show()
                    }
                }
                // binding.viewModel?.text?.value = text
                // 只要顯示選取項目文字可改成下列方式；但實際應用較複雜，需要上面when比對寫法
                // binding.viewModel?.text?.value = item.title.toString()
                // 做對應的處理即可回傳true，讓Menu處理到此為止
                return true
            }

            override fun onPrepareMenu(menu: Menu) {
                // Handle for example visibility of menu items
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }



}