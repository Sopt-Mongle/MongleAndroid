package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.response.ResponseResultCuratorData

class CuratorFragmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val img = itemView.findViewById<ImageView>(R.id.result_curator_img_profile)
    val name = itemView.findViewById<TextView>(R.id.result_curator_tv_name)
    val subscribe = itemView.findViewById<TextView>(R.id.result_curator_tv_subcount)
    val keyword = itemView.findViewById<TextView>(R.id.result_curator_tv_keyword)

    fun bind(responseResultCuratorData: ResponseResultCuratorData) {
        Glide.with(itemView).load(responseResultCuratorData.img).into(img)
        name.text = responseResultCuratorData.name
        subscribe.text = responseResultCuratorData.subscribe
        keyword.text = responseResultCuratorData.keyword
    }
}