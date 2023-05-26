package com.example.geniusgym.member

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.geniusgym.R
import com.example.geniusgym.databinding.RecycleCellMeCoachinfoBinding

class MeCoachInfoAdapter(val coaches: List<CoachBean>) : RecyclerView.Adapter<MeCoachInfoAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: RecycleCellMeCoachinfoBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecycleCellMeCoachinfoBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return coaches.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder.binding){
            coachName.text = coaches[position].c_name
            if (coaches[position].c_pic == null){
                coachPicture.setImageResource(R.drawable.a005)
            }else{

            }

            this.root.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable("CoachInfo", coaches[position])
//                TODO:跳轉到另一個頁面
            }

        }

    }

}