package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.CuratorRecommendViewHolder
import com.example.mongleandroid.network.data.response.RecommendCurator

class CuratorRecommendAdapter(private val context : Context, val datas : List<RecommendCurator>) : RecyclerView.Adapter<CuratorRecommendViewHolder>() {
//    var datas = mutableListOf<ResponseRecommendCuratorData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuratorRecommendViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_result_curator, parent, false)
        return CuratorRecommendViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: CuratorRecommendViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}