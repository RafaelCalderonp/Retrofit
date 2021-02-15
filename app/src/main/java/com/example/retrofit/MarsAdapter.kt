package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.LandListBinding
import com.example.retrofit.model.local.MarsEntity



class MarsAdapter :RecyclerView.Adapter<MarsAdapter.MarsVH>(){
    private var listLand = listOf<MarsEntity>()

    fun update(list: List<MarsEntity>){
        listLand = list
        notifyDataSetChanged()
    }
//https://www.raywenderlich.com/272-intermediate-recyclerview-tutorial-with-kotlin

    inner class MarsVH(private val mBinding: LandListBinding) :
            RecyclerView.ViewHolder(mBinding.root){
        fun bind(land: MarsEntity ){
            // mBinding.textView.text = land.imgSrc
          Glide.with(mBinding.ivLand).load(land.imgSrc).centerCrop().into(mBinding.ivLand)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsVH {
        return MarsVH(LandListBinding.inflate(LayoutInflater.from(parent.context)))
    }



    override fun onBindViewHolder(holder: MarsVH, position: Int) {
        val land = listLand[position]
       // Glide.with(holder.).load(land.imgSrc).centerCrop().into(holder.ivDepto)
        holder.bind(land)
    }

    override fun getItemCount(): Int =listLand.size
}