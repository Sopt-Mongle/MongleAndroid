package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.response.CuratorList

class CuratorInThemeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val img = itemView.findViewById<ImageView>(R.id.result_curator_img_profile)
    val name = itemView.findViewById<TextView>(R.id.result_curator_tv_name)
    val subscribe = itemView.findViewById<TextView>(R.id.result_curator_tv_subcount)
    val keyword = itemView.findViewById<TextView>(R.id.result_curator_tv_keyword)
    val alreadySubscribed = itemView.findViewById<CheckBox>(R.id.result_curator_btn_subscribe_item)

    fun bind(curatorList : CuratorList) {
        Glide.with(itemView).load(curatorList.img).into(img)
        name.text = curatorList.name
        subscribe.text = curatorList.subscribe
        keyword.text = curatorList.keyword
        alreadySubscribed.setOnClickListener {
            if(alreadySubscribed.isChecked) {
                alreadySubscribed.setText("구독중")
            } else alreadySubscribed.setText("구독")
        }
    }
}