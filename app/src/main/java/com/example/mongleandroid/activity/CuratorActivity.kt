package com.example.mongleandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.CuratorAdapter
import com.example.mongleandroid.adapter.CuratorKeywordAdapter
import com.example.mongleandroid.adapter.ResultSentenceAdapter
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.SharedPreferenceController
import com.example.mongleandroid.network.data.CuratorData
import com.example.mongleandroid.network.data.response.ResponseCuratorKeywordData
import com.example.mongleandroid.network.data.response.ResponseResultSentenceData
import kotlinx.android.synthetic.main.activity_curator.*
import kotlinx.android.synthetic.main.fragment_result_sentence.*
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

    }

    private fun curatorKeyword() {
        requestToServer.service.getCuratorKeyword(
            token = applicationContext?.let { SharedPreferenceController.getAccessToken(it) },
            params = intent.getIntExtra("params",1)
        ).enqueue(object : Callback<ResponseCuratorKeywordData> {
            override fun onFailure(call: Call<ResponseCuratorKeywordData>, t: Throwable) {
                Log.e("통신실패", t.toString())
            }

            override fun onResponse(
                call: Call<ResponseCuratorKeywordData>,
                response: Response<ResponseCuratorKeywordData>
            ) {
                if (response.isSuccessful) {
                    response.body().let { body ->
                        Log.d("키워드 큐레이터 출력", "${response.body()!!.data}")
                        curatorKeywordAdapter = CuratorKeywordAdapter(applicationContext, body!!.data)
                        rv_curator_keyword.adapter = curatorKeywordAdapter
                        curatorKeywordAdapter.notifyDataSetChanged()
                    }

                }
            }
        })
    }

}