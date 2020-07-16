package com.example.mongleandroid.adapter.viewholder

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.MainActivity
import com.example.mongleandroid.network.data.response.ResponseResultSentenceData
import com.example.mongleandroid.network.data.response.ResultSentence

class ResultSentenceViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val theme = itemView.findViewById<TextView>(R.id.result_sentence_tv_themename)
    val sentence = itemView.findViewById<TextView>(R.id.result_sentence_tv_sentence)

    fun bind(resultSentence: ResultSentence){
        theme.text = resultSentence.theme

        val inputString = MainActivity.search_result
        val sb = StringBuilder(inputString)
        val startWord = sb.get(0)
        val endWord = sb.get(sb.lastIndex)
        Log.d("index","startWord : ${startWord}, endWord ${endWord}")

        val startIndex = resultSentence.sentence.indexOf(startWord)
        val lastIndex = resultSentence.sentence.indexOf(endWord)
        Log.d("index","startIndex : ${startIndex}, lastIndex ${lastIndex}")
        val spannable = SpannableStringBuilder(resultSentence.sentence)

        if(inputString.length == lastIndex - startIndex + 1) {
            spannable.setSpan(
                ForegroundColorSpan(Color.rgb(115,192,136)),
                startIndex,
                lastIndex + 1, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
        } else {
            Log.e("error", "성공?")
        }

        sentence.text = spannable
    }
}

