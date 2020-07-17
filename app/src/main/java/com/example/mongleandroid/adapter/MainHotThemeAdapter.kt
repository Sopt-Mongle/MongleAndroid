package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.HotThemeViewHolder
import com.example.mongleandroid.network.data.response.MainThemes

class MainHotThemeAdapter(var datas: List<MainThemes>, val context: Context) : RecyclerView.Adapter<HotThemeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotThemeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main_hot_theme, parent, false)
        return HotThemeViewHolder(view)
    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: HotThemeViewHolder, position: Int) {
        holder.bind(datas[position])

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
    private lateinit var itemClickListener: ItemClickListener

    //클릭 리스너 등록 메소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }
}