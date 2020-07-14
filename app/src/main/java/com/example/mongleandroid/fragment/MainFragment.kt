package com.example.mongleandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.MainHotThemeAdapter
import com.example.mongleandroid.adapter.MainNowHotCuratorAdapter
import com.example.mongleandroid.adapter.MainPagerAdapter
import com.example.mongleandroid.adapter.TodaySentenceAdapter
import com.example.mongleandroid.network.data.MainHotThemeData
import com.example.mongleandroid.network.data.MainNowHotCuratorData
import com.example.mongleandroid.network.data.TodaySentenceData
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_main_now_hot_curator.*
import kotlinx.android.synthetic.main.item_main_now_hot_curator.view.*
import kotlinx.android.synthetic.main.item_today_sentence.*

class MainFragment : Fragment() {

    private var data = mutableListOf<TodaySentenceData>()
    private var data2 = mutableListOf<MainNowHotCuratorData>()
    private var data3 = mutableListOf<MainHotThemeData>()

    private lateinit var todaySentenceAdapter: TodaySentenceAdapter
    private lateinit var mainNowHotCuratorAdapter: MainNowHotCuratorAdapter
    private lateinit var mainHotThemeAdapter: MainHotThemeAdapter


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
        vp_main.offscreenPageLimit = 3
        tl_main.setupWithViewPager(vp_main)

        setHotThemeAdapter(data3) // 인기있는 테마 리사이클러뷰
        setHotCuratorAdapter(data2) // 지금 인기있는 큐레이터 리사이클러뷰
        setAdapter(data)//오늘의 문장 리사이클러뷰

    }
    private fun setHotThemeAdapter(mainHotThemeItem: MutableList<MainHotThemeData>) {
        mainHotThemeAdapter =
            MainHotThemeAdapter(
                mainHotThemeItem,
                this.context!!
            )
        themeLoadDatas()
        rv_main_hot_theme.adapter = mainHotThemeAdapter
        rv_main_waiting_for_sentence_theme.adapter = mainHotThemeAdapter
        rv_viewed_a_lot_time_theme.adapter = mainHotThemeAdapter
    }

    private fun themeLoadDatas() {
        data3.apply {
            add(
                MainHotThemeData(
                    tv_main_hot_theme = "브랜딩이 어려울 때",
                    tv_main_hot_theme_count = "38"
                )
            )
            add(
                MainHotThemeData(
                    tv_main_hot_theme = "배고플 때",
                    tv_main_hot_theme_count = "57"
                )
            )
            add(
                MainHotThemeData(
                    tv_main_hot_theme = "생각나는 사람이 있을 때",
                    tv_main_hot_theme_count = "28"
                )
            )
            add(
                MainHotThemeData(
                    tv_main_hot_theme = "졸릴 때",
                    tv_main_hot_theme_count = "90"
                )
            )
            add(
                MainHotThemeData(
                    tv_main_hot_theme = "아무생각 없을 때",
                    tv_main_hot_theme_count = "39"
                )
            )
            mainHotThemeAdapter.datas = data3
            mainHotThemeAdapter.notifyDataSetChanged()
        }
    }

//지금 인기있는 큐레이터 어댑터 연결
    private fun setHotCuratorAdapter(mainNowHotCuratorItem: MutableList<MainNowHotCuratorData>) {
        mainNowHotCuratorAdapter =
            MainNowHotCuratorAdapter(
                mainNowHotCuratorItem,
                this.context!!
            )
        curatorLoadDatas()
        rv_main_now_hot_curator.adapter = mainNowHotCuratorAdapter
    }
    private fun curatorLoadDatas() {
        data2.apply {
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
            mainNowHotCuratorAdapter.datas = data2
            mainNowHotCuratorAdapter.notifyDataSetChanged()
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
                    tv_today_sentence = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔했던 봄을 생각하면 마음이 섬찟"
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
            todaySentenceAdapter.datas = data
            todaySentenceAdapter.notifyDataSetChanged()

        }
    }

}