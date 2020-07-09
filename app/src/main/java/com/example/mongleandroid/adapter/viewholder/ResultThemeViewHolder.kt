package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.ResultThemeData

class ResultThemeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val result_theme_tv_sentence = itemView.findViewById<TextView>(R.id.result_theme_tv_sentence)
    val result_theme_tv_bookmark = itemView.findViewById<TextView>(R.id.result_theme_tv_bookmark)
    val result_theme_tv_sentence_count = itemView.findViewById<TextView>(R.id.result_theme_tv_sentence_count)

    fun bind(resultThemeData: ResultThemeData){
        result_theme_tv_sentence.text = resultThemeData.result_theme_tv_sentence
        result_theme_tv_bookmark.text = resultThemeData.result_theme_tv_bookmark
        result_theme_tv_sentence_count.text = resultThemeData.result_theme_tv_sentence_count
    }
}

