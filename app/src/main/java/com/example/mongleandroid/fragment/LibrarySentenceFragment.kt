package com.example.mongleandroid.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.LibrarySentenceAdapter
import com.example.mongleandroid.network.data.LibrarySentenceData
import kotlinx.android.synthetic.main.fragment_library_sentence.*


class LibrarySentenceFragment : Fragment() {

    lateinit var librarySentenceAdapter: LibrarySentenceAdapter
    val librarySentenceData = mutableListOf<LibrarySentenceData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library_sentence, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        librarySentenceAdapter = LibrarySentenceAdapter(view.context)
        rv_library_sentence.adapter = librarySentenceAdapter
        loadDatas()
    }

    private fun loadDatas() {
        librarySentenceData.apply {
            add(
                LibrarySentenceData(
                    tv_library_sentence_themename = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다. ",
                    tv_item_library_sentence_username = "예스리"
                )
            )
            add(
                LibrarySentenceData(
                    tv_library_sentence_themename = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다. ",
                    tv_item_library_sentence_username = "예스리"
                )
            )
            add(
                LibrarySentenceData(
                    tv_library_sentence_themename = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다. ",
                    tv_item_library_sentence_username = "예스리"
                )
            )
            add(
                LibrarySentenceData(
                    tv_library_sentence_themename = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다. ",
                    tv_item_library_sentence_username = "예스리"
                )
            )
            add(
                LibrarySentenceData(
                    tv_library_sentence_themename = "번아웃을 극복하고 싶을 때 봐야하는 문장",
                    tv_library_sentence_sentence = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔 했던 봄을 생각하면 마음이 섬찟해진다. ",
                    tv_item_library_sentence_username = "예스리"
                )
            )


        }
        librarySentenceAdapter.data_sen = librarySentenceData
        librarySentenceAdapter.notifyDataSetChanged()
    }


}