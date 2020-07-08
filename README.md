# :dizzy: 몽글의 갤럭시 :dizzy:

# ☁️사용 라이브러리

- 리사이클러뷰를 다루기 위한 라이브러리 `implementation 'androidx.recyclerview:recyclerview:1.1.0'`
- material 디자인 라이브러리 `implementation "com.google.android.material:material:1.2.0-alpha05"`
- 이미지 url 로딩 라이브러리 `implementation "com.github.bumptech.glide:glide:4.10.0"`
- 동그란 이미지 커스텀 뷰 라이브러리 `implementation 'de.hdodenhof:circleimageview:3.1.0'`
- Retrofit 라이브러리 `implementation 'com.squareup.retrofit2:retrofit:2.6.2'`
- Retrofit 라이브러리 응답으로 가짜 객체를 만들기 위해 `implementation 'com.squareup.retrofit2:retrofit-mock:2.6.2'`
- 객체 시리얼라이즈를 위한 Gson 라이브러리 `implementation 'com.google.code.gson:gson:2.8.6'`
- Retrofit 에서 Gson 을 사용하기 위한 라이브러리 `implementation 'com.squareup.retrofit2:converter-gson:2.6.2'`
- 추천 키워드 flowlayout `implementation 'com.nex3z:flow-layout:1.2.4'`
<br>

# ☁️프로젝트 구조
**update soon**
<br>

# ☁️주요 기능 소개

## :bulb: BottomNavigationView 커스텀

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

## :bulb: FloatingActionButton 커스텀

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

## :bulb: FloatingActionButton에 Animation 적용
**fab_open.xml**
```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:fillAfter="true">
    <scale
        android:duration="300"
        android:fromXScale="0.0"
        android:fromYScale="0.0"
        android:interpolator="@android:anim/linear_interpolator"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="0.8"
        android:toYScale="0.8" />
    <alpha
        android:duration="300"
        android:fromAlpha="0.0"
        android:interpolator="@android:anim/accelerate_interpolator"
        android:toAlpha="1.0" />
</set>
```
**fab_close.xml**
```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:fillAfter="true">
    <scale
        android:duration="300"
        android:fromXScale="0.8"
        android:fromYScale="0.8"
        android:interpolator="@android:anim/linear_interpolator"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="0.0"
        android:toYScale="0.0" />
    <alpha
        android:duration="300"
        android:fromAlpha="1.0"
        android:interpolator="@android:anim/accelerate_interpolator"
        android:toAlpha="0.0" />
</set>
```
**Animation 적용**
```
fab_open = AnimationUtils.loadAnimation(this, R.anim.fab_open)
fab_close = AnimationUtils.loadAnimation(this, R.anim.fab_close)
```
## :bulb: BottomNavigationView와 fragment 연동

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

## :bulb: FloatingActionButton과 Activity 연동

**update soon**

## 더 공부하여 적용할 부분

- 워크 플로우에 따라서 fragment와 activity 생명주기 설계하여 적용하기 - mainActivity와 4개의 fragment들, 2개의 activity flow
- 특정 fragment에 진입 했을 때, 시스템이 관여하는 동작을 어떻게 구현할지 설계하여, searchfragment 진입 시에 키보드가 자동으로 올라오게 하기 - mainActivity, searchfragment, xml, manifest

## :bulb: 검색 뷰(SearchFragment) 레이아웃 - ConstraintLayout 사용
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/ConstraintLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".fragment.SearchFragment">
...
</androidx.constraintlayout.widget.ConstraintLayout>
```

## :bulb: 검색 뷰 - Edittext에 초점 맞추기, 키보드 자동으로 올라오게 구현
키보드를 제어할 때는 InputMethodManager를 이용한다.  
- showSoftInput(View view, int flags): 키보드 보임
- hideSoftInputFromWindow(IBinder windowToken, int flags): 키보드 숨김

주의할 점은 showSoftInput() 함수의 첫 번째 매개변수로 글이 입력될 뷰를 지칭하는데, 입력 대상이 되는 뷰에 포커스가 없는 상태라면 키보드가 나타나지 않는다.
따라서 requestFocus() 함수를 이용하여 Edittext에 포커스를 요청한 후 showSoftInput() 함수로 키보드가 나타나게 구현한다.

**fragment_search.xml - Edittext(검색창)에서 <requestFocus /> 코드 추가**
```
<EditText
        android:id="@+id/search_fragment_et_search"
        ...
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toEndOf="@+id/search_fragment_btn_back"
        app:layout_constraintTop_toTopOf="parent" >
        <requestFocus />
    </EditText>
```

**SearchFragment.kt**
```
search_fragment_et_search.requestFocus() // Edittext에 초점 맞추는 부분
search_fragment_et_search.showKeyboard() // keyboard 올라오는 부분
```

**showKeyboard() 확장 함수**  
ShowKeyboard.kt
```
fun EditText.showKeyboard() {
    if (requestFocus()) {
        // edittext에 초점이 맞춰지면 키보드 올라옴
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
        setSelection(text.length)
    }
}
```

## :bulb: 검색 뷰 최근 검색어 - RecyclerView
- 가로 양 쪽으로 패딩값을 준 뒤 clipToPadding="false" 라는 속성값을 이용하여 패딩공간을 스크롤 영역으로 활용
- 검색어를 입력하는 경우 가장 최근 검색어를 맨 앞에 배치하기 위해 stackFromEnd="true"와 reverseLayout="true" 옵션을 사용하여 리사이클러뷰를 역순으로 출력
```
<androidx.recyclerview.widget.RecyclerView
    android:id="@+id/rv_recent_keyword"
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_marginTop="15dp"
    android:clipToPadding="false"
    android:orientation="horizontal"
    android:paddingLeft="15dp"
    android:paddingEnd="7dp"
    app:stackFromEnd="true"
    app:reverseLayout="true"
    app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintHorizontal_bias="0.0"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@+id/textView6"
    tools:listitem="@layout/item_recent_keyword" />
```

## :bulb: 검색 뷰 추천 검색어 - FlowLayout
공간이 충분하지 않을 때 다음 행으로 자동 줄바꿈 될 수 있도록 하는 FlowLayout 사용  
- flChildSpacing : 자식 뷰 사이의 가로 간격
- flChildSpacingForLastRow : 마지막 행의 자식 뷰 사이의 가로 간격

![image](https://user-images.githubusercontent.com/38918396/86778953-f4ec2c00-c095-11ea-97d3-742239182aa9.png) ![image](https://user-images.githubusercontent.com/38918396/86779026-0c2b1980-c096-11ea-922e-8e81b4403814.png)
```
<com.nex3z.flowlayout.FlowLayout
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="15dp"
        app:flChildSpacing="8dp"
        app:flChildSpacingForLastRow="align"
        app:layout_constraintEnd_toEndOf="@+id/search_fragment_et_search"
        app:layout_constraintStart_toStartOf="@+id/textView7"
        app:layout_constraintTop_toBottomOf="@+id/textView7">

        <TextView
            android:id="@+id/tv_recommend_keyword1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@drawable/search_recommend_keyword"
            android:letterSpacing="-0.02"
            android:lineSpacingExtra="8sp"
            android:text="TextView"
            android:textColor="#69af7c"
            android:textSize="16sp" />
...
    </com.nex3z.flowlayout.FlowLayout>
```

## 💡 MainFragment

## ScrollView

```
<androidx.core.widget.NestedScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

</androidx.core.widget.NestedScrollView>
```

## ViewPager & TabLayout

```
<androidx.viewpager.widget.ViewPager
                android:id="@+id/vp_main"
                android:layout_width="match_parent"
                android:layout_height="300dp"
                android:layout_marginTop="28dp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/img_main_mongle_logo">

            </androidx.viewpager.widget.ViewPager>
```

- Activity에서 ViewPager를 사용할 때는 supportFragmentManager를 사용했었다. 하지만 Fragment에서는 supportFragmentManager를 사용할 수 없다.
- Fragment에서는 supportFragmentManager가 아닌 childFragmentManager를 사용해야 한다.

```
vp_main.adapter = MainPagerAdapter(childFragmentManager)
vp_main.offscreenPageLimit = 2
tl_main.setupWithViewPager(vp_main)
```

```
<com.google.android.material.tabs.TabLayout
                android:id="@+id/tl_main"
                android:layout_width="wrap_content"
                android:layout_height="0dp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/vp_main"
                app:tabBackground="@drawable/dot_selector"
                app:tabIndicatorHeight="0dp">

            </com.google.android.material.tabs.TabLayout>
```

## MainPagerAdapter

```
class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT  ) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> MainViewPager1Fragment()
            1 -> MainViewPager2Fragment()
            else -> MainViewPager3Fragment()
        }
    }

    override fun getCount()= 3
}
```
## :bulb: **큐레이터 뷰**

해당 뷰는 사용자가 구독 중인 큐레이터의 목록을 나타내는 뷰이다.

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3d7c3d63-0835-441e-b763-731943f429e3/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3d7c3d63-0835-441e-b763-731943f429e3/Untitled.png)

#CuratorView 만들기

ConstraintLayout으로 View를 만들었다.

<constraintLayout

<TextView

<ImageButton

<RecyclerView

/>

#recyclerView 만들기

-item 만들기

ConstraintLayout을 이용하여 RecyclerView에 들어갈 아이템을 만들었다.

- <CircleImageView>를 이용하여 프로필 사진을 동그란 이미지로 넣을 수 있도록 하였다.
- "예스리", "대학내일", "인생회고"는 TextView로 만들었고, 프로필 옆의 업데이트 표시 이미지와 "|"는 ImageView로 만들었다.
- 구독 버튼은 selector를 이용하여 둥근 버튼으로 만들고, checked를 이용하여 구독, 구독 중의 버튼을 나타내었다.
- item의 background도 shape를 이용하여 radius와 색상을 지정해줬다. (임의로 현재 색 구분을 위해 다른 색으로 해놨다.)

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/dbcafe42-0e71-42ef-b904-13e136d3c9cd/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/dbcafe42-0e71-42ef-b904-13e136d3c9cd/Untitled.png)

-data 

RecyclerView에 들어가는 Data의 파일을 생성하였다.

```
data class CuratorData(
    val img_profile_item: Int,
    val item_username: String,
    val item_keyword1: String,
    val item_keyword2: String,
    val item_img_online: Int?
)
```

-adapter

임의로 더미데이터를 넣었다.

```
CuratorData(
    img_profile_item = R.drawable.curator_img_ys,
    item_username = "예슬이",
    item_keyword1 = "몽글피엠",
    item_keyword2 = "귀염둥이",
    item_img_online = R.drawable.curator_state_update_circle
)
```
