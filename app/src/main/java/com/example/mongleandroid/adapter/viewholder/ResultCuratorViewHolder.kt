package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.ResultCuratorData

class ResultCuratorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val result_curator_img_profile = itemView.findViewById<ImageView>(R.id.result_curator_img_profile)
    val result_curator_tv_name = itemView.findViewById<TextView>(R.id.result_curator_tv_name)
    val result_curator_tv_subcount = itemView.findViewById<TextView>(R.id.result_curator_tv_subcount)
    val result_curator_tv_keyword = itemView.findViewById<TextView>(R.id.result_curator_tv_keyword)

    fun bind(resultCuratorData: ResultCuratorData) {
        Glide.with(itemView).load(resultCuratorData.result_curator_img_profile).into(result_curator_img_profile)
        result_curator_tv_name.text = resultCuratorData.result_curator_tv_name
        result_curator_tv_subcount.text = resultCuratorData.result_curator_tv_subcount
        result_curator_tv_keyword.text = resultCuratorData.result_curator_tv_keyword
    }
}