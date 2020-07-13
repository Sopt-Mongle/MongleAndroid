package com.example.mongleandroid.adapter.viewholder

import android.annotation.SuppressLint
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.MainActivity
import com.example.mongleandroid.network.data.ResultThemeData

class ResultThemeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val result_theme_tv_theme = itemView.findViewById<TextView>(R.id.result_theme_tv_theme)
    val result_theme_tv_bookmark = itemView.findViewById<TextView>(R.id.result_theme_tv_bookmark)
    val result_theme_tv_sentence_count = itemView.findViewById<TextView>(R.id.result_theme_tv_sentence_count)

    @SuppressLint("ResourceAsColor")
    fun bind(resultThemeData: ResultThemeData){
        result_theme_tv_bookmark.text = resultThemeData.result_theme_tv_bookmark
        result_theme_tv_sentence_count.text = resultThemeData.result_theme_tv_sentence_count

        val inputString = MainActivity.search_result
        val sb = StringBuilder(inputString)
        val startWord = sb.get(0)
        val endWord = sb.get(sb.lastIndex)
        Log.d("index","startWord : ${startWord}, endWord ${endWord}")

        val startIndex = resultThemeData.result_theme_tv_theme.indexOf(startWord)
        val lastIndex = resultThemeData.result_theme_tv_theme.indexOf(endWord)
        Log.d("index","startIndex : ${startIndex}, lastIndex ${lastIndex}")
        val spannable = SpannableStringBuilder(resultThemeData.result_theme_tv_theme)

        if(inputString.length == lastIndex - startIndex + 1) {
            spannable.setSpan(
                ForegroundColorSpan(R.color.softGreen),
                startIndex,
                lastIndex + 1, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
        } else {
            Log.e("error", "성공?")
        }

        result_theme_tv_theme.text = spannable



    }
}

