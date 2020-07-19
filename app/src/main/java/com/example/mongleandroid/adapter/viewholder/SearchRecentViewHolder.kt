package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.response.ResponseSearchRecentData

class SearchRecentViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val datas = itemView.findViewById<TextView>(R.id.tv_recent_keyword)

    fun bind(data: String){
        datas.text = data
    }
}