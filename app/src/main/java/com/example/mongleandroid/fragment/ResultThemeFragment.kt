package com.example.mongleandroid.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.MainActivity.Companion.search_result
import com.example.mongleandroid.adapter.ResultThemeAdapter
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.data.response.ResponseResultThemeData
import kotlinx.android.synthetic.main.fragment_result_theme.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ResultThemeFragment : Fragment() {

    lateinit var resultThemeAdapter: ResultThemeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_theme, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestData()
    }

    private fun requestData() {
        val call: Call<ResponseResultThemeData> =
            RequestToServer.service.requestResultThemeData(words = search_result)
        call.enqueue(object : Callback<ResponseResultThemeData> {
            override fun onFailure(call: Call<ResponseResultThemeData>, t: Throwable) {
                Log.e("requestUser 통신실패",t.toString())
            }
            override fun onResponse(call: Call<ResponseResultThemeData>, response: Response<ResponseResultThemeData>) {
                if (response.isSuccessful){
                    response.body().let { body->
                        Log.e("history 통신응답바디", "status: ${body!!.status} data : ${body.message}")
                        resultThemeAdapter.datas = body!!.data
                        resultThemeAdapter.notifyDataSetChanged()
                    }
                }
            }
        })
    }


}