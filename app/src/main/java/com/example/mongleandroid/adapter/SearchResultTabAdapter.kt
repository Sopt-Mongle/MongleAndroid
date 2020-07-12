package com.example.mongleandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mongleandroid.fragment.ResultCuratorFragment
import com.example.mongleandroid.fragment.ResultSentenceFragment
import com.example.mongleandroid.fragment.ResultThemeFragment

class SearchResultTabAdapter(fm:FragmentManager)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> ResultThemeFragment()
            1 -> ResultSentenceFragment()
            else -> ResultCuratorFragment()
        }
    }

    override fun getCount() = 3
}