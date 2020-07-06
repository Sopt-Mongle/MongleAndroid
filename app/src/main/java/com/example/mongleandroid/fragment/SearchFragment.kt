package com.example.mongleandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.example.mongleandroid.R
import com.example.mongleandroid.SearchRecentAdapter
import com.example.mongleandroid.SearchRecentData
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : Fragment() {

    lateinit var searchRecentAdapter: SearchRecentAdapter
    val searchRecentDatas = mutableListOf<SearchRecentData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchRecentAdapter =
            SearchRecentAdapter(view.context)
        rv_recent_keyword.adapter = searchRecentAdapter
        LoadRecentKeyword()
        setRecommendKeyword()
        search_fragment_btn_recent_delete.setOnClickListener {
            searchRecentAdapter.datas.clear()
            searchRecentAdapter.notifyDataSetChanged()
            tv_no_keyword.visibility = VISIBLE


        }
    }

    private fun setRecommendKeyword(){
        tv_recommend_keyword1.text = "임의로"
        tv_recommend_keyword2.text = "추천검색어를"
        tv_recommend_keyword3.text = "넣어보자"
        tv_recommend_keyword4.text = "몽글몽글"
        tv_recommend_keyword5.text = "가나다라"
        tv_recommend_keyword6.text = "마바사"
    }

    private fun LoadRecentKeyword() {
        searchRecentDatas.apply {
            add(
                SearchRecentData(
                    tv_recent_keyword = "일단"
                )
            )
            add(
                SearchRecentData(
                    tv_recent_keyword = "임의 데이터를"
                )
            )
            add(
                SearchRecentData(
                    tv_recent_keyword = "넣어두자"
                )
            )

            searchRecentAdapter.datas = searchRecentDatas
            searchRecentAdapter.notifyDataSetChanged()
        }
    }
}