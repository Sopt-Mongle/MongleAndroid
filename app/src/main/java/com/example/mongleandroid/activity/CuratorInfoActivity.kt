package com.example.mongleandroid.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.CuratorInfoPagerAdapter
import com.example.mongleandroid.network.data.CuratorInfoThemaData
import kotlinx.android.synthetic.main.activity_curator_info.*

class CuratorInfoActivity : AppCompatActivity() {

    private var data = mutableListOf<CuratorInfoThemaData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curator_info)

        vp_curator_info.adapter = CuratorInfoPagerAdapter(supportFragmentManager)
        vp_curator_info.offscreenPageLimit = 1

        loadDatas()

        //sticky header
        main_scroll_view_cura_info.run {
            header = cl_titleLayout
            stickListener = { _ ->
                Log.d("LOGGER_TAG", "stickListener")
            }
            freeListener = { _ ->
                Log.d("LOGGER_TAG", "freeListener")
            }
        }


        cb_curator_subs_info.setOnClickListener {
            if (cb_curator_subs_info.isChecked) {
                cb_curator_subs_info.setText("구독중")
            } else cb_curator_subs_info.setText("구독")

        }



        tv_thema_num_cu_info.setOnClickListener {
            tv_thema_num_cu_info.setTextColor(Color.parseColor("#73c088"))
            tv_thema_cu_info.setTextColor(Color.parseColor("#73c088"))
            tv_sentence_num_cu_info.setTextColor(Color.parseColor("#bcbcbc"))
            tv_sentence_cu_info.setTextColor(Color.parseColor("#bcbcbc"))

            //버튼 클릭 시 페이지 넘김
            var current = vp_curator_info.currentItem
            current = 0
            if (current == 0){
                vp_curator_info.setCurrentItem(0, false)

            }
            else{
//                vp_curator_info.setCurrentItem(current-1, false)

            }

        }

        tv_thema_cu_info.setOnClickListener {
            tv_thema_num_cu_info.setTextColor(Color.parseColor("#73c088"))
            tv_thema_cu_info.setTextColor(Color.parseColor("#73c088"))
            tv_sentence_num_cu_info.setTextColor(Color.parseColor("#bcbcbc"))
            tv_sentence_cu_info.setTextColor(Color.parseColor("#bcbcbc"))

            //버튼 클릭 시 페이지 넘김
            var current = vp_curator_info.currentItem
            current = 0
            if (current == 0){
                vp_curator_info.setCurrentItem(0, false)
            }
            else{
//                vp_curator_info.setCurrentItem(current-1, false)

            }

        }

        tv_sentence_num_cu_info.setOnClickListener {
            tv_sentence_num_cu_info.setTextColor(Color.parseColor("#73c088"))
            tv_sentence_cu_info.setTextColor(Color.parseColor("#73c088"))
            tv_thema_num_cu_info.setTextColor(Color.parseColor("#bcbcbc"))
            tv_thema_cu_info.setTextColor(Color.parseColor("#bcbcbc"))

            //버튼 클릭 시 페이지 넘김
            var current = vp_curator_info.currentItem
            current = 10
            if (current == 10){
                vp_curator_info.setCurrentItem(current-1, false)
            }
            else{
//                vp_curator_info.setCurrentItem(current-1, false)

            }

        }

        tv_sentence_cu_info.setOnClickListener {
            tv_sentence_num_cu_info.setTextColor(Color.parseColor("#73c088"))
            tv_sentence_cu_info.setTextColor(Color.parseColor("#73c088"))
            tv_thema_num_cu_info.setTextColor(Color.parseColor("#bcbcbc"))
            tv_thema_cu_info.setTextColor(Color.parseColor("#bcbcbc"))

            //버튼 클릭 시 페이지 넘김
            var current = vp_curator_info.currentItem
            current = 10
            if (current == 10){
                vp_curator_info.setCurrentItem(current-1, false)
            }
            else{
//                vp_curator_info.setCurrentItem(current-1, false)

            }

        }

    }

    private fun loadDatas() {
        data.apply {
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "번아웃을 극복하기 위해 봐야하는 문장",
                    thema_num_library_cu_info = "107",
                    sentence_count_library_item_cu_info = "15"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "결국 봄이 언제나 찾아왔지만, 하마터면 오지 않을 뻔했던 봄을 생각하면 마음이 섬찟해지는 문장",
                    thema_num_library_cu_info = "107",
                    sentence_count_library_item_cu_info = "15"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "개발이 잘 안될 때 심신안정을 위해 봐야하는 문장",
                    thema_num_library_cu_info = "509",
                    sentence_count_library_item_cu_info = "15"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "번아웃을 극복하기 위해 봐야하는 문장",
                    thema_num_library_cu_info = "107",
                    sentence_count_library_item_cu_info = "15"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "번아웃을 극복하기 위해 봐야하는 문장",
                    thema_num_library_cu_info = "107",
                    sentence_count_library_item_cu_info = "15"
                )
            )
        }
    }

}