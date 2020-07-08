package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.ResultThemeData

class ResultThemeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val tv_result_theme_sentence = itemView.findViewById<TextView>(R.id.result_theme_tv_sentence)
    val tv_result_theme_bookmark = itemView.findViewById<TextView>(R.id.result_theme_bookmark)
    val tv_result_theme_sentence_count = itemView.findViewById<TextView>(R.id.result_theme_sentence_count)

    fun bind(resultThemeData: ResultThemeData){
        tv_result_theme_sentence.text = resultThemeData.tv_result_theme_sentence
        tv_result_theme_bookmark.text = resultThemeData.tv_result_theme_bookmark
        tv_result_theme_sentence_count.text = resultThemeData.tv_result_theme_sentence_count
    }
}

