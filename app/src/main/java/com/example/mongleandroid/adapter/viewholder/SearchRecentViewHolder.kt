package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.SearchRecentData

class SearchRecentViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val tv_recent_keyword = itemView.findViewById<TextView>(R.id.tv_recent_keyword)

    fun bind(searchRecentData: SearchRecentData){
        tv_recent_keyword.text = searchRecentData.tv_recent_keyword
    }
}