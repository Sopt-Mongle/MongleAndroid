package com.example.mongleandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.CuratorAdapter
import com.example.mongleandroid.network.data.CuratorData

class CuratorActivity : AppCompatActivity() {

    lateinit var rvCuratorClass: RecyclerView
    lateinit var rvCuratorAdapter: CuratorAdapter
    val datas = mutableListOf<CuratorData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curator)

        initCuratorRecyclerView()

    }


    fun initCuratorRecyclerView() {

        rvCuratorClass = findViewById(R.id.rv_curator)
        rvCuratorAdapter = CuratorAdapter(this)
        rvCuratorClass.adapter = rvCuratorAdapter
        rvCuratorClass.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        rvCuratorAdapter.datas = listOf(
            CuratorData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "예슬이",
                item_keyword1 = "몽글피엠",
                item_keyword2 = "귀염둥이",
                item_img_online = R.drawable.curator_state_update_circle
            ),
            CuratorData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "래리",
                item_keyword1 = "회고꾼",
                item_keyword2 = "오늘의 몽글",
                item_img_online = null
            ),
            CuratorData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "봄",
                item_keyword1 = "대학내일",
                item_keyword2 = "몽그리",
                item_img_online = null

            ),
            CuratorData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "홍대",
                item_keyword1 = "디자정인",
                item_keyword2 = "몽글맘",
                item_img_online = R.drawable.curator_state_update_circle

            ),
            CuratorData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "몽그리",
                item_keyword1 = "댕그리",
                item_keyword2 = "그리그리",
                item_img_online = null

            ),
            CuratorData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "몽그리",
                item_keyword1 = "댕그리",
                item_keyword2 = "그리그리",
                item_img_online = null

            ),
            CuratorData(
                img_profile_item = R.drawable.curator_img_ys,
                item_username = "몽그리",
                item_keyword1 = "댕그리",
                item_keyword2 = "그리그리",
                item_img_online = null

            )
        ).toMutableList()
        rvCuratorAdapter.notifyDataSetChanged()
    }
}
