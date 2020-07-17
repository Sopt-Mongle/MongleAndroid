package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.LibrarySentenceViewHolder
import com.example.mongleandroid.network.data.LibrarySentenceData
import com.example.mongleandroid.network.data.response.LibrarySentenceSave
import com.example.mongleandroid.network.data.response.LibrarySentenceWrite

//class LibrarySentenceAdapter(private val context: Context, var data_sen:List<LibrarySentenceSave>) :
class LibrarySentenceAdapter(private val context: Context) :
    RecyclerView.Adapter<LibrarySentenceViewHolder>() {

    private lateinit var itemClickListener : LibraryThemaAdapter.ItemClickListener

    var data_sen = mutableListOf<LibrarySentenceData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibrarySentenceViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_library_sentence, parent, false)
        return LibrarySentenceViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data_sen.size
    }

    override fun onBindViewHolder(holder: LibrarySentenceViewHolder, position: Int) {
        holder.bind(data_sen[position])

        //view에 onClickListener를 달고, 그 안에서 직접 만든 itemClickListener를 연결시킨다
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it,position)
        }
    }

    //클릭 인터페이스 정의
    interface ItemClickListener{
        fun onClick(view: View, position: Int)
    }
    //클릭리스너 선언


    //클릭 리스너 등록 메소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
//        this.itemClickListener = itemClickListener
    }

}