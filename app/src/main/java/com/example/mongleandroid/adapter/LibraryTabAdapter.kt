package com.example.mongleandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mongleandroid.fragment.LibraryCuratorFragment
import com.example.mongleandroid.fragment.LibrarySentenceFragment
import com.example.mongleandroid.fragment.LibraryThemaFragment

class LibraryTabAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> LibraryThemaFragment()
            1 -> LibrarySentenceFragment()
            else -> LibraryCuratorFragment()
        }
    }

    override fun getCount() = 3
}