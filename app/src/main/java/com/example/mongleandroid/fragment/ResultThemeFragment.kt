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
import com.example.mongleandroid.network.SharedPreferenceController
import com.example.mongleandroid.network.data.response.ResponseResultThemeData
import com.example.mongleandroid.network.data.response.ResultTheme
import kotlinx.android.synthetic.main.fragment_result_theme.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ResultThemeFragment : Fragment() {

    lateinit var resultThemeAdapter: ResultThemeAdapter

    val requestToServer = RequestToServer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        requestThemeData()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_theme, container, false)
    }

    private fun requestThemeData() {
        requestToServer.service.requestResultThemeData(
            token = SharedPreferenceController.getAccessToken(view!!.context),
            words = search_result
        ).enqueue(object : Callback<ResponseResultThemeData> {
            override fun onFailure(call: Call<ResponseResultThemeData>, t: Throwable) {
                Log.e("통신실패",t.toString())
            }
            override fun onResponse(call: Call<ResponseResultThemeData>, response: Response<ResponseResultThemeData>) {
                if (response.isSuccessful){
                    response.body().let { body ->
                        Log.d("테마 검색", "${response.body()}")
                        resultThemeAdapter = ResultThemeAdapter(view!!.context)
                        rv_result_theme.adapter = resultThemeAdapter
                        resultThemeAdapter.datas = body!!.data
                        resultThemeAdapter.notifyDataSetChanged()
                    }

                }

            }
        })
    }


}