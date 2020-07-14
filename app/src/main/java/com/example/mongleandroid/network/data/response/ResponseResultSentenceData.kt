package com.example.mongleandroid.network.data.response

data class ResponseResultSentenceData (
    // val sentenceIdx : String, // 문장 고유 idx
    val sentence : String, // 문장 내용
    // val themeIdx : String, // 문장이 속한 테마 idx
    val theme : String // 문장이 속한 테마 이름
//    val likes : String, // 문장 좋아요 수
//    val saves : String, // 문장 북마크 수
//    val writer : String, // 문장 만든 사람 이름
//    val writerImg : String, // 문장 만든 사람 프로필 사진
//    val title : String, // 책 제목
//    val author : String, // 책 저자
//    val publisher : String, // 출판사
//    val timestamp : String // 문장이 만들어진 시간
)