package com.example.geniusgym.coach.calendarMemberListDetail.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.geniusgym.R
import com.example.geniusgym.coach.calendarMemberListDetail.viewmodel.CoCalenderMemberRecordViewModel
import com.example.geniusgym.databinding.FragmentCoCalenderMemberRecordBinding

class CoCalenderMemberRecordFragment : Fragment() {

    private lateinit var binding: FragmentCoCalenderMemberRecordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel : CoCalenderMemberRecordViewModel by viewModels()
        binding = FragmentCoCalenderMemberRecordBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun handleViews() {
        val pages = listOf(
            Page(getString(R.string.txtNews), getColor(R.color.purple_200), NewsFragment()),
            Page(getString(R.string.txtSettings), getColor(R.color.teal_200), SettingsFragment())
        )

        with(binding) {
            viewPager2.adapter = MyFragmentStateAdapter(this@MainActivity, pages)
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                // 設定tab標題文字
                tab.text = pages[position].title
                tab.view.setBackgroundColor(pages[position].color)
            }.attach()
        }
    }
    class Page(var title: String, var color: Int, var fragment: Fragment)

    class MyFragmentStateAdapter(activity: FragmentActivity, private var pages: List<Page>) :
        FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return pages.size
        }

        override fun createFragment(position: Int): Fragment {
            return pages[position].fragment
        }

    }
}