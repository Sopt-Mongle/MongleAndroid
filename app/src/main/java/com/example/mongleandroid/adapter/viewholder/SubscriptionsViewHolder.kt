package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.SubscriptionsData

class SubscriptionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val img_profile_item = itemView.findViewById<ImageView>(R.id.img_profile_item)
    val item_username = itemView.findViewById<TextView>(R.id.item_username)
    val item_keyword1 = itemView.findViewById<TextView>(R.id.item_keyword1)
    val item_keyword2 = itemView.findViewById<TextView>(R.id.item_keyword2)
    val item_img_online = itemView.findViewById<ImageView>(R.id.item_img_online)
    val btn_subscribe_item = itemView.findViewById<CheckBox>(R.id.btn_subscribe_item)

    fun bind(subscriptionsData: SubscriptionsData) {
        Glide.with(itemView).load(subscriptionsData.img_profile_item).into(img_profile_item)
        item_username.text = subscriptionsData.item_username
        item_keyword1.text = subscriptionsData.item_keyword1
        item_keyword2.text = subscriptionsData.item_keyword2
        Glide.with(itemView).load(subscriptionsData.item_img_online).into(item_img_online)
        btn_subscribe_item.setOnClickListener {
            if (btn_subscribe_item.isChecked) {
                btn_subscribe_item.setText("구독중")
            } else btn_subscribe_item.setText("구독")

        }

    }


}