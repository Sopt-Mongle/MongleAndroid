package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.LibraryThemaViewHolder
import com.example.mongleandroid.network.data.LibraryThemaData
import com.example.mongleandroid.network.data.response.LibraryThemeSave
import com.example.mongleandroid.network.data.response.LibraryThemeWrite

//class LibraryThemaAdapter(private val context: Context, var data_the_write : List<LibraryThemeSave>) :
//    RecyclerView.Adapter<LibraryThemaViewHolder>() {
//
//    private lateinit var itemClickListener : ItemClickListener
//
////    var data_the = mutableListOf<LibraryThemeWrite>()
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryThemaViewHolder {
//        val view = LayoutInflater.from(context).inflate(R.layout.item_library_thema, parent, false)
//        return LibraryThemaViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return data_the_write.size
//    }
//
//    override fun onBindViewHolder(holder: LibraryThemaViewHolder, position: Int) {
//        holder.bind(data_the_write[position])
//
//        //view에 onClickListener를 달고, 그 안에서 직접 만든 itemClickListener를 연결시킨다
//        holder.itemView.setOnClickListener {
//            itemClickListener.onClick(it,position)
//        }
//
//    }
//
//    //클릭 인터페이스 정의
//    interface ItemClickListener{
//        fun onClick(view: View, position: Int)
//    }
//    //클릭리스너 선언
//
//
//    //클릭 리스너 등록 메소드
//    fun setItemClickListener(itemClickListener: ItemClickListener) {
//        this.itemClickListener = itemClickListener
//    }
//
//
//}

class LibraryThemaAdapter(private val context: Context) :
    RecyclerView.Adapter<LibraryThemaViewHolder>() {

    private lateinit var itemClickListener : ItemClickListener

        var data_the_write = mutableListOf<LibraryThemaData>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryThemaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_library_thema, parent, false)
        return LibraryThemaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data_the_write.size
    }

    override fun onBindViewHolder(holder: LibraryThemaViewHolder, position: Int) {
        holder.bind(data_the_write[position])

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
        this.itemClickListener = itemClickListener
    }


}