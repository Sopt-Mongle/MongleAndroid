package com.example.mongleandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.MainThemeAdapter
import com.example.mongleandroid.network.data.MainThemeData
import kotlinx.android.synthetic.main.activity_main_theme.*
import kotlinx.android.synthetic.main.activity_sentence_detail_view.*

class SentenceDetailViewActivity : AppCompatActivity() {

    private var data = mutableListOf<MainThemeData>()

    private lateinit var mainThemeAdapter : MainThemeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence_detail_view)
        setMainThemeAdapter(data)
    }
    private fun setMainThemeAdapter(mainThemeItem: MutableList<MainThemeData>) {
        mainThemeAdapter =
            MainThemeAdapter(
                mainThemeItem,
                this
            )
        loadDatas()
        rv_sentence_detail_view_theme_other_sentence.adapter = mainThemeAdapter
    }
    private fun loadDatas() {
        data.apply {
            add(
                MainThemeData(
                    tv_theme_sentence = "영 영앤 리치 남자를 만나자 감 감사하자",
                    tv_theme_curator = "몽글이 몽글몽글",
                    tv_like_num = "100",
                    tv_save_num = "30"
                )
            )
            add(
                MainThemeData(
                    tv_theme_sentence = "영 영앤 리치 남자를 만나자 감 감사하자",
                    tv_theme_curator = "몽글이 몽글몽글",
                    tv_like_num = "10",
                    tv_save_num = "300"
                )
            )
        }
    }
}