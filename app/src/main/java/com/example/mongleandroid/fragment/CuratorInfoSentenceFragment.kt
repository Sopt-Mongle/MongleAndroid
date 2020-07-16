package com.example.mongleandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.CuratorInfoSentenceAdapter
import com.example.mongleandroid.network.data.CuratorInfoSentenceData
import kotlinx.android.synthetic.main.fragment_curator_info_sentence.*


class CuratorInfoSentenceFragment : Fragment() {

    lateinit var curatorInfoSentenceAdapter: CuratorInfoSentenceAdapter
    val datas = mutableListOf<CuratorInfoSentenceData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_curator_info_sentence, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        curatorInfoSentenceAdapter = CuratorInfoSentenceAdapter(view.context)
        rv_sentence_cu_info.adapter = curatorInfoSentenceAdapter
        loadDatas()
    }

    private fun loadDatas() {
        datas.apply {
            add(
                CuratorInfoSentenceData(
                    tv_library_sentence_themename_cu_info = "몽글몽글한 테마다 몽글몽글",
                    tv_library_sentence_sentence_cu_info = "봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다.",
                    tv_item_library_sentence_username_cu_info = "예스리1"
                )
            )
            add(
                CuratorInfoSentenceData(
                    tv_library_sentence_themename_cu_info = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence_cu_info = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다.",
                    tv_item_library_sentence_username_cu_info = "예스리"
                )
            )
            add(
                CuratorInfoSentenceData(
                    tv_library_sentence_themename_cu_info = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence_cu_info = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다.",
                    tv_item_library_sentence_username_cu_info = "예스리"
                )
            )
            add(
                CuratorInfoSentenceData(
                    tv_library_sentence_themename_cu_info = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence_cu_info = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다.",
                    tv_item_library_sentence_username_cu_info = "예스리"
                )
            )
            add(
                CuratorInfoSentenceData(
                    tv_library_sentence_themename_cu_info = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence_cu_info = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다.",
                    tv_item_library_sentence_username_cu_info = "예스리"
                )
            )
            add(
                CuratorInfoSentenceData(
                    tv_library_sentence_themename_cu_info = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence_cu_info = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다.",
                    tv_item_library_sentence_username_cu_info = "예스리"
                )
            )
            add(
                CuratorInfoSentenceData(
                    tv_library_sentence_themename_cu_info = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence_cu_info = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다.",
                    tv_item_library_sentence_username_cu_info = "예스리"
                )
            )
            add(
                CuratorInfoSentenceData(
                    tv_library_sentence_themename_cu_info = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence_cu_info = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다.",
                    tv_item_library_sentence_username_cu_info = "예스리"
                )
            )
            add(
                CuratorInfoSentenceData(
                    tv_library_sentence_themename_cu_info = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence_cu_info = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다.",
                    tv_item_library_sentence_username_cu_info = "예스리"
                )
            )
            add(
                CuratorInfoSentenceData(
                    tv_library_sentence_themename_cu_info = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence_cu_info = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다.",
                    tv_item_library_sentence_username_cu_info = "예스리"
                )
            )
            add(
                CuratorInfoSentenceData(
                    tv_library_sentence_themename_cu_info = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence_cu_info = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다.",
                    tv_item_library_sentence_username_cu_info = "예스리"
                )
            )
            add(
                CuratorInfoSentenceData(
                    tv_library_sentence_themename_cu_info = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence_cu_info = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다.",
                    tv_item_library_sentence_username_cu_info = "예스리"
                )
            )

        }
        curatorInfoSentenceAdapter.data_sen_cu_info = datas
        curatorInfoSentenceAdapter.notifyDataSetChanged()
    }
}