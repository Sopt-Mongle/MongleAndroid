package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.response.BookData
import com.example.mongleandroid.network.data.response.ResponseWritingSentenceBookSearchData


class WritingSentenceBookSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //val item_search_book_img = itemView.findViewById<ImageView>(R.id.item_search_book_img)
    val item_search_book_tv_htitle = itemView.findViewById<TextView>(R.id.item_search_book_tv_htitle)
    val item_search_book_tv_author = itemView.findViewById<TextView>(R.id.item_search_book_tv_author)
    val item_search_book_tv_publisher = itemView.findViewById<TextView>(R.id.item_search_book_tv_publisher)

    fun bind(bookData: BookData){
        item_search_book_tv_author.text = bookData.authors
        //item_search_book_img.drawable
        item_search_book_tv_htitle.text = bookData.title
        item_search_book_tv_publisher.text = bookData.publisher
    }


}