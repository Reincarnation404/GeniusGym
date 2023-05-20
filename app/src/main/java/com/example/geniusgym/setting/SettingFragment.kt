package com.example.geniusgym.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentSettingBinding

class SettingFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentSettingBinding
    private val viewModel: SettingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tvNotifiedEnable.setOnClickListener(this@SettingFragment)
            tvClassNoEnable.setOnClickListener(this@SettingFragment)
            tvNewClassEnable.setOnClickListener(this@SettingFragment)
            tvClassScheNoti.setOnClickListener(this@SettingFragment)
            tvWorkScheNoti.setOnClickListener(this@SettingFragment)
            tvPrivacyShowEnable.setOnClickListener(this@SettingFragment)
            ivSocialNickName.setOnClickListener(this@SettingFragment)
            ivSocialIntro.setOnClickListener(this@SettingFragment)
            tvSocialFollowEnabled.setOnClickListener(this@SettingFragment)
            tvSocialAllowInfoAccess.setOnClickListener(this@SettingFragment)
            tvSocialAllowFansCountsAccess.setOnClickListener(this@SettingFragment)
            etSocialNickName.setOnEditorActionListener { _, actionId, _ ->
                if (finish(actionId)) {
                    etSocialNickName.isEnabled = false
                    true
                } else {
                    false // 返回 false 表示未處理該事件
                }
            }
            etSocialIntro.setOnEditorActionListener { _, actionId, _ ->
                if (finish(actionId)) {
                    etSocialNickName.isEnabled = false
                    true
                } else {
                    false // 返回 false 表示未處理該事件
                }
            }
        }
    }

    private fun finish(actionId: Int): Boolean {
        return actionId == EditorInfo.IME_ACTION_NEXT ||
                actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_NULL
    }

    override fun onClick(v: View?) {
        with(binding) {
            when (v?.id) {
                R.id.tvClassNoEnable -> sClassNoEnable.isChecked = !sClassNoEnable.isChecked
                R.id.tvNotifiedEnable -> sNotifiedEnable.isChecked = !sNotifiedEnable.isChecked
                R.id.tvNewClassEnable -> sNewClassEnable.isChecked = !sNewClassEnable.isChecked
                R.id.tvClassScheNoti -> sClassScheNoti.isChecked = !sClassScheNoti.isChecked
                R.id.tvWorkScheNoti -> sWorkScheNoti.isChecked = !sWorkScheNoti.isChecked
                R.id.tvPrivacyShowEnable -> sPrivacyShowEnable.isChecked =
                    !sPrivacyShowEnable.isChecked
                R.id.tvSocialFollowEnabled -> sSocialFollowEnabled.isChecked =
                    !sSocialFollowEnabled.isChecked
                R.id.tvSocialAllowInfoAccess -> sSocialAllowInfoAccess.isChecked =
                    !sSocialAllowInfoAccess.isChecked
                R.id.tvSocialAllowFansCountsAccess -> sSocialAllowFansCountsAccess.isChecked =
                    !sSocialAllowFansCountsAccess.isChecked

                R.id.ivSocialNickName -> {
                    etSocialNickName.isEnabled = !etSocialNickName.isEnabled
                    etSocialNickName.requestFocus()
                    /*if(!etSocialNickName.isEnabled){

                        etSocialNickName.background = ContextCompat.getDrawable(
                            requireContext(),
                            android.R.drawable.editbox_background_normal
                        )
                    }else {
                        etSocialNickName.setBackgroundResource(android.R.color.transparent)
                        etSocialNickName.requestFocus()
                    }*/
                }
                R.id.ivSocialIntro -> {
                    etSocialIntro.isEnabled = !etSocialIntro.isEnabled
                    etSocialNickName.requestFocus()
                }
                else -> {}
            }
        }
    }


}