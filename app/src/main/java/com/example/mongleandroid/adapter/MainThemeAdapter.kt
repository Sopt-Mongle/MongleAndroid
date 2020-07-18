package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.MainThemeViewHolder
import com.example.mongleandroid.network.data.response.DataSentence
import com.example.mongleandroid.network.data.response.ResponseThemeDetailData

class MainThemeAdapter(var datas: List<DataSentence>, val context: Context) :
    RecyclerView.Adapter<MainThemeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainThemeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_activity_theme, parent, false)
        return MainThemeViewHolder(view)
    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: MainThemeViewHolder, position: Int) {
        holder.bind(datas[position])

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it,position)
        }
    }

    //클릭 인터페이스 정의
    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    //클릭리스너 선언
    private lateinit var itemClickListener: ItemClickListener

    //클릭리스너 등록 메소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }
}


