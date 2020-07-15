package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.WritingSentenceBookSearchViewHolder
import com.example.mongleandroid.network.data.response.BookData

class WritingSentenceBookSearchAdapter(private val context: Context) : RecyclerView.Adapter<WritingSentenceBookSearchViewHolder>(){
        var datas = mutableListOf<BookData>()

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): WritingSentenceBookSearchViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.item_book_search, parent, false)
            return WritingSentenceBookSearchViewHolder(view)
        }

        override fun getItemCount(): Int {
            return datas.size
        }

        override fun onBindViewHolder(holder: WritingSentenceBookSearchViewHolder, position: Int) {
            holder.bind(datas[position])
        }

}