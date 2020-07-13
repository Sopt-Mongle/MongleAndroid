package com.example.mongleandroid.adapter.viewholder

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.response.ResponseWritingSentenceThemeSearchData
import kotlinx.android.synthetic.main.item_theme_search.view.*

class WritingSentenceThemeSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val item_search_theme_tv_themeTitle = itemView.findViewById<TextView>(R.id.item_search_theme_tv_themeTitle)

    fun bind(writingSentenceThemeSearchData: ResponseWritingSentenceThemeSearchData){
        //item_search_theme_tv_themeTitle.text = writingSentenceThemeSearchData.data[1].toString()
        item_search_theme_tv_themeTitle.text = writingSentenceThemeSearchData.theme
    }
}