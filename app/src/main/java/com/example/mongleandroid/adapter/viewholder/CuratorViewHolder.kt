package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.CuratorData

class CuratorViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val img_profile_item = itemView.findViewById<ImageView>(R.id.img_profile_item)
    val item_username = itemView.findViewById<TextView>(R.id.item_username)
    val item_contents = itemView.findViewById<TextView>(R.id.item_contents)
    val item_img_online = itemView.findViewById<ImageView>(R.id.item_img_online)
    val btn_subscribe_item = itemView.findViewById<ImageView>(R.id.btn_subscribe_item)
    val hashtag_curator = itemView.findViewById<ImageView>(R.id.hashtag_curator)
    val hashtag2_curator = itemView.findViewById<ImageView>(R.id.hashtag2_curator)

    fun bind(curatorData : CuratorData) {
        Glide.with(itemView).load(curatorData.img_profile_item).into(img_profile_item)
        item_username.text = curatorData.item_username
        item_contents.text = curatorData.item_contents
        Glide.with(itemView).load(curatorData.btn_subscribe_item).into(btn_subscribe_item)
        Glide.with(itemView).load(curatorData.item_img_online).into(item_img_online)
        Glide.with(itemView).load(curatorData.hashtag_curator).into(hashtag_curator)
        Glide.with(itemView).load(curatorData.hashtag2_curator).into(hashtag2_curator)
    }
}