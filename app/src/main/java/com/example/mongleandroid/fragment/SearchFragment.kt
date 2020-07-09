package com.example.mongleandroid.fragment

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.InputMethodManager.SHOW_IMPLICIT
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.SearchRecentAdapter
import com.example.mongleandroid.network.data.SearchRecentData
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
        search_fragment_et_search.requestFocus()
        search_fragment_et_search.showKeyboard()

        search_fragment_btn_search.setOnClickListener {
            LoadRecentKeyword()
        }

        setRecommendKeyword()
        search_fragment_tv_delete.setOnClickListener {
            searchRecentAdapter.datas.clear()
            searchRecentAdapter.notifyDataSetChanged()
            tv_no_keyword.visibility = VISIBLE
        } // 최근 키워드 전체 삭제
    }

    private fun EditText.showKeyboard() {
        if (requestFocus()) {
            // edittext에 초점이 맞춰지면 키보드 올라옴
            (getActivity()?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)
                .showSoftInput(this, SHOW_IMPLICIT)
            setSelection(text.length)
        }
    }

    private fun setRecommendKeyword(){
        tv_recommend_keyword1.text = "임의로"
        tv_recommend_keyword2.text = "추천검색어를"
        tv_recommend_keyword3.text = "넣어보자"
        tv_recommend_keyword4.text = "몽글몽글"
        tv_recommend_keyword5.text = "가나다라"
        tv_recommend_keyword6.text = "마바사아아아아아아ㅏ아아아아아악"
    }

    private fun LoadRecentKeyword() {
        searchRecentAdapter = SearchRecentAdapter(view!!.context)
        rv_recent_keyword.adapter = searchRecentAdapter

        searchRecentDatas.apply {
            add(
                SearchRecentData(
                    tv_recent_keyword = "일단은"
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
            add(
                SearchRecentData(
                    tv_recent_keyword = "다섯개만"
                )
            )
            add(
                SearchRecentData(
                    tv_recent_keyword = "넣는다"
                )
            )
            searchRecentAdapter.datas = searchRecentDatas
            searchRecentAdapter.notifyDataSetChanged()
        }

    }
}