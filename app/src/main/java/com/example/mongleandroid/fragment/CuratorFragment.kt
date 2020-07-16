package com.example.mongleandroid.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.CuratorInThemeAdapter
import com.example.mongleandroid.adapter.CuratorRecommendAdapter
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.data.response.CuratorInTheme
import com.example.mongleandroid.network.data.response.ResponseRecommendCuratorData
import kotlinx.android.synthetic.main.fragment_curator.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.mongleandroid.network.data.response.ResponseResultCuratorData


class CuratorFragment : Fragment() {

    lateinit var curatorInThemeAdapter: CuratorInThemeAdapter

    lateinit var curatorInThemeAdapter2: CuratorInThemeAdapter

    lateinit var curatorRecommendAdapter : CuratorRecommendAdapter

    val requestToServer = RequestToServer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        curatorRecommendData()
        //curatorInThemeData()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_curator, container, false)
    }

    private fun curatorRecommendData() {
        requestToServer.service.getRecommendCurator()
            .enqueue(
                object : Callback<ResponseRecommendCuratorData> {
                    override fun onFailure(call: Call<ResponseRecommendCuratorData>, t: Throwable) {
                        Log.d("통신실패", "${t}")
                    }

                    override fun onResponse(
                        call: Call<ResponseRecommendCuratorData>,
                        response: Response<ResponseRecommendCuratorData>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("추천 큐레이터", "${response.body()}")
                            curatorRecommendAdapter = CuratorRecommendAdapter(view!!.context, response.body()!!.data)
                            fragment_curator_rv_recommend.adapter = curatorRecommendAdapter
                            curatorRecommendAdapter.notifyDataSetChanged()
                        }

                    }
                }
            )
    }
//
//    private fun curatorInThemeData() {
//        requestToServer.service.requestCuratorInThemeData(
//            token = ""
//        ).enqueue(
//            object : Callback<CuratorInTheme> {
//                override fun onFailure(call: Call<CuratorInTheme>, t: Throwable) {
//                    Log.d("통신실패", "${t}")
//                }
//
//                override fun onResponse(
//                    call: Call<CuratorInTheme>,
//                    response: Response<CuratorInTheme>
//                ) {
//                    if (response.isSuccessful) {
//                        response.body().let { body ->
//                            Log.d("추천 큐레이터", "${response.body()}")
//                            curatorInThemeAdapter = CuratorInThemeAdapter(view!!.context)
//                            fragment_curator_rv_curator1.adapter = curatorInThemeAdapter
//                            //curatorInThemeAdapter.datas = body!!.data
//                            curatorInThemeAdapter.notifyDataSetChanged()
//                        }
//
//                    }
//
//                }
//            }
//        )
//
//    }

}