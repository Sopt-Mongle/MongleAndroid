package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.response.MainThemes
import com.example.mongleandroid.network.data.response.ResponseMainHotThemeData

class HotThemeViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){
    val theme = itemView.findViewById<TextView>(R.id.tv_main_hot_theme)
    val sentenceNum = itemView.findViewById<TextView>(R.id.tv_main_hot_theme_count)
    val themeImg = itemView.findViewById<ImageView>(R.id.img_theme_background)

    fun bind(mainThemes: MainThemes){

        theme.text = mainThemes.theme
        sentenceNum.text = mainThemes.sentenceNum.toString()
        Glide.with(itemView).load(mainThemes.themeImg).into(themeImg)
    }
}