package com.example.geniusgym.social

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentSocialChatRoomBinding

class SocialChatRoomFragment : Fragment() {
    private lateinit var binding: FragmentSocialChatRoomBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSocialChatRoomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 在这里进行聊天室界面的初始化和逻辑处理

        val username = arguments?.getString(ArticleFragment.ARG_USERNAME)
        val profileImage = arguments?.getInt(ArticleFragment.ARG_PROFILE_IMAGE)

        val toHomeButton = requireActivity().findViewById<Button>(R.id.toHome)
        val toProfileButton = requireActivity().findViewById<Button>(R.id.toProfileButton)
        toHomeButton.setOnClickListener(null)
        toProfileButton.setOnClickListener(null)

        binding.turnLeft.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val socialMessageFragment = SocialMessageFragment()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, socialMessageFragment)
            transaction.commit()
        }

        // 示例：获取传递的参数

    }

    companion object {
        fun newInstance(): SocialChatRoomFragment {
            return SocialChatRoomFragment()
        }
    }
}