package com.example.mongleandroid.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.NoThemeActivity
import com.example.mongleandroid.adapter.LibraryThemaAdapter
import com.example.mongleandroid.adapter.LibraryThemaClickAdapter
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.SharedPreferenceController
import com.example.mongleandroid.network.data.LibraryThemaData
import com.example.mongleandroid.network.data.response.ResponseLibraryThemeData
import com.example.mongleandroid.network.data.response.ResponseRecommendCuratorData
import kotlinx.android.synthetic.main.fragment_library_sentence.*
import kotlinx.android.synthetic.main.fragment_library_thema.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LibraryThemaFragment : Fragment() {

    val requestToServer = RequestToServer

    lateinit var libraryThemaAdapter: LibraryThemaAdapter
    lateinit var libraryThemaClickAdapter: LibraryThemaClickAdapter

//    val libraryThemaDatas = mutableListOf<LibraryThemaData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library_thema, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        libraryThemaAdapter = LibraryThemaAdapter(view.context)
//        rv_library_thema.adapter = libraryThemaAdapter
//        loadDatas()

        requestLibraryThemeData()

        //클릭 시에 어댑터의 값만 바꿔주는 걸로 item 바꿀 수 있음.
        rdbtn_saved_thema.setOnClickListener {
            if (rdbtn_saved_thema.isChecked) {
//                rv_library_sentence.adapter = librarySentenceAdapter
                requestLibraryThemeData()
            } else {

            }
        }


        rdbtn_making_thema.setOnClickListener {
            if (rdbtn_making_thema.isChecked) {
//                rv_library_sentence.adapter = librarySentenceClickAdapter
                requestLibraryThemeClickData()
            } else {


            }

        }

//        tx_non_thema.setOnClickListener {
//            activity?.let {
//                val intent = Intent(context, NoThemeActivity::class.java)
//                startActivity(intent)
//            }
//        }



    }


//    private fun loadDatas() {
//        libraryThemaDatas.apply {
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//            add(
//                LibraryThemaData(
//                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
//                            "기대고만 싶을 때 보면 좋은 문장",
//                    tv_thema_num_library = "107",
//                    tv_sentence_count_library_item = "15"
//                )
//            )
//
//
//        }
//        libraryThemaAdapter.data_the = libraryThemaDatas
//        libraryThemaAdapter.notifyDataSetChanged()
//    }


    private fun requestLibraryThemeData() {
        requestToServer.service.lookLibraryThema(
            token = SharedPreferenceController.getAccessToken(view!!.context)
        )
            .enqueue(
                object : Callback<ResponseLibraryThemeData> {
                    override fun onFailure(call: Call<ResponseLibraryThemeData>, t: Throwable) {
                        Log.d("통신실패", "${t}")
                    }

                    override fun onResponse(
                        call: Call<ResponseLibraryThemeData>,
                        response: Response<ResponseLibraryThemeData>
                    ) {
                        if(response.isSuccessful) {
                            Log.d("내서재 테마 조회", "${response.body()}")

                            libraryThemaAdapter = LibraryThemaAdapter(view!!.context, response.body()!!.data!!.save)
                            rv_library_thema.adapter = libraryThemaAdapter
                            libraryThemaAdapter.notifyDataSetChanged()
                        }
                    }
                }
            )
    }

    private fun requestLibraryThemeClickData() {
        requestToServer.service.lookLibraryThema(
            token = SharedPreferenceController.getAccessToken(view!!.context)
        )
            .enqueue(
                object : Callback<ResponseLibraryThemeData> {
                    override fun onFailure(call: Call<ResponseLibraryThemeData>, t: Throwable) {
                        Log.d("통신실패", "${t}")
                    }

                    override fun onResponse(
                        call: Call<ResponseLibraryThemeData>,
                        response: Response<ResponseLibraryThemeData>
                    ) {
                        if(response.isSuccessful) {
                            Log.d("내서재 테마 저장 조회", "${response.body()}")

                            libraryThemaClickAdapter = LibraryThemaClickAdapter(view!!.context, response.body()!!.data!!.write)
                            rv_library_thema.adapter = libraryThemaClickAdapter
                            libraryThemaClickAdapter.notifyDataSetChanged()
                        }
                    }
                }
            )
    }

}

