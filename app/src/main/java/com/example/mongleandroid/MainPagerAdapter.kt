package com.example.mongleandroid

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mongleandroid.fragment.CuratorFragment
import com.example.mongleandroid.fragment.MainFragment
import com.example.mongleandroid.fragment.MypageFragment
import com.example.mongleandroid.fragment.SearchFragment

class MainPagerAdapter(fm:FragmentManager): FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment{
        return when(position){
            0 -> MainFragment()
            1 -> SearchFragment()
            2 -> CuratorFragment()
            else -> MypageFragment()
        }
    }

    override fun getCount() = 4
}