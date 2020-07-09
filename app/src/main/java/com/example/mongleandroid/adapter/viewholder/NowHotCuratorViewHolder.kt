package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.MainNowHotCuratorData

class NowHotCuratorViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
    val img_now_hot_curator = itemView.findViewById<ImageView>(R.id.img_now_hot_curator)
    val tv_curator_name = itemView.findViewById<TextView>(R.id.tv_curator_name)
    val tv_curator_keyword = itemView.findViewById<TextView>(R.id.tv_curator_keyword)

    fun bind(nowHotCuratorData: MainNowHotCuratorData) {
        Glide.with(itemView).load(nowHotCuratorData.img_now_hot_curator).into(img_now_hot_curator)
        tv_curator_name.text = nowHotCuratorData.tv_curator_name
        tv_curator_keyword.text = nowHotCuratorData.tv_curator_keyword
    }
}