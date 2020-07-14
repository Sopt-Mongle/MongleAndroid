package com.example.mongleandroid.network.data.request

data class RequestSetEmptySentenceData (
    val themeIdx : Int,	//지정하려는 테마 idx
    val sentenceIdx	: Int, //테마 없는 문장 리스트에서 가져온 문장의 idx
    val sentence : String,	//문장 내용
    val title : String,	//문장이 속한 책 제목
    val author : String, //문장이 속한 책 저자
    val publisher : String	//문장이 속한 책 출판사
)