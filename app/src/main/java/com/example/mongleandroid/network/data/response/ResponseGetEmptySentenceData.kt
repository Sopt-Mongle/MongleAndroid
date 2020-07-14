package com.example.mongleandroid.network.data.response

data class ResponseGetEmptySentenceData (
    val staus : Int,
    val success : Boolean,
    val message : String,
    val data : MutableList<EmptySentenceData>
)

data class EmptySentenceData(
    val num : Int, //문장 개수
    val sentences : MutableList<Sentence> // 문장들
)

data class Sentence(
    val sentenceIdx: Int,	//문장 Idx
    val sentence: String,	//문장
    val title: String,	//문장의 책 제목
    val author: String,	//문장의 책 저자
    val publisher: String,	//문장의 책 출판사
    val timestamp: String	//문장이 작성된 시간
)