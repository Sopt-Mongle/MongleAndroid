package com.example.mongleandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.MainNowHotCuratorAdapter
import com.example.mongleandroid.adapter.MainPagerAdapter
import com.example.mongleandroid.adapter.TodaySentenceAdapter
import com.example.mongleandroid.network.data.MainNowHotCuratorData
import com.example.mongleandroid.network.data.TodaySentenceData
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_main_now_hot_curator.*
import kotlinx.android.synthetic.main.item_main_now_hot_curator.view.*
import kotlinx.android.synthetic.main.item_today_sentence.*

class MainFragment : Fragment() {

    private var data = mutableListOf<TodaySentenceData>()
    private var hotcuratorData = mutableListOf<MainNowHotCuratorData>()

    private lateinit var todaySentenceAdapter: TodaySentenceAdapter
    private lateinit var mainNowHotCuratorAdapter: MainNowHotCuratorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //뷰페이저 연결
        vp_main.adapter = MainPagerAdapter(childFragmentManager)
        vp_main.offscreenPageLimit = 2
        tl_main.setupWithViewPager(vp_main)

        setHotCuratorAdapter(hotcuratorData) // 지금 인기있는 큐레이터 리사이클러뷰
        setAdapter(data)//오늘의 문장 리사이클러뷰

    }
//지금 인기있는 큐레이터 어댑터 연결
    private fun setHotCuratorAdapter(mainNowHotCuratorData: MutableList<MainNowHotCuratorData>) {
        mainNowHotCuratorAdapter =
            MainNowHotCuratorAdapter(
                mainNowHotCuratorData,
                this.context!!
            )
        curatorLoadDatas()
        rv_main_now_hot_curator.adapter = mainNowHotCuratorAdapter
    }
    private fun curatorLoadDatas() {
        hotcuratorData.apply {
            add(
                MainNowHotCuratorData(
                    img_now_hot_curator = "https://cdn.pixabay.com/photo/2020/07/04/06/40/clouds-5368435__340.jpg",
                    tv_curator_name = "예스리",
                    tv_curator_keyword = "직장인의 비애"
                )
            )
            add(
                MainNowHotCuratorData(
                    img_now_hot_curator = "https://cdn.pixabay.com/photo/2020/01/20/20/58/building-4781384__340.jpg",
                    tv_curator_name = "래리",
                    tv_curator_keyword = "스타트업"
                )
            )
            add(
                MainNowHotCuratorData(
                    img_now_hot_curator = "https://cdn.pixabay.com/photo/2020/06/29/05/43/poppy-5351553__340.jpg",
                    tv_curator_name = "봄",
                    tv_curator_keyword = "대학내일"
                )
            )
            add(
                MainNowHotCuratorData(
                    img_now_hot_curator = "https://cdn.pixabay.com/photo/2020/07/05/12/53/rainbow-5372892__340.jpg",
                    tv_curator_name = "홍대병",
                    tv_curator_keyword = "과제충"
                )
            )
            add(
                MainNowHotCuratorData(
                    img_now_hot_curator = "https://cdn.pixabay.com/photo/2020/06/30/22/34/dog-5357794__340.jpg",
                    tv_curator_name = "몽그리",
                    tv_curator_keyword = "몽글몽글"
                )
            )
        }
    }


//오늘의 문장 어댑터 연결
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