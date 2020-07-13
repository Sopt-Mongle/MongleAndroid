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
import com.example.mongleandroid.network.data.ResultSentenceData

class ResultSentenceViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val result_sentence_tv_themename = itemView.findViewById<TextView>(R.id.result_sentence_tv_themename)
    val result_sentence_tv_context = itemView.findViewById<TextView>(R.id.result_sentence_tv_sentence)

    @SuppressLint("ResourceAsColor")
    fun bind(resultSentenceData: ResultSentenceData){
        result_sentence_tv_themename.text = resultSentenceData.result_sentence_tv_themename
        result_sentence_tv_context.text = resultSentenceData.result_sentence_tv_context

        val inputString = MainActivity.search_result
        val sb = StringBuilder(inputString)
        val startWord = sb.get(0)
        val endWord = sb.get(sb.lastIndex)
        Log.d("index","startWord : ${startWord}, endWord ${endWord}")

        val startIndex = resultSentenceData.result_sentence_tv_context.indexOf(startWord)
        val lastIndex = resultSentenceData.result_sentence_tv_context.indexOf(endWord)
        Log.d("index","startIndex : ${startIndex}, lastIndex ${lastIndex}")
        val spannable = SpannableStringBuilder(resultSentenceData.result_sentence_tv_context)

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

        result_sentence_tv_context.text = spannable
    }
}

