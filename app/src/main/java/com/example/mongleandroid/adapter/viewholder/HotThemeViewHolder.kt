package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.ResponseMainHotThemeData

class HotThemeViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){
    val tv_main_hot_theme = itemView.findViewById<TextView>(R.id.tv_main_hot_theme)
    val tv_main_hot_theme_count = itemView.findViewById<TextView>(R.id.tv_main_hot_theme_count)

//    fun bind(mainHotThemeData: ResponseMainHotThemeData){
//        tv_main_hot_theme.text = mainHotThemeData.tv_main_hot_theme
//        tv_main_hot_theme_count.text = mainHotThemeData.tv_main_hot_theme_count
//    }
}