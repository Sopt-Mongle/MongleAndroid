package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.response.RecommendCurator

class CuratorRecommendViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
    val img = itemView.findViewById<ImageView>(R.id.img_now_hot_curator)
    val name = itemView.findViewById<TextView>(R.id.tv_curator_name)
    val keyword = itemView.findViewById<TextView>(R.id.tv_curator_keyword)

    fun bind(recommendCurator: RecommendCurator) {
        Glide.with(itemView).load(recommendCurator.img).into(img)
        name.text = recommendCurator.name
        keyword.text = recommendCurator.keyword
    }
}