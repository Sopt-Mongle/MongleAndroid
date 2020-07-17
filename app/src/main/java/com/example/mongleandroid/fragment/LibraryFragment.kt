package com.example.mongleandroid.fragment


import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.NoThemeActivity
import com.example.mongleandroid.activity.SettingActivity
import com.example.mongleandroid.adapter.LibraryPagerAdapter
import com.example.mongleandroid.adapter.LibraryTabAdapter
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.SharedPreferenceController
import com.example.mongleandroid.network.data.response.MainLibrary
import com.example.mongleandroid.network.data.response.ResponseMainLibraryData
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_library.*
import kotlinx.android.synthetic.main.fragment_library.titleLayout
import kotlinx.android.synthetic.main.fragment_library.view.*
import kotlinx.android.synthetic.main.fragment_library_thema.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LibraryFragment : Fragment() {

    val requestToServer = RequestToServer

    lateinit var libraryPagerAdapter: LibraryPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)

    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        requestMyProfile()
//    }

    fun requestMyProfile(){
        requestToServer.service.lookLibraryProfile(
            token = SharedPreferenceController.getAccessToken(view!!.context)
//            token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjM2LCJuYW1lIjoi7ZWY7JiBMiIsImlhdCI6MTU5NDkxMTQzNiwiZXhwIjoxNTk1MDg0MjM2LCJpc3MiOiJtb25nbGUifQ.1QUSDWRk_C3bYxrR95qqD4AJNIKVz5P6EbAIhd58jsU"
        )

            .enqueue(
                object : Callback<ResponseMainLibraryData> {
                    override fun onFailure(call: Call<ResponseMainLibraryData>, t: Throwable) {
                        Log.e("통신 실패", "${t}")
                    }

                    override fun onResponse(
                        call: Call<ResponseMainLibraryData>,
                        response: Response<ResponseMainLibraryData>
                    ) {
                        if (response.isSuccessful) {
                            Log.e("내 서재 프로필 조회 성공", "${response.body()}")

//                            Glide.with(img_library_profile).load(MainLibrary.) = response.body()!!.data[0].img
                            Glide.with(view!!.context).load(response.body()!!.data[0].img).into(img_library_profile)
                            tx_library_username.text = response.body()!!.data[0].name
                            tx_library_contents.text = response.body()!!.data[0].keyword
                            tx_library_keyword.text = response.body()!!.data[0].introduce


                        }
                    }
                }
            )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requestMyProfile()

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

        img_library_setting.setOnClickListener{
            activity?.let {
                val intent = Intent(context, SettingActivity::class.java)
                startActivity(intent)
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

        libraryTabLayout.getTabAt(0)!!.customView = viewFirst
        libraryTabLayout.getTabAt(1)!!.customView = viewSecond
        libraryTabLayout.getTabAt(2)!!.customView = viewThird

        /*libraryTabLayout.getTabAt(0)!!.setText("테마")
        libraryTabLayout.getTabAt(1)!!.setText("문장")
        libraryTabLayout.getTabAt(2)!!.setText("큐레이터")
*/


    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        tx_non_thema.setOnClickListener {
//            val intent = Intent(getActivity(), NoThemeActivity::class.java)
//            startActivity(intent)
////            finish()
//        }
//    }


}


