package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.response.ResponseSearchRecentData

class SearchRecentViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val tv_recent_keyword = itemView.findViewById<TextView>(R.id.tv_recent_keyword)

    fun bind(responseSearchRecentData: ResponseSearchRecentData){
        tv_recent_keyword.text = responseSearchRecentData.tv_recent_keyword
    }
}