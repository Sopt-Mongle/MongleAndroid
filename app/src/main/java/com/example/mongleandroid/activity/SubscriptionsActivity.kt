package com.example.mongleandroid.activity

import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.SubscriptionsAdapter
import com.example.mongleandroid.network.data.SubscriptionsData

class SubscriptionsActivity : AppCompatActivity() {

    lateinit var rvCuratorClass: RecyclerView
    lateinit var rvSubscriptionsAdapter: SubscriptionsAdapter
    val datas = mutableListOf<SubscriptionsData>()
    lateinit var btn_subscribe_item: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscriptions)

        initCuratorRecyclerView()

//        btn_subscribe_item = ㅍㅑㄷㅈ.findViewById(R.id.btn_subscribe_item)
//
//        btn_subscribe_item.setOnClickListener{
//            btn_subscribe_item.setText("Hello World")
//        }


    }


    fun initCuratorRecyclerView() {

        rvCuratorClass = findViewById(R.id.rv_curator)
        rvSubscriptionsAdapter = SubscriptionsAdapter(this)
        rvCuratorClass.adapter = rvSubscriptionsAdapter
        rvCuratorClass.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        rvSubscriptionsAdapter.datas = listOf(
            SubscriptionsData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "예슬이",
                item_keyword1 = "몽글피엠",
                item_keyword2 = "귀염둥이",
                item_img_online = R.drawable.curator_state_update_circle
            ),
            SubscriptionsData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "래리",
                item_keyword1 = "회고꾼",
                item_keyword2 = "오늘의 몽글",
                item_img_online = null
            ),
            SubscriptionsData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "봄",
                item_keyword1 = "대학내일",
                item_keyword2 = "몽그리",
                item_img_online = null

            ),
            SubscriptionsData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "홍대",
                item_keyword1 = "디자정인",
                item_keyword2 = "몽글맘",
                item_img_online = R.drawable.curator_state_update_circle

            ),
            SubscriptionsData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "몽그리",
                item_keyword1 = "댕그리",
                item_keyword2 = "그리그리",
                item_img_online = null

            ),
            SubscriptionsData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "몽그리",
                item_keyword1 = "댕그리",
                item_keyword2 = "그리그리",
                item_img_online = null

            ),
            SubscriptionsData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "몽그리",
                item_keyword1 = "댕그리",
                item_keyword2 = "그리그리",
                item_img_online = null

            )
        ).toMutableList()
        rvSubscriptionsAdapter.notifyDataSetChanged()
    }
}
