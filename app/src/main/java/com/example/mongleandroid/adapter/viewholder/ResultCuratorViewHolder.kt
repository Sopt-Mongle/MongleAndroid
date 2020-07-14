package com.example.mongleandroid.adapter.viewholder

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.MainActivity
import com.example.mongleandroid.network.data.response.ResponseResultCuratorData

class ResultCuratorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val img = itemView.findViewById<ImageView>(R.id.result_curator_img_profile)
    val name = itemView.findViewById<TextView>(R.id.result_curator_tv_name)
    val subscribe = itemView.findViewById<TextView>(R.id.result_curator_tv_subcount)
    val keyword = itemView.findViewById<TextView>(R.id.result_curator_tv_keyword)

    fun bind(responseResultCuratorData: ResponseResultCuratorData) {
        Glide.with(itemView).load(responseResultCuratorData.img).into(img)
        subscribe.text = responseResultCuratorData.subscribe
        keyword.text = responseResultCuratorData.keyword

        val inputString = MainActivity.search_result
        val sb = StringBuilder(inputString)
        val startWord = sb.get(0)
        val endWord = sb.get(sb.lastIndex)
        Log.d("index","startWord : ${startWord}, endWord ${endWord}")

        val startIndex = responseResultCuratorData.name.indexOf(startWord)
        val lastIndex = responseResultCuratorData.name.indexOf(endWord)
        Log.d("index","startIndex : ${startIndex}, lastIndex ${lastIndex}")
        val spannable = SpannableStringBuilder(responseResultCuratorData.name)

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

        name.text = spannable
    }
}