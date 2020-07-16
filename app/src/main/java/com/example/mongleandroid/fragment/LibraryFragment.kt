package com.example.mongleandroid.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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

        val viewFirst : View = getLayoutInflater().inflate(R.layout.custom_library_tab_basic, null)
        val viewSecond : View = getLayoutInflater().inflate(R.layout.custom_library_tab_basic, null)
        val viewThird : View = getLayoutInflater().inflate(R.layout.custom_library_tab_basic, null)
        val txtUpper1 : TextView = viewFirst.findViewById(R.id.library_tab_num)
        val txtDown1 : TextView = viewFirst.findViewById(R.id.library_tab)
        val txtUpper2 : TextView = viewSecond.findViewById(R.id.library_tab_num)
        val txtDown2 : TextView = viewSecond.findViewById(R.id.library_tab)
        val txtUpper3 : TextView = viewThird.findViewById(R.id.library_tab_num)
        val txtDown3 : TextView = viewThird.findViewById(R.id.library_tab)

        txtUpper1.setText("47")
        txtDown1.setText("테마")

        txtUpper2.setText("36")
        txtDown2.setText("문장")

        txtUpper3.setText("27")
        txtDown3.setText("큐레이터")

        libraryViewPager.setAdapter(adapter)
        libraryTabLayout.setupWithViewPager(libraryViewPager)
        /*libraryTabLayout.getTabAt(0)!!.setText("테마")
        libraryTabLayout.getTabAt(1)!!.setText("문장")
        libraryTabLayout.getTabAt(2)!!.setText("큐레이터")
*/
        libraryTabLayout.getTabAt(0)!!.customView = viewFirst
        libraryTabLayout.getTabAt(1)!!.customView = viewSecond
        libraryTabLayout.getTabAt(2)!!.customView = viewThird




    }


}


