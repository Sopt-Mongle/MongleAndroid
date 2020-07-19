package com.example.mongleandroid.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.MainActivity.Companion.search_result
import com.example.mongleandroid.adapter.ResultSentenceAdapter
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.data.response.ResponseResultSentenceData
import kotlinx.android.synthetic.main.fragment_result_sentence.*
import kotlinx.android.synthetic.main.fragment_result_theme.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultSentenceFragment : Fragment() {

    lateinit var resultSentenceAdapter: ResultSentenceAdapter

    val requestToServer = RequestToServer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requestSentenceData()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_sentence, container, false)
    }

    private fun requestSentenceData() {
        requestToServer.service.requestResultSentenceData(
            words = search_result
        ).enqueue(object : Callback<ResponseResultSentenceData> {
            override fun onFailure(call: Call<ResponseResultSentenceData>, t: Throwable) {
                Log.e("통신실패",t.toString())
            }
            override fun onResponse(call: Call<ResponseResultSentenceData>, response: Response<ResponseResultSentenceData>) {
                if (response.isSuccessful){
                    Log.d("문장 검색", "${response.body()}")
                    result_sentence_count.text = response.body()!!.data.size.toString()
                    resultSentenceAdapter = ResultSentenceAdapter(view!!.context, response.body()!!.data)
                    rv_result_sentence.adapter = resultSentenceAdapter
                    resultSentenceAdapter.notifyDataSetChanged()
                } else {
                    fragment_result_sentence_cl_noresult.visibility = View.VISIBLE
                }
            }
        })
    }

}