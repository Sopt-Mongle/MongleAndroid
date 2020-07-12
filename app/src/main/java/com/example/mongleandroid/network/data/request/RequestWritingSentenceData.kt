package com.example.mongleandroid.network.data.request

data class RequestWritingSentenceData (
    val curatorIdx : Int, //현재 사용자 idx
    val sentence :	String,	//작성할 문장
    val title :	String,	//작성할 문장이 속한 책 제목
    val author :String,	//작성할 문장이 속한 책의 저자
    val publisher :	String //작성할 문장이 속한 책 출판사
)