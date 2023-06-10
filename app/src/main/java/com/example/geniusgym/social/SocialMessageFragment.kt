package com.example.geniusgym.social

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentSocialMessageBinding

class SocialMessageFragment : Fragment() {
    private lateinit var binding: FragmentSocialMessageBinding
    private lateinit var socialMessageAdapter: SocialMessageAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSocialMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chatList = getChatList()
        socialMessageAdapter = SocialMessageAdapter(chatList)
        binding.messageRecyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = socialMessageAdapter
        }

        binding.toHome.setOnClickListener {
            navigateTo(R.id.action_socialMessageFragment_to_socialHomeFragment)
        }

        binding.toProfileButton.setOnClickListener {
            navigateTo(R.id.action_socialMessageFragment_to_socialProfileFragment)
        }
    }

    private fun navigateTo(actionId: Int) {
        findNavController().navigate(actionId)
    }

    private fun getChatList(): List<ChatList> {
        return listOf(
            ChatList(1, R.drawable.eren_yeager, "User1", "Hello!", "9:00 AM"),
            ChatList(2, R.drawable.walter_white, "User2", "Hi there!", "10:30 AM"),
            ChatList(3, R.drawable.saitama, "User3", "Good morning!", "11:45 AM")
        )
    }
}