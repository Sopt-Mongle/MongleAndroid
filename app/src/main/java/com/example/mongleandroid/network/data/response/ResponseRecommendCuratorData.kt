package com.example.mongleandroid.network.data.response

data class ResponseRecommendCuratorData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : List<RecommendCurator>
)

data class RecommendCurator(
    val curatorIdx : Int, // 해당 큐레이터 인덱스
    val name : String, // 해당 큐레이터 이름
    val img : String, // 해당 큐레이터 프로필사진
    val keyword	: String, // 해당 큐레이터 소개 키워드
    val subscribe : String //해당 큐레이터를 구독한 사람 수
)
