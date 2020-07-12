package com.example.mongleandroid.fragment

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.MainActivity.Companion.search_result
import com.example.mongleandroid.adapter.SearchRecentAdapter
import com.example.mongleandroid.network.data.SearchRecentData
import com.example.mongleandroid.showKeyboard
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

        // 검색창에 초점 맞추고, 키보드 올리는 부분
        search_fragment_et_search.requestFocus() // xml 파일에서 <requestFocus /> 적어줘야함
        search_fragment_et_search.showKeyboard() // 확장함수 showKeyboard.kt

        // 엔터 누누
       search_fragment_et_search.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                //Perform Code
                replaceFragment()
                return@OnKeyListener true
            }
            false
        })

        search_fragment_btn_search.setOnClickListener {

            LoadRecentKeyword() // 최근 키워드
            tv_no_keyword.visibility = GONE

            replaceFragment()
        }

        setRecommendKeyword() // 추천 키워드
        search_fragment_tv_delete.setOnClickListener {
            LoadRecentKeyword()
            searchRecentAdapter.datas.clear()
            searchRecentAdapter.notifyDataSetChanged()
            tv_no_keyword.visibility = VISIBLE
        } // 최근 키워드 전체 삭제
    }

    private fun replaceFragment() {
        // 검색어 보내주기
        val searchword = search_fragment_et_search.text.toString()
        search_result = searchword.trim()

        // fragment 변경
        val transaction = getFragmentManager()?.beginTransaction()
        transaction?.replace(R.id.search_fragment_cl, SearchResultFragment())
        transaction?.commit()
        search_fragment_cl_keyword.visibility = GONE
    }

    private fun setRecommendKeyword(){
        tv_recommend_keyword1.text = "임의로"
        tv_recommend_keyword2.text = "추천검색어를"
        tv_recommend_keyword3.text = "넣어보자"
        tv_recommend_keyword4.text = "몽글몽글"
        tv_recommend_keyword5.text = "가나다라"
        tv_recommend_keyword6.text = "마바사아"
    }

    private fun LoadRecentKeyword() {
        searchRecentAdapter = SearchRecentAdapter(view!!.context)
        rv_recent_keyword.adapter = searchRecentAdapter

        searchRecentDatas.apply {
            add(
                SearchRecentData(
                    tv_recent_keyword = search_fragment_et_search.text.toString()
                )
            )
            searchRecentAdapter.datas = searchRecentDatas
            searchRecentAdapter.notifyDataSetChanged()
        }
    }
}