package com.example.mongleandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.ResultCuratorAdapter
import com.example.mongleandroid.adapter.ResultSentenceAdapter
import com.example.mongleandroid.network.data.ResultCuratorData
import com.example.mongleandroid.network.data.ResultSentenceData
import kotlinx.android.synthetic.main.fragment_result_curator.*
import kotlinx.android.synthetic.main.fragment_result_sentence.*

class ResultCuratorFragment : Fragment() {

    lateinit var resultCuratorAdapter: ResultCuratorAdapter
    val curatordatas = mutableListOf<ResultCuratorData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_curator, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultCuratorAdapter = ResultCuratorAdapter(view.context)
        rv_result_curator.adapter = resultCuratorAdapter
        loadDatas() // 일단 임의로 넣어두기
    }

    private fun loadDatas() {
        curatordatas.apply {
            add(
                ResultCuratorData(
                    result_curator_img_profile = R.drawable.ic_launcher_background,
                    result_curator_tv_name = "이름은 여기",
                    result_curator_tv_subcount = "540",
                    result_curator_tv_keyword = "대학내일"
                )
            )
            add(
                ResultCuratorData(
                    result_curator_img_profile = R.drawable.ic_launcher_background,
                    result_curator_tv_name = "이름은 여기",
                    result_curator_tv_subcount = "540",
                    result_curator_tv_keyword = "대학내일"
                )
            )
            add(
                ResultCuratorData(
                    result_curator_img_profile = R.drawable.ic_launcher_background,
                    result_curator_tv_name = "이름은 여기",
                    result_curator_tv_subcount = "540",
                    result_curator_tv_keyword = "대학내일"
                )
            )
            resultCuratorAdapter.datas = curatordatas
            resultCuratorAdapter.notifyDataSetChanged()
        }
    }
}