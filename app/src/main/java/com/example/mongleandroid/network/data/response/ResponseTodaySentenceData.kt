package com.example.mongleandroid.network.data.response

data class ResponseTodaySentenceData(
    val sentenceIdx: Int, // 문장 idx
    val sentence: String, // 문장
    val title: String, // 문장의 책 제목
    val alreadyBookmarked: Boolean // 현재 사용자가 해당 문장을 저장했는지(true: 저장함, false: 저장안함)
)