package com.example.mongleandroid.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.MainActivity.Companion.search_result
import com.example.mongleandroid.adapter.ResultCuratorAdapter
import com.example.mongleandroid.network.RequestToServer
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
        requestToServer.service.requestResultCuratorData(
            //token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjE4LCJuYW1lIjoieiIsImlhdCI6MTU5NDg0Nzg2NiwiZXhwIjoxNTk1MDIwNjY2LCJpc3MiOiJtb25nbGUifQ.IQFvbHzqeE_6vc_Vo7aVJ9fhaOuYmTGpXv1cSE1j9hw",
            words = search_result
        ).enqueue(object : Callback<ResponseResultCuratorData> {
            override fun onFailure(call: Call<ResponseResultCuratorData>, t: Throwable) {
                Log.e("통신실패",t.toString())
            }
            override fun onResponse(call: Call<ResponseResultCuratorData>, response: Response<ResponseResultCuratorData>) {
                if (response.isSuccessful){
                    Log.d("큐레이터 검색", "${response.body()}")
                    resultCuratorAdapter = ResultCuratorAdapter(view!!.context, response.body()!!.data)
                    rv_result_curator.adapter = resultCuratorAdapter
                    resultCuratorAdapter.notifyDataSetChanged()
                }
            }
        })

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_curator, container, false)
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//    }
////
//    private fun requestCuratorData() {
//
//    }

}