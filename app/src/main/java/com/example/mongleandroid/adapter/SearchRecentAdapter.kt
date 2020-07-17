package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.SearchRecentViewHolder
import com.example.mongleandroid.network.data.response.ResponseSearchRecentData

class SearchRecentAdapter(private val context: Context) : RecyclerView.Adapter<SearchRecentViewHolder>(){
    var datas = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRecentViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recent_keyword, parent, false)
        return SearchRecentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: SearchRecentViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}