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
                img_profile_item = R.drawable.ic_launcher_foreground,
                item_username = "소민이",
                item_contents = "안녕 나는 뿌까라고 해 만나서 반가워 나는 웃는 게 예쁜 사람이야",
                item_img_online = R.drawable.ic_launcher_foreground,
                btn_subscribe_item = R.drawable.ic_launcher_foreground,
                hashtag_curator = R.drawable.ic_launcher_foreground,
                hashtag2_curator = R.drawable.ic_launcher_foreground

            ),
            CuratorData(
                img_profile_item = R.drawable.ic_launcher_foreground,
                item_username = "소민이",
                item_contents = "안녕 나는 뿌까라고 해 만나서 반가워 나는 웃는 게 예쁜 사람이야",
                item_img_online = R.drawable.ic_launcher_foreground,
                btn_subscribe_item = R.drawable.ic_launcher_foreground,
                hashtag_curator = R.drawable.ic_launcher_foreground,
                hashtag2_curator = R.drawable.ic_launcher_foreground

            ),
            CuratorData(
                img_profile_item = R.drawable.ic_launcher_foreground,
                item_username = "소민이",
                item_contents = "안녕 나는 뿌까라고 해 만나서 반가워 나는 웃는 게 예쁜 사람이야",
                item_img_online = R.drawable.ic_launcher_foreground,
                btn_subscribe_item = R.drawable.ic_launcher_foreground,
                hashtag_curator = R.drawable.ic_launcher_foreground,
                hashtag2_curator = R.drawable.ic_launcher_foreground

            ),
            CuratorData(
                img_profile_item = R.drawable.ic_launcher_foreground,
                item_username = "소민이",
                item_contents = "안녕 나는 뿌까라고 해 만나서 반가워 나는 웃는 게 예쁜 사람이야",
                item_img_online = R.drawable.ic_launcher_foreground,
                btn_subscribe_item = R.drawable.ic_launcher_foreground,
                hashtag_curator = R.drawable.ic_launcher_foreground,
                hashtag2_curator = R.drawable.ic_launcher_foreground

            ),
            CuratorData(
                img_profile_item = R.drawable.ic_launcher_foreground,
                item_username = "소민이",
                item_contents = "안녕 나는 뿌까라고 해 만나서 반가워 나는 웃는 게 예쁜 사람이야",
                item_img_online = R.drawable.ic_launcher_foreground,
                btn_subscribe_item = R.drawable.ic_launcher_foreground,
                hashtag_curator = R.drawable.ic_launcher_foreground,
                hashtag2_curator = R.drawable.ic_launcher_foreground

            )
        ).toMutableList()
        rvCuratorAdapter.notifyDataSetChanged()
    }
}

