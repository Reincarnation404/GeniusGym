package com.example.geniusgym.member

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.R

class MeMapDirectFragment : Fragment() {

    companion object {
        fun newInstance() = MeMapDirectFragment()
    }

    private lateinit var viewModel: MeMapDirectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_me_map_direct, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MeMapDirectViewModel::class.java)
        // TODO: Use the ViewModel
    }

}