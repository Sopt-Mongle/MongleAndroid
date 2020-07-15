package com.example.mongleandroid.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.MainActivity
import com.example.mongleandroid.activity.MainActivity.Companion.search_result
import com.example.mongleandroid.adapter.ResultThemeAdapter
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.data.request.RequestResultThemeData
import com.example.mongleandroid.network.data.response.ResponseResultThemeData
import kotlinx.android.synthetic.main.fragment_result_theme.*
import retrofit2.Call
import retrofit2.Callback


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


        val requestToServer = RequestToServer

        requestToServer.service.RequestResultThemeData(
            RequestResultThemeData(
                words = search_result
            )
        ).enqueue(
            object : Callback<ResponseResultThemeData> {
                override fun onFailure(call: Call<ResponseResultThemeData>, t: Throwable) {
                    Log.d("통신실패", "${t}")
                }

                override fun onResponse(
                    call: Call<ResponseResultThemeData>,
                    response:retrofit2.Response<ResponseResultThemeData>
                ) {
                    if (response.isSuccessful) {
                        resultThemeAdapter  = ResultThemeAdapter(view!!.context, response.body()!!.data)
                        rv_result_theme.adapter = resultThemeAdapter

                    }

                }
            }
        )

    }



}