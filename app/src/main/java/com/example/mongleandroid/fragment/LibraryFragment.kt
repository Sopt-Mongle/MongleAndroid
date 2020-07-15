package com.example.mongleandroid.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.LibraryTabAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_library.*


class LibraryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //sticky header
        main_scroll_view.run {
            header = titleLayout
            stickListener = { _ ->
                Log.d("LOGGER_TAG", "stickListener")
            }
            freeListener = { _ ->
                Log.d("LOGGER_TAG", "freeListener")
            }
        }

        val libraryTabLayout = view.findViewById(R.id.titleLayout) as TabLayout
        val libraryViewPager = view.findViewById(R.id.vp_library) as ViewPager
        val adapter = LibraryTabAdapter(childFragmentManager)
        libraryViewPager.setAdapter(adapter)
        libraryTabLayout.setupWithViewPager(libraryViewPager)
        libraryTabLayout.getTabAt(0)!!.setText("테마")
        libraryTabLayout.getTabAt(1)!!.setText("문장")
        libraryTabLayout.getTabAt(2)!!.setText("큐레이터")


    }


}


