package com.example.geniusgym.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.geniusgym.R
import com.example.geniusgym.business.BuActivity
import com.example.geniusgym.coach.CoActivity
import com.example.geniusgym.databinding.FragmentLoginMainBinding
import com.example.geniusgym.member.MeActivity
import kotlinx.coroutines.runBlocking

class LoginMainFragment : Fragment() {
    private lateinit var binding: FragmentLoginMainBinding
    private val viewModel : LoginMainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginMainBinding.inflate(inflater, container, false)
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

                if (!enterError(binding, loginId, password)){
                    identify(binding, loginId, password)
                }
            }
        }
    }

    private fun enterError(binding: FragmentLoginMainBinding, loginId: String, password: String) : Boolean{
        with(binding){
            if (loginId.isEmpty()) {
                tietLoginAccount.error = "帳號不可為空白"
                return true
            } else if (loginId.length < 6 || loginId.length > 12) {
                tietLoginAccount.error = "帳號須介於6~12個字"
                return true
            }

            if (password.isEmpty()) {
                tietLoginPassword.error = "密碼不可為空白"
                return true
            }

            return false
        }
    }


    private fun identify(binding: FragmentLoginMainBinding, loginId: String, password: String){
        with(binding){
            when (getAccountTypeFromLogin(loginId)) {
                "business" -> {
                    if (loginId == viewModel.buAccount && password == viewModel.buPassword) {
                        jumpTo(BuActivity::class.java)
                    } else {
                        tvLoginResult.text = "帳號密碼輸入錯誤"
                    }
                }

                "member" -> {
                    viewModel.member.m_id = loginId
                    viewModel.member.m_pwd = password
                    val sucessString = runBlocking { viewModel.melogin() }
                    if ( sucessString == "success" ) {
                        jumpTo(MeActivity::class.java)
                    } else {
                        tvLoginResult.text = "帳號密碼輸入錯誤"
                    }
                }

                "coach" -> {
                    if (loginId == viewModel?.coAccount && password == viewModel.coPassword) {
                        jumpTo(CoActivity::class.java)
                    } else {
                        tvLoginResult.text = "帳號密碼輸入錯誤"
                    }
                }

                else -> {
                    Toast.makeText(requireContext(), "無效帳號類型", Toast.LENGTH_SHORT).show()
                    return
                }

            }
        }
    }

    private fun <T : AppCompatActivity> jumpTo( classtype :  Class<T> ){
        val intent = Intent(requireActivity(), classtype)
        intent.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun getAccountTypeFromLogin(loginId: String): String {

        val accountType: String =
            if (loginId.startsWith("B", ignoreCase = true)) {
                "business"
            } else if (loginId.startsWith("M", ignoreCase = true)) {
                "member"
            } else if (loginId.startsWith("C", ignoreCase = true)) {
                "coach"
            } else {
                "unknown"
            }
        return accountType
    }
}