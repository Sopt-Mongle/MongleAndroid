package com.example.mongleandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.ResultSentenceAdapter
import com.example.mongleandroid.adapter.ResultThemeAdapter
import com.example.mongleandroid.network.data.ResultSentenceData
import com.example.mongleandroid.network.data.ResultThemeData
import kotlinx.android.synthetic.main.fragment_result_sentence.*
import kotlinx.android.synthetic.main.fragment_result_theme.*

class ResultSentenceFragment : Fragment() {

    lateinit var resultSentenceAdapter: ResultSentenceAdapter
    val sentencedatas = mutableListOf<ResultSentenceData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_sentence, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultSentenceAdapter = ResultSentenceAdapter(view.context)
        rv_result_sentence.adapter = resultSentenceAdapter
        loadDatas() // 일단 임의로 넣어두기
    }

    private fun loadDatas() {
        sentencedatas.apply {
            add(
                ResultSentenceData(
                    result_sentence_tv_themename = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    result_sentence_tv_context = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다."
                )
            )
            add(
                ResultSentenceData(
                    result_sentence_tv_themename = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    result_sentence_tv_context = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다."
                )
            )
            add(
                ResultSentenceData(
                    result_sentence_tv_themename = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    result_sentence_tv_context = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다."
                )
            )
            resultSentenceAdapter.datas = sentencedatas
            resultSentenceAdapter.notifyDataSetChanged()
        }
    }

}