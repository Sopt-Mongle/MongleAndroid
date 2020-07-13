package com.example.mongleandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mongleandroid.fragment.MainViewPager1Fragment
import com.example.mongleandroid.fragment.MainViewPager2Fragment
import com.example.mongleandroid.fragment.MainViewPager3Fragment
import com.example.mongleandroid.fragment.MainViewPager4Fragment

class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT  ) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> MainViewPager1Fragment()
            1 -> MainViewPager2Fragment()
            2 -> MainViewPager3Fragment()
            else -> MainViewPager4Fragment()
        }
    }

    override fun getCount()= 4
}