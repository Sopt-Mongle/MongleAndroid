package com.example.mongleandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.LibraryThemaAdapter
import com.example.mongleandroid.network.data.LibraryThemaData
import kotlinx.android.synthetic.main.fragment_library_thema.*

class LibraryThemaFragment : Fragment() {

    lateinit var libraryThemaAdapter: LibraryThemaAdapter
    val libraryThemaDatas = mutableListOf<LibraryThemaData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library_thema, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        libraryThemaAdapter = LibraryThemaAdapter(view.context)
        rv_library_thema.adapter = libraryThemaAdapter
        loadDatas()
    }

    private fun loadDatas() {
        libraryThemaDatas.apply {
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )
            add(
                LibraryThemaData(
                    tv_library_thema = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게\n" +
                            "기대고만 싶을 때 보면 좋은 문장",
                    tv_thema_num_library = "107",
                    tv_sentence_count_library_item = "15"
                )
            )


        }
        libraryThemaAdapter.data_the = libraryThemaDatas
        libraryThemaAdapter.notifyDataSetChanged()
    }


}

