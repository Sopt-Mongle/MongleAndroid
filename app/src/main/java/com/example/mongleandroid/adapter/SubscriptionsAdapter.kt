package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.SubscriptionsViewHolder
import com.example.mongleandroid.network.data.SubscriptionsData

class SubscriptionsAdapter(private val context: Context) :
    RecyclerView.Adapter<SubscriptionsViewHolder>() {

    var datas = mutableListOf<SubscriptionsData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriptionsViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_subscriptions, parent, false)
        return SubscriptionsViewHolder(
            view
        )

    }

    override fun getItemCount(): Int {
        return datas.size

    }

    override fun onBindViewHolder(holder: SubscriptionsViewHolder, position: Int) {

        holder.bind(datas[position])

    }
}