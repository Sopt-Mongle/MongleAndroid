# 몽글

<br><br>

<div align="center" style="display:flex;"><img src="https://user-images.githubusercontent.com/41534832/86881142-c4090700-c128-11ea-85e1-de398680a3a9.png" width="20%"></div>
<div align="center" style="display:flex;"><img src="https://user-images.githubusercontent.com/41534832/86881182-d6834080-c128-11ea-9f99-caa82b7850d0.png" width="30%"></div>

<div align="center">
📚 나를 위한 문장이 모이는 곳, 몽글
</div>

<br><br>

```
📌 책도 가볍게 즐길 수 없을까?

📌 책 속에 담겨있는 짧지만 강렬한 문장들은 우리에게 영감을 주기도 하고, 마음 속 커다란 울림을 주기도 합니다.

📌 몽글은 문장들에 호기심이 많고 감수성이 뛰어난 이들에게 새로운 문장공유 경험을 제공합니다.

📌 우리가 만드는 문장 큐레이션 플랫폼
```

<br>

- - -

<br><br>

## ⚡️ SOPT 26th APPJAM
* 개발 기간 : 2020.06.27 ~ 2020.07.18


## 몽글의 Android Developer

### 조현진 - 몽글 안드부서 부장님 🔥

### 박세란 - 막내 온 탑

### 이소민 - 원자력 발전소

### 최하영 - 개발하는 요리사

<br>

## Main Function
- **메인**
	- 오늘의 문장, 지금 인기있는 큐레이터, 오늘 하루 저장이 많이 된/문장을 기다리는/최근 조회수가 많은 테마 등을 정렬하여 보여줍니다.
	
- **검색**
	- 검색어에 해당하는 테마, 문장, 큐레이터에 대한 정보를 찾을 수 있습니다.
	- 최근 검색어와 추천 검색어를 통해 사용자는 보다 쉽게 원하는 결과를 얻을 수 있습니다.
	
- **작성**
	- 테마 이름과 몽글만의 이미지를 선택하여 테마를 생성할 수 있습니다.
	- 제목으로 책을 검색하여 올리고 싶은 문장에 대한 정보를 빠르게 찾고, 최근에 문장이 들어간 테마들을 확인해 테마를 지정해 문장을 올릴 수 있습니다.
	- 테마를 아직 정하지 못했다면, 테마 없는 나만의 문장으로 저장해두고 나중에 다시 올릴 수 있습니다.

- **큐레이터**
	- 추천 큐레이터 목록에서 활발하게 문장을 올리는 큐레이터를 확인합니다.
	- 테마 속 큐레이터 목록에서 많은 큐레이터들이 참여한 테마와 그 안의 큐레이터들을 확인합니다.
	- 6개의 키워드로 원하는 느낌의 큐레이터를 볼 수 있습니다.
	- 큐레이터 상세보기로 마음에 드는 큐레이터가 쓴 문장과 테마를 볼 수 있고, 구독 또는 구독 취소할 수 있습니다.

- **조회**
	- 테마와 문장을 확인할 수 있습니다.
	- 마음에 드는 테마를 북마크, 마음에 드는 문장을 공감과 북마크해 내 서재에서 볼 수 있습니다.
	- 문장이 속한 테마의 다른 문장을 함께 확인해서 비슷한 느낌의 문장도 읽을 수 있습니다.

- **내 서재**
	- 나의 프로필을 볼 수 있는 내 서재입니다.
	- 내가 북마크하거나 직접 쓴 테마와 문장을 모아 볼 수 있습니다.
	- 내가 구독 중인 큐레이터들을 모아 볼 수 있습니다.
	- 프로필 사진과 소개글, 나를 표현하는 키워드를 바꿀 수 있습니다.

- **유저**
	- 회원가입으로 몽글에 유저가 될 수 있습니다.
	- 로그인으로 몽글에 접속할 수 있습니다.
	- 몽글을 그만두신다면, 회원탈퇴로 내 정보를 지울 수 있습니다.

## 몽글의  Main Function (엑셀 참고해서 인덱싱 & 화면)

### 스플래시

### 로그인

### 회원가입

### 바텀바 - 홈

### 홈 - 테마뷰

### 홈 - 문장뷰

### 바텀바 - 검색

### 바텀바 - 큐레이터

### 바텀바 - 내 서재

### 플로팅 버튼 - 테마 만들기

### 플로팅 버튼 - 문장 쓰기


## 기능 명세 목록 및 구현 여부

# 핵심 기능 구현 방법 소개

## BottomNavigationView + FloatingActionButton를 커스텀한 바텀 바

### BottomNavigationView 커스텀

```jsx
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

### FloatingActionButton 커스텀

- **기본 플로팅 버튼 (메인 플로팅 버튼)**

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

- **커스텀한 플로팅 버튼 (눌렀을 때 등장하는 버튼)**

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

### FloatingActionButton에 Animation 적용

- **fab_open.xml**

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

- **fab_close.xml**

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

- **Animation 적용**

```
fab_open = AnimationUtils.loadAnimation(this, R.anim.fab_open)
fab_close = AnimationUtils.loadAnimation(this, R.anim.fab_close)

```

## FlowLayout을 사용한 추천 검색어 및 최근 검색 뷰

### **검색 뷰 추천 검색어 - FlowLayout**

공간이 충분하지 않을 때 다음 행으로 자동 줄바꿈 될 수 있도록 하는 FlowLayout 사용

- flChildSpacing : 자식 뷰 사이의 가로 간격
- flChildSpacingForLastRow : 마지막 행의 자식 뷰 사이의 가로 간격

![https://user-images.githubusercontent.com/38918396/86778953-f4ec2c00-c095-11ea-97d3-742239182aa9.png](https://user-images.githubusercontent.com/38918396/86778953-f4ec2c00-c095-11ea-97d3-742239182aa9.png)

![https://user-images.githubusercontent.com/38918396/86779026-0c2b1980-c096-11ea-922e-8e81b4403814.png](https://user-images.githubusercontent.com/38918396/86779026-0c2b1980-c096-11ea-922e-8e81b4403814.png)

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

## RecyclerView 아이템 클릭 이벤트 처리

## customTabLayout

내 서재 뷰의 탭이 textView가 위 아래로 두 개가 쌓여있는 형태이다. 

(일반 tabLayout은 textView 하나씩 사용할 수 있다.)

- customTab.xml을 만든다. 원하는 탭의 모양을 뷰로 만든다. 
(해당 앱에서는 textView 2개를 위아래로 배치하였다.)

- LibraryFragment에서 tabLayout에 들어가는 text 채운다.

```
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
```

- viewPager를 각 탭과 연결해준다.

```jsx
libraryViewPager.setAdapter(adapter)
libraryTabLayout.setupWithViewPager(libraryViewPager)

libraryTabLayout.getTabAt(0)!!.customView = viewFirst
libraryTabLayout.getTabAt(1)!!.customView = viewSecond
libraryTabLayout.getTabAt(2)!!.customView = viewThird
```




## stickyHeader

내 서재 뷰의 전체를 스크롤 가능하게 하고, 위로 스크롤 시 customTabLayout이 맨 위로 붙이기

- build.gradle(app)에 라이브러리 추가

```kotlin
//sticky header
implementation 'com.github.amarjain07:StickyScrollView:1.0.2'
```

- build.gradle(MongleAndroid)에 아래 코드 추가

```kotlin
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

- xml 만들기

<NewScrollView>
    <TabLayout/>
    <CustomViewPager/>    
</NewScrollView>

- issue) scroll이 안됨.

ConstraintLayout을 사용할 때 뷰의 크기는 match_parent, wrap_content, 0dp로 크기를 조정하게 되는 데 ScrollView안에 viewPager가 match_parent, wrap_content로 들어가면 제대로 화면을 보여주지 않음.

해결방안) ViewPager를 상속받은 CustomViewPager를 만들어서 배치한다.


- + ) CoordinatorLayout으로 하면 안되는 이유

일반적으로 CoordinatorLayout에서의 고정 방법인 CollapsingToolbar 이용 시 Toolbar의 pin 속성을 이용하여 상단에 고정시키는 방법은 안됨. → 이유는 Toolbar는 자식을 두지 않기 때문이다. 우리는 단순한 Toolbar가 아닌 customTabLayout을 위에 붙여야 함.

## spannable을 사용한 검색 결과 하이라이팅

- Spannable : 텍스트의 '일부'에만 색을 입히거나, 크기를 늘리는 등 효과를 넣을 수 있다.
- span.setSpan(ForegroundColorSpan(글자색), 시작지점, 끝지점, 옵션)

```
val inputString = MainActivity.search_result
val sb = StringBuilder(inputString)
val startWord = sb.get(0)
val endWord = sb.get(sb.lastIndex)
Log.d("index","startWord : ${startWord}, endWord ${endWord}")

val startIndex = responseResultThemeData.theme.indexOf(startWord)
val lastIndex = responseResultThemeData.theme.indexOf(endWord)
Log.d("index","startIndex : ${startIndex}, lastIndex ${lastIndex}")
val spannable = SpannableStringBuilder(responseResultThemeData.theme)

if(inputString.length == lastIndex - startIndex + 1) {
    spannable.setSpan(
        ForegroundColorSpan(Color.rgb(115,192,136)),
        startIndex,
        lastIndex + 1, // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
    )
} 

theme.text = spannable
```

## dialog를 사용한 커스텀 팝업

- Custom Dialog

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c45f0650-0212-42a8-a527-5f8ec22ba682/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c45f0650-0212-42a8-a527-5f8ec22ba682/Untitled.png)

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/191378ad-4046-48bb-83e3-25fa0b341bb5/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/191378ad-4046-48bb-83e3-25fa0b341bb5/Untitled.png)

DialogLogin.kt

```
class DialogLogin(context : Context) {
    private val dlg = Dialog(context)   //부모 액티비티의 context 가 들어감
    private lateinit var login_popup_yes : TextView
    private lateinit var login_popup_join : TextView
    private lateinit var listener : MyDialogOKClickedListener

    fun start(content : String) {
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)   
				//타이틀바 제거
        dlg.setCancelable(false)
				//다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함
        dlg.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
				//다이얼로그 배경색 투명으로 설정
        dlg.setContentView(R.layout.dialog_login)
				//다이얼로그에 사용할 xml 파일을 불러옴

        login_popup_yes = dlg.findViewById(R.id.login_popup_yes)
        login_popup_yes.setOnClickListener {
            dlg.dismiss()
        }

        login_popup_join = dlg.findViewById(R.id.login_popup_join)
        login_popup_join.setOnClickListener {
            val intent = Intent(it.context, JoinActivity::class.java)
            it.context.startActivity(intent)
            dlg.dismiss()
        }
        dlg.show()
    }

    fun setOnOKClickedListener(listener: (String) -> Unit) {
        this.listener = object:
            MyDialogOKClickedListener {
            override fun onOKClicked(content: String) {
                listener(content)
            }
        }
    }

    interface MyDialogOKClickedListener {
        fun onOKClicked(content : String)
    }

}
```

## 확장함수 소개

1. 키보드 제어 함수

    ```
    fun EditText.showKeyboard() {
        if (requestFocus()) {
            // edittext에 초점이 맞춰지면 키보드 올라옴
            (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
            setSelection(text.length)
        }
    }

    fun EditText.unshowKeyboard() {
        if (requestFocus()) {
            // edittext에 초점이 맞춰지면 키보드 올라옴
            (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .hideSoftInputFromWindow(this.windowToken, 0)
            setSelection(text.length)
        }
    }
    ```

2. 한 액티비티에서 레이아웃, 뷰 전환 함수

    ```
    fun goNextView(current : View, next : View){
        current.visibility = View.GONE
        next.visibility = View.VISIBLE
    }
    fun goPrevView(current: View, prev : View) {
        current.visibility = View.GONE
        prev.visibility = View.VISIBLE
    }
    fun goNextPage(current : ConstraintLayout, next : ConstraintLayout){
        current.visibility = View.GONE
        next.visibility = View.VISIBLE
    }
    fun goPrevPage(current: ConstraintLayout, prev : ConstraintLayout){
        current.visibility = View.GONE
        prev.visibility = View.VISIBLE
    }

    ```

3. request를 보내고 response를 받아오는 통신 함수

    ```
    fun<ResponseType> Call<ResponseType>.customEnqueue(
        onFail : () -> Unit = { Log.d("network", "통신에 실패했습니다.")},
        onSuccess : (ResponseType) -> Unit,
        onError : () -> Unit
    ){
        this.enqueue(object : Callback<ResponseType> {
            override fun onFailure(call: Call<ResponseType>, t: Throwable) {
                onFail()
            }

            override fun onResponse(call: Call<ResponseType>, response: Response<ResponseType>) {
                //body 가 존재한다면, statusCode가 200-300 사이이다.
                //let 함수는 해당 reponse 객체를 it으로 사용하게 함
                response.body()?.let{
                    onSuccess(it) //통신 결과를 전달해줌

                } ?: onError() 

            }

        })
    }
    ```

# 프로젝트 구조

## 사용 라이브러리

- 리사이클러뷰를 다루기 위한 라이브러리 `implementation 'androidx.recyclerview:recyclerview:1.1.0'`
- material 디자인 라이브러리 `implementation "com.google.android.material:material:1.2.0-alpha05"`
- 이미지 url 로딩 라이브러리 `implementation "com.github.bumptech.glide:glide:4.10.0"`
- 동그란 이미지 커스텀 뷰 라이브러리 `implementation 'de.hdodenhof:circleimageview:3.1.0'`
- Retrofit 라이브러리 `implementation 'com.squareup.retrofit2:retrofit:2.6.2'`
- Retrofit 라이브러리 응답으로 가짜 객체를 만들기 위해 `implementation 'com.squareup.retrofit2:retrofit-mock:2.6.2'`
- 객체 시리얼라이즈를 위한 Gson 라이브러리 `implementation 'com.google.code.gson:gson:2.8.6'`
- Retrofit 에서 Gson 을 사용하기 위한 라이브러리 `implementation 'com.squareup.retrofit2:converter-gson:2.6.2'`
- 추천 키워드 flowlayout `implementation 'com.nex3z:flow-layout:1.2.4'`

## 디렉토리 설명

activity

adapter

fragment

network

util

확장함수들

![image](https://user-images.githubusercontent.com/59532818/87843608-eb15c480-c8f0-11ea-9d1e-af7d2ac587a6.png)

## Git&GitHub Branch 전략

### master

develop 으로부터 PR만 진행하는 안전한 최종 작업물 

### develop

feature과 교류하며, 이어가는 작업물

### feature/#cnt

issue를 기준으로 생성한 브랜치 

### issue

역할 분담에 따라, 작업을 쪼개서 정의한 것

- branch 이름
- issue 제목 정하기
