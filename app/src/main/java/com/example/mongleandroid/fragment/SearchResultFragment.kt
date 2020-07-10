package com.example.mongleandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.MainActivity.Companion.search_result
import com.example.mongleandroid.adapter.SearchResultTabAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_search_result.*


class SearchResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 검색어 받아오는 부분
        result_fragment_et_search.setText(search_result)

        // tablayout 배치
        val ResultTabLayout = view!!.findViewById(R.id.search_result_tab) as TabLayout
        val ResultViewPager = view!!.findViewById(R.id.search_result_viewpager) as ViewPager
        val adapter = SearchResultTabAdapter(childFragmentManager)
        ResultViewPager.setAdapter(adapter)
        ResultTabLayout.setupWithViewPager(ResultViewPager)
        ResultTabLayout.getTabAt(0)!!.setText("테마")
        ResultTabLayout.getTabAt(1)!!.setText("문장")
        ResultTabLayout.getTabAt(2)!!.setText("큐레이터")

        result_fragment_btn_back.setOnClickListener {
            val transaction = getFragmentManager()?.beginTransaction()
            transaction?.replace(R.id.search_result_fragment_cl, SearchFragment())
            transaction?.commit()
            search_result_cl_tab.visibility = GONE
            // 일단은 ..
        }

    }

}