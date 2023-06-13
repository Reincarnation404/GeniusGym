package com.example.geniusgym.member.controller

import android.os.Binder
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMePointsBinding
import com.example.geniusgym.member.MePointsViewModel
import com.example.geniusgym.member.adapter.MePointsAdapter
import com.example.geniusgym.member.model.MePointBean

class MePointsFragment : Fragment() {
    private lateinit var binding : FragmentMePointsBinding
    val viewModel : MePointsViewModel by viewModels()
    private lateinit var adapter: MePointsAdapter
    private lateinit var items : MutableList<MePointBean>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMePointsBinding.inflate(inflater,container,false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        adapter = MePointsAdapter(items)
        return binding.root }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    val recyclerView : RecyclerView = view.findViewById(R.id.ptRecyclerlist)
    recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }}


  /* viewModel.pointsum.observe(viewLifecycleOwner,{ pointsum ->
    val newItem = PointItem(此處要放下一頁的點數購買對應)
    adpter.addData(newItem) })

    return inflater.inflate(R.layout.fragment_a, container, false)
    }
}
    }*/












