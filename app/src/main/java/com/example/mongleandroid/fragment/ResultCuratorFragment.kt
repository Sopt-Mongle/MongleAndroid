package com.example.mongleandroid.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.MainActivity.Companion.search_result
import com.example.mongleandroid.adapter.ResultCuratorAdapter
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.SharedPreferenceController
import com.example.mongleandroid.network.data.response.ResponseResultCuratorData
import kotlinx.android.synthetic.main.fragment_result_curator.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultCuratorFragment : Fragment() {

    lateinit var resultCuratorAdapter: ResultCuratorAdapter
    val requestToServer = RequestToServer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requestCuratorData()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_curator, container, false)
    }

    private fun requestCuratorData() {
        requestToServer.service.requestResultCuratorData(
            token = context?.let { SharedPreferenceController.getAccessToken(it) },
            words = search_result
        ).enqueue(object : Callback<ResponseResultCuratorData> {
            override fun onFailure(call: Call<ResponseResultCuratorData>, t: Throwable) {
                Log.e("통신실패",t.toString())
            }
            override fun onResponse(call: Call<ResponseResultCuratorData>, response: Response<ResponseResultCuratorData>) {
                if (response.isSuccessful){
                    response.body().let { body ->
                        Log.d("큐레이터 검색", "${response.body()}")
                        result_curator_count.text = response.body()!!.data.size.toString()
                        resultCuratorAdapter = ResultCuratorAdapter(view!!.context, body!!.data)
                        rv_result_curator.adapter = resultCuratorAdapter
                        resultCuratorAdapter.notifyDataSetChanged()
                    }
                } else {
                    fragment_result_curator_cl_noresult.visibility = VISIBLE
                }
            }
        })
    }

}