package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.WritingSentenceThemeSearchViewHolder
import com.example.mongleandroid.network.data.response.ResponseWritingSentenceThemeSearchData
import kotlinx.android.synthetic.main.item_theme_search.*

class WritingSentenceThemeSearchAdapter(private val context : Context) : RecyclerView.Adapter<WritingSentenceThemeSearchViewHolder>() {
    var datas = mutableListOf<ResponseWritingSentenceThemeSearchData>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WritingSentenceThemeSearchViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_theme_search,parent,false )
        return WritingSentenceThemeSearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: WritingSentenceThemeSearchViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}