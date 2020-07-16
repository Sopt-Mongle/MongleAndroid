package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.request.RequestWritingThemeData


class WritingThemeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)  {

    //서버에서 온 데이터를 처리하는 곳이 아님


    val activity_writing_theme_img_theme = itemView.findViewById<ImageView>(R.id.activity_writing_theme_img_theme)
    //val activity_writing_theme_et_theme_title = itemView.findViewById<EditText>(R.id.activity_writing_theme_et_theme_title)


    fun bind(requestWritingThemeData: RequestWritingThemeData){
        when(requestWritingThemeData.themeImgIdx){
            1-> Glide.with(itemView).load(requestWritingThemeData.themeImgIdx).into(activity_writing_theme_img_theme)

        }
    }
}