package com.example.mongleandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.CuratorInfoThemaAdapter
import com.example.mongleandroid.network.data.CuratorInfoThemaData
import kotlinx.android.synthetic.main.fragment_curator_info_thema.*


class CuratorInfoThemaFragment : Fragment() {

    lateinit var curatorInfoThemaAdapter: CuratorInfoThemaAdapter
    val curatorInfoThemadatas = mutableListOf<CuratorInfoThemaData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_curator_info_thema, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        curatorInfoThemaAdapter = CuratorInfoThemaAdapter(view.context)
        rv_thema_cu_info.adapter = curatorInfoThemaAdapter
        loadDatas()
    }

    private fun loadDatas() {
        curatorInfoThemadatas.apply {
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 \n" + "기대고만 싶을 때 보면 좋은 문장",
                    thema_num_library_cu_info = "123",
                    sentence_count_library_item_cu_info = "14"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 \n" + "기대고만 싶을 때 보면 좋은 문장",
                    thema_num_library_cu_info = "123",
                    sentence_count_library_item_cu_info = "14"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 \n" + "기대고만 싶을 때 보면 좋은 문장",
                    thema_num_library_cu_info = "123",
                    sentence_count_library_item_cu_info = "14"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 \n" + "기대고만 싶을 때 보면 좋은 문장",
                    thema_num_library_cu_info = "123",
                    sentence_count_library_item_cu_info = "14"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 \n" + "기대고만 싶을 때 보면 좋은 문장",
                    thema_num_library_cu_info = "123",
                    sentence_count_library_item_cu_info = "14"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 \n" + "기대고만 싶을 때 보면 좋은 문장",
                    thema_num_library_cu_info = "123",
                    sentence_count_library_item_cu_info = "14"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 \n" + "기대고만 싶을 때 보면 좋은 문장",
                    thema_num_library_cu_info = "123",
                    sentence_count_library_item_cu_info = "14"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 \n" + "기대고만 싶을 때 보면 좋은 문장",
                    thema_num_library_cu_info = "123",
                    sentence_count_library_item_cu_info = "14"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 \n" + "기대고만 싶을 때 보면 좋은 문장",
                    thema_num_library_cu_info = "123",
                    sentence_count_library_item_cu_info = "14"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 \n" + "기대고만 싶을 때 보면 좋은 문장",
                    thema_num_library_cu_info = "123",
                    sentence_count_library_item_cu_info = "14"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 \n" + "기대고만 싶을 때 보면 좋은 문장",
                    thema_num_library_cu_info = "123",
                    sentence_count_library_item_cu_info = "14"
                )
            )
            add(
                CuratorInfoThemaData(
                    thema_cu_info = "삶에 지쳐 위태롭고 비틀거릴 때, 누군가에게 \n" + "기대고만 싶을 때 보면 좋은 문장",
                    thema_num_library_cu_info = "123",
                    sentence_count_library_item_cu_info = "14"
                )
            )

        }
        curatorInfoThemaAdapter.data_the_cu_info = curatorInfoThemadatas
        curatorInfoThemaAdapter.notifyDataSetChanged()
    }
}