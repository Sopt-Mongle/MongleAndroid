package com.example.mongleandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.MainPagerAdapter
import com.example.mongleandroid.adapter.TodaySentenceAdapter
import com.example.mongleandroid.network.data.TodaySentenceData
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_today_sentence.*

class MainFragment : Fragment() {

    private var data = mutableListOf<TodaySentenceData>()

    private lateinit var todaySentenceAdapter: TodaySentenceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vp_main.adapter = MainPagerAdapter(childFragmentManager)
        vp_main.offscreenPageLimit = 2
        tl_main.setupWithViewPager(vp_main)

        setAdapter(data)
    }

    private fun setAdapter(todaySentenceItem : MutableList<TodaySentenceData>) {
        todaySentenceAdapter =
            TodaySentenceAdapter(
                todaySentenceItem,
                this.context!!
            )
        loadDatas()
        main_fragment_rv_today_sentence.adapter = todaySentenceAdapter

    }

    private fun loadDatas() {
        data.apply {
            add(
                TodaySentenceData(
                    tv_today_sentence = "몽글몽글"
                )
            )

            add(
                TodaySentenceData(
                    tv_today_sentence = "Mongle is the best!"
                )
            )
            add(
                TodaySentenceData(
                    tv_today_sentence = "아프니까 청춘이다"
                )
            )
            add(
                TodaySentenceData(
                    tv_today_sentence = "인연이라고 하죠오~거부할 수가 없죠"
                )
            )
            add(
                TodaySentenceData(
                    tv_today_sentence = "룰루랄라라라라랄라랄"
                )
            )


        }
    }

}