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
        item_search_book_tv_author.text = bookData.authors[0]
        //item_search_book_img.drawable
        item_search_book_tv_htitle.text = bookData.title
        item_search_book_tv_publisher.text = bookData.publisher



//        val authors : MutableList<String>,	//책 저자 배열
////    val authors : String,
//        val contents : String,	//책 소개
//        val datetime : String,	//책 출간일
//        val isbn : String,	//책 고유 isbn 번호
//        val publisher : String,	//출판사
//        val thumbnail : String,	//책 사진
//        val title : String	//책 제목
    }


}