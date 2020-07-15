package com.example.mongleandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.custom_library_tab_basic.view.*


class FragmentTab : Fragment() {
    var name = " "
    var num = " "

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.custom_library_tab_basic, container, false)
        view.library_tab_num.text = num
        view.library_tab.text = name

        return view
    }


}