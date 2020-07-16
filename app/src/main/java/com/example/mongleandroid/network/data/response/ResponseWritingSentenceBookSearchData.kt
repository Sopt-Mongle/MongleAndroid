package com.example.mongleandroid.network.data.response


data class ResponseWritingSentenceBookSearchData (
val staus : Int,
val success : Boolean,
val message : String,
val data : MutableList<BookData>

)

//data class BookData(
//    val authors : MutableList<String>,	//책 저자 배열
//    val contents : String,	//책 소개
//    val datetime : String,	//책 출간일
//    val isbn : String,	//책 고유 isbn 번호
//    val publisher : String,	//출판사
//    val thumbnail : String,	//책 사진
//    val title : String	//책 제목
//)

data class BookData(
    val authors : MutableList<String>,	//책 저자 배열
//    val authors : String,
    val contents : String,	//책 소개
    val datetime : String,	//책 출간일
    val isbn : String,	//책 고유 isbn 번호
    val publisher : String,	//출판사
    val thumbnail : String,	//책 사진
    val title : String	//책 제목
)
