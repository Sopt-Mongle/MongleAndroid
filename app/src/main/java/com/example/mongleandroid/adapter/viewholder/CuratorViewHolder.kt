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
    val item_keyword1 = itemView.findViewById<TextView>(R.id.item_keyword1)
    val item_keyword2 = itemView.findViewById<TextView>(R.id.item_keyword2)
    val item_img_online = itemView.findViewById<ImageView>(R.id.item_img_online)

    fun bind(curatorData : CuratorData) {
        Glide.with(itemView).load(curatorData.img_profile_item).into(img_profile_item)
        item_username.text = curatorData.item_username
        item_keyword1.text = curatorData.item_keyword1
        item_keyword2.text = curatorData.item_keyword2
        Glide.with(itemView).load(curatorData.item_img_online).into(item_img_online)
    }
}
