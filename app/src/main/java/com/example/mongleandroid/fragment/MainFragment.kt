package com.example.mongleandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.MainPagerAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vp_main.adapter = MainPagerAdapter(childFragmentManager)
        vp_main.offscreenPageLimit = 2
        tl_main.setupWithViewPager(vp_main)

    }

}