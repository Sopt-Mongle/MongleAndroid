package com.example.mongleandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.LibraryCuratorAdapter
import com.example.mongleandroid.network.data.LibraryCuratorData
import kotlinx.android.synthetic.main.fragment_library_curator.*

class LibraryCuratorFragment : Fragment() {

    lateinit var libraryCuratorAdapter: LibraryCuratorAdapter
    val libraryCuratorData = mutableListOf<LibraryCuratorData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library_curator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        libraryCuratorAdapter = LibraryCuratorAdapter(view.context)
        rv_library_curator.adapter = libraryCuratorAdapter
        loadDatas()
    }

    private fun loadDatas() {
        libraryCuratorData.apply {
            add(
                LibraryCuratorData(
                    library_curator_img_profile = "https://cdn.pixabay.com/photo/2020/07/13/15/22/squirrel-5401095__480.jpg",
                    tv_library_curator_name = "예스리",
                    tv_library_curator_subcount = "15",
                    tv_library_curator_keyword = "피엠예슬"
                )
            )
            add(
                LibraryCuratorData(
                    library_curator_img_profile = null,
                    tv_library_curator_name = "예스리",
                    tv_library_curator_subcount = "15",
                    tv_library_curator_keyword = "피엠예슬"
                )
            )
            add(
                LibraryCuratorData(
                    library_curator_img_profile = null,
                    tv_library_curator_name = "예스리",
                    tv_library_curator_subcount = "15",
                    tv_library_curator_keyword = "피엠예슬"
                )
            )
            add(
                LibraryCuratorData(
                    library_curator_img_profile = null,
                    tv_library_curator_name = "예스리",
                    tv_library_curator_subcount = "15",
                    tv_library_curator_keyword = "피엠예슬"
                )
            )
            add(
                LibraryCuratorData(
                    library_curator_img_profile = null,
                    tv_library_curator_name = "예스리",
                    tv_library_curator_subcount = "15",
                    tv_library_curator_keyword = "피엠예슬"
                )
            )


        }
        libraryCuratorAdapter.data_cu = libraryCuratorData
        libraryCuratorAdapter.notifyDataSetChanged()
    }


}
