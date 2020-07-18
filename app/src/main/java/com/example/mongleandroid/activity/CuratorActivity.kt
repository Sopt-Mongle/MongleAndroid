package com.example.mongleandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.CuratorAdapter
import com.example.mongleandroid.adapter.CuratorKeywordAdapter
import com.example.mongleandroid.adapter.MainThemeAdapter
import com.example.mongleandroid.adapter.ResultSentenceAdapter
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.SharedPreferenceController
import com.example.mongleandroid.network.data.CuratorData
import com.example.mongleandroid.network.data.response.ResponseCuratorFollowedData
import com.example.mongleandroid.network.data.response.ResponseCuratorKeywordData
import com.example.mongleandroid.network.data.response.ResponseResultSentenceData
import kotlinx.android.synthetic.main.activity_curator.*
import kotlinx.android.synthetic.main.fragment_result_sentence.*
import kotlinx.android.synthetic.main.item_result_curator.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CuratorActivity : AppCompatActivity() {

    lateinit var curatorKeywordAdapter: CuratorKeywordAdapter

    val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curator)

        curatorKeyword()
        subscribed()

    }

    private fun curatorKeyword() {
        requestToServer.service.getCuratorKeyword(
            token = applicationContext?.let { SharedPreferenceController.getAccessToken(it) },
            params = intent.getIntExtra("params",0)
        ).enqueue(object : Callback<ResponseCuratorKeywordData> {
            override fun onFailure(call: Call<ResponseCuratorKeywordData>, t: Throwable) {
                Log.e("통신실패", t.toString())
            }

            override fun onResponse(
                call: Call<ResponseCuratorKeywordData>,
                response: Response<ResponseCuratorKeywordData>
            ) {
                if (response.isSuccessful) {
                    var intent_params = intent.getIntExtra("params", 0)
                    response.body().let { body ->
                        Log.d("키워드 큐레이터 출력", "${response.body()!!.data}")
                        when(intent_params) {
                            1 -> activity_curator_tv_keyword.setText("감성자극")
                            2 -> activity_curator_tv_keyword.setText("동기부여")
                            3 -> activity_curator_tv_keyword.setText("자기계발")
                            4 -> activity_curator_tv_keyword.setText("깊은생각")
                            5 -> activity_curator_tv_keyword.setText("독서기록")
                            6 -> activity_curator_tv_keyword.setText("일상문장")
                        }

                        if(response.body()!!.data[0].curatorIdx == 1) {
                            Log.d("구독", "구독시작")
                            curatorKeywordAdapter.setItemClickListener(object : CuratorKeywordAdapter.ItemClickListener{
                                override fun onClick(view: View, position: Int) {
                                    Log.d("SSS","${position}번 리스트 선택")
                                    requestToServer.service.getFollowIdx(
                                        token = applicationContext?.let { SharedPreferenceController.getAccessToken(it) },
                                        params = response.body()!!.data[0].curatorIdx
                                    ).enqueue(object : Callback<ResponseCuratorFollowedData> {
                                        override fun onFailure(call: Call<ResponseCuratorFollowedData>, t: Throwable) {
                                            Log.e("통신실패", t.toString())
                                        }

                                        override fun onResponse(
                                            call: Call<ResponseCuratorFollowedData>,
                                            response: Response<ResponseCuratorFollowedData>
                                        ) {
                                            if (response.isSuccessful) {
                                                if(response.body()!!.data) {
                                                    Log.d("구독", "구독됨")
                                                }
                                            }

                                        }
                                    })
                                }
                            })

                        }


                        curatorKeywordAdapter = CuratorKeywordAdapter(applicationContext, body!!.data)
                        rv_curator_keyword.adapter = curatorKeywordAdapter
                        curatorKeywordAdapter.notifyDataSetChanged()
                    }

                }

            }
        })
    }



    private fun subscribed() {

    }

}