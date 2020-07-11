package com.example.mongleandroid.fragment

import android.R.color
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.ResultThemeAdapter
import com.example.mongleandroid.network.data.ResultThemeData
import kotlinx.android.synthetic.main.fragment_result_theme.*
import kotlinx.android.synthetic.main.item_result_theme.*


class ResultThemeFragment : Fragment() {

    lateinit var resultThemeAdapter: ResultThemeAdapter
    val themedatas = mutableListOf<ResultThemeData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_theme, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultThemeAdapter = ResultThemeAdapter(view.context)
        rv_result_theme.adapter = resultThemeAdapter
        loadDatas() // 일단 임의로 넣어두기x
    }

    private fun loadDatas() {
        themedatas.apply {
            add(
                ResultThemeData(
                    result_theme_tv_theme = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 기대고만 싶을 때 보면 좋은 문장",
                    result_theme_tv_bookmark = "107",
                    result_theme_tv_sentence_count = "15"
                )
            )
            add(
                ResultThemeData(
                    result_theme_tv_theme = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 기대고만 싶을 때 보면 좋은 문장",
                    result_theme_tv_bookmark = "107",
                    result_theme_tv_sentence_count = "15"
                )
            )
            add(
                ResultThemeData(
                    result_theme_tv_theme = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 기대고만 싶을 때 보면 좋은 문장",
                    result_theme_tv_bookmark = "107",
                    result_theme_tv_sentence_count = "15"
                )
            )
            resultThemeAdapter.datas = themedatas
            resultThemeAdapter.notifyDataSetChanged()
        }
    }

}