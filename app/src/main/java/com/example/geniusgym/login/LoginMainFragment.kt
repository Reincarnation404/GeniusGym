package com.example.geniusgym.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.geniusgym.LoginMainViewModel
import com.example.geniusgym.R
import com.example.geniusgym.coach.calendarMemberList.model.MemberInfo
import com.example.geniusgym.databinding.FragmentLoginMainBinding
import java.lang.reflect.Member

class LoginMainFragment : Fragment() {
    private lateinit var binding: FragmentLoginMainBinding
    private lateinit var viewModel: LoginMainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: LoginMainViewModel by viewModels()
        binding = FragmentLoginMainBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            tvLoginForget.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.loginForgetFragment)
            }
            btLoginConfirm.setOnClickListener {
                val loginId = binding.tietLoginAccount.text.toString()
                val password = binding.tietLoginPassword.text.toString()

                if (loginId.isEmpty()) {
                    tietLoginAccount.error = "帳號不可為空白"
                } else {
                    tietLoginAccount.error = null
                }

                if (password.isEmpty()) {
                    tietLoginPassword.error = "密碼不可為空白"
                } else if (password.length < 6 || password.length > 12) {
                    tietLoginPassword.error = "密碼須介於6~12個字"
                } else {
                    tietLoginPassword.error = null
                }
            }
        }
    }
}