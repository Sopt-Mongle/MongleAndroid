package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.NowHotCuratorViewHolder
import com.example.mongleandroid.network.data.response.MainCurator


class MainNowHotCuratorAdapter (var datas: List<MainCurator>, val context: Context) : RecyclerView.Adapter<NowHotCuratorViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowHotCuratorViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main_now_hot_curator,parent,false)
        return NowHotCuratorViewHolder(view)
    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: NowHotCuratorViewHolder, position: Int) {
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

    //클릭리스너 등록 메소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }
}