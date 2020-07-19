package com.example.mongleandroid.fragment

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.MainActivity.Companion.search_result
import com.example.mongleandroid.adapter.SearchRecentAdapter
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.SharedPreferenceController
import com.example.mongleandroid.network.data.response.ResponseRecommendKeywordData
import com.example.mongleandroid.network.data.response.ResponseSearchRecentData
import com.example.mongleandroid.network.data.response.ResponseSearchRecentDeleteData
import com.example.mongleandroid.showKeyboard
import kotlinx.android.synthetic.main.fragment_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment : Fragment() {

    lateinit var searchRecentAdapter: SearchRecentAdapter
    val requestToServer = RequestToServer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        LoadRecentKeyword()
        setRecommendKeyword() // 추천 키워드

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 검색창에 초점 맞추고, 키보드 올리는 부분
        search_fragment_et_search.requestFocus() // xml 파일에서 <requestFocus /> 적어줘야함
        search_fragment_et_search.showKeyboard() // 확장함수 showKeyboard.kt

        // 엔터 누르면 프레그먼트 이동
       search_fragment_et_search.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                //Perform Code
                replaceFragment()
                return@OnKeyListener true
            }
            false
        })

        // 검색 버튼 누르면 프레그먼트 이동
        search_fragment_btn_search.setOnClickListener {

            tv_no_keyword.visibility = GONE

            replaceFragment()
        }


        search_fragment_tv_delete.setOnClickListener {
            rv_recent_keyword.visibility = GONE

            requestToServer.service.requestSearchRecentDeleteRecent(
                token = context?.let { SharedPreferenceController.getAccessToken(it) }
            ).enqueue(
                object : Callback<ResponseSearchRecentDeleteData> {
                    override fun onFailure(call: Call<ResponseSearchRecentDeleteData>, t: Throwable) {
                        Log.d("통신실패", "${t}")
                    }

                    override fun onResponse(
                        call: Call<ResponseSearchRecentDeleteData>,
                        response: Response<ResponseSearchRecentDeleteData>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("최근 검색어 삭제", "${response.body()}")
                            rv_recent_keyword.adapter = searchRecentAdapter
                            searchRecentAdapter.notifyDataSetChanged()
                        }

                    }
                }
            )
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

    private fun setRecommendKeyword() {

        requestToServer.service.getRecommendKeyword().enqueue(
            object : Callback<ResponseRecommendKeywordData> {
                override fun onFailure(call: Call<ResponseRecommendKeywordData>, t: Throwable) {
                    Log.d("통신실패", "${t}")
                }

                override fun onResponse(
                    call: Call<ResponseRecommendKeywordData>,
                    response: Response<ResponseRecommendKeywordData>
                ) {
                    if (response.isSuccessful) {
                        Log.d("추천 키워드", "${response.body()}")

                        tv_recommend_keyword1.text = response.body()!!.data.get(0).toString()
                        tv_recommend_keyword2.text = response.body()!!.data.get(1).toString()
                        tv_recommend_keyword3.text = response.body()!!.data.get(2).toString()
                        tv_recommend_keyword4.text = response.body()!!.data.get(3).toString()
                        tv_recommend_keyword5.text = response.body()!!.data.get(4).toString()
                        tv_recommend_keyword6.text = response.body()!!.data.get(5).toString()
                        tv_recommend_keyword7.text = response.body()!!.data.get(6).toString()
                        tv_recommend_keyword8.text = response.body()!!.data.get(7).toString()
                        tv_recommend_keyword9.text = response.body()!!.data.get(8).toString()
                        tv_recommend_keyword10.text = response.body()!!.data.get(9).toString()
                        tv_recommend_keyword11.text = response.body()!!.data.get(10).toString()
                        tv_recommend_keyword12.text = response.body()!!.data.get(11).toString()
                        tv_recommend_keyword13.text = response.body()!!.data.get(12).toString()
                        tv_recommend_keyword14.text = response.body()!!.data.get(13).toString()
                        tv_recommend_keyword15.text = response.body()!!.data.get(14).toString()

                    }

                }
            }
        )

    }

    private fun LoadRecentKeyword() {
        requestToServer.service.requestSearchRecentData(
            token = context?.let { SharedPreferenceController.getAccessToken(it) }
        ).enqueue(
            object : Callback<ResponseSearchRecentData> {
                override fun onFailure(call: Call<ResponseSearchRecentData>, t: Throwable) {
                    Log.d("통신실패", "${t}")
                }

                override fun onResponse(
                    call: Call<ResponseSearchRecentData>,
                    response: Response<ResponseSearchRecentData>
                ) {
                    if (response.isSuccessful) {
                        Log.d("최근 검색어", "${response.body()!!.data}")

                        val layoutManager = LinearLayoutManager(view!!.context)
                        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
                        rv_recent_keyword.layoutManager = layoutManager

                        searchRecentAdapter = SearchRecentAdapter(view!!.context)
                        rv_recent_keyword.adapter = searchRecentAdapter
                        searchRecentAdapter.datas = response.body()!!.data
                        searchRecentAdapter.notifyDataSetChanged()
                    }

                }
            }
        )

    }
}