package com.example.mongleandroid.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mongleandroid.R
import com.example.mongleandroid.activity.MainThemeActivity
import kotlinx.android.synthetic.main.fragment_main_view_pager1.*
import kotlinx.android.synthetic.main.fragment_main_view_pager2.*

/**
 * A simple [Fragment] subclass.
 */
class MainViewPager2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_view_pager2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView2.setOnClickListener {
            activity?.let{
                val intent = Intent(context, MainThemeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
