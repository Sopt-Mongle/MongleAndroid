# :dizzy: 몽글의 갤럭시 :dizzy:

# ☁️사용 라이브러리

- 리사이클러뷰를 다루기 위한 라이브러리`implementation 'androidx.recyclerview:recyclerview:1.1.0'`
- material 디자인 라이브러리`implementation "com.google.android.material:material:1.2.0-alpha05"`
- 이미지 url 로딩 라이브러리`implementation "com.github.bumptech.glide:glide:4.10.0"`
- 동그란 이미지 커스텀 뷰 라이브러리`implementation 'de.hdodenhof:circleimageview:3.1.0'`
- Retrofit 라이브러리 : [https://github.com/square/retrofit](https://github.com/square/retrofit)`implementation 'com.squareup.retrofit2:retrofit:2.6.2'`
- Retrofit 라이브러리 응답으로 가짜 객체를 만들기 위해`implementation 'com.squareup.retrofit2:retrofit-mock:2.6.2'`
- 객체 시리얼라이즈를 위한 Gson 라이브러리 : [https://github.com/google/gson](https://github.com/google/gson)`implementation 'com.google.code.gson:gson:2.8.6'`
- Retrofit 에서 Gson 을 사용하기 위한 라이브러리`implementation 'com.squareup.retrofit2:converter-gson:2.6.2'`
- 추천 키워드 flowlayout`implementation 'com.nex3z:flow-layout:1.2.4'`

# ☁️프로젝트 구조

# ☁️주요 기능 소개

## BottomNavigationView 커스텀

```
<com.google.android.material.bottomnavigation.BottomNavigationView
            android:id="@+id/main_activity_bnv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:itemIconTint="@color/bottom_selector"
            app:itemTextColor="@color/bottom_selector"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:menu="@menu/bottom" /

```

## floatingactionbutton 커스텀

### 기본 플로팅 버튼 (메인 플로팅 버튼)

```
<com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/main_activity_FAB_main"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="20dp"
        android:backgroundTint="@color/softGreen"
        android:src="@drawable/ic_add"
        app:fabSize="normal"
        app:layout_anchor="@+id/main_activity_FL"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:maxImageSize="35dp"
        app:tint="@color/white"
        />

```

### 커스텀한 플로팅 버튼 (눌렀을 때 등장하는 버튼)

```
<com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
        android:id="@+id/main_activity_FAB_st"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/main_activity_FAB_main"
        android:background="@drawable/fab_sub"
        android:backgroundTint="@color/white"
        android:gravity="center"
        android:text="문장 만들기"
        android:textSize="14sp"
        android:visibility="gone"
        app:borderWidth="0dp"
        app:fabSize="mini"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@+id/main_activity_FAB_main" />

    <com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
        android:id="@+id/main_activity_FAB_tm"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/main_activity_FAB_main"
        android:background="@drawable/fab_sub"
        android:backgroundTint="@color/white"
        android:gravity="center"
        android:text="테마 만들기"
        android:textSize="14sp"
        android:visibility="gone"
        app:borderWidth="0dp"
        app:fabSize="mini"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@+id/main_activity_FAB_main" />

```

## floatingactionbutton의 Animation

**update soon**

## BottomNavigationView와 fragment 연동

```
//fragment 처리 객체
    lateinit var mainFragment: MainFragment
    lateinit var searchFragment: SearchFragment
    lateinit var curatorFragment: CuratorFragment
    lateinit var mypageFragment: MypageFragment

//fragment 객체 초기화
        mainFragment = MainFragment()
        searchFragment = SearchFragment()
        curatorFragment = CuratorFragment()
        mypageFragment = MypageFragment()

//메인을 초기 화면으로
        supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, mainFragment).commit()

//bottomNavigationView의 각 아이템아 fragment의 진입점이 되도록 분기
        main_activity_bnv.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.menu_main -> supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, mainFragment).commit()
                R.id.menu_search -> supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, searchFragment).commit()
                R.id.menu_curator -> supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, curatorFragment).commit()
                R.id.menu_mypage -> supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, mypageFragment).commit()
            }
            true
        }

```

## floatingactionbutton과 Activity 연동

**update soon**

## 더 공부하여 적용할 부분

- 워크 플로우에 따라서 fragment와 activity 생명주기 설계하여 적용하기 - mainActivity와 4개의 fragment들, 2개의 activity flow
- 특정 fragment에 진입 했을 때, 시스템이 관여하는 동작을 어떻게 구현할지 설계하여, searchfragment 진입 시에 키보드가 자동으로 올라오게 하기 - mainActivity, searchfragment, xml, manifest
