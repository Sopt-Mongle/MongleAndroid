package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import kotlin.math.log


class WritingThemeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)  {

    val activity_writing_theme_img_theme = itemView.findViewById<ImageView>(R.id.activity_writing_theme_img_theme)
    //val activity_writing_theme_et_theme_title = itemView.findViewById<EditText>(R.id.activity_writing_theme_et_theme_title)


    fun bind(themeImgIdx: Int){
        val img : String = "@drawable/maketheme_img_theme_" + themeImgIdx.toString() + ".png"

        Glide.with(itemView).load(img).into(activity_writing_theme_img_theme)
    }
}