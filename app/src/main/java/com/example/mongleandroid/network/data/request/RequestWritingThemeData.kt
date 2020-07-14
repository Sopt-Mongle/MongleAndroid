package com.example.mongleandroid.network.data.request

data class RequestWritingThemeData (
    val theme: String,	//생성할 테마 이름
    val themeImgIdx: Int, //생성할 테마의 배경 사진
    val curatorIdx: Int	//테마 작성자 Idx
)