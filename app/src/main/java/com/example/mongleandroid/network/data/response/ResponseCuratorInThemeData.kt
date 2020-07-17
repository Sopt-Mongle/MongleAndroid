package com.example.mongleandroid.network.data.response

data class ResponseCuratorInThemeData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : CuratorInTheme?
)

data class CuratorInTheme(
    val theme : List<ThemeList>
)

data class ThemeList(
    val themeIdx : Int, // 해당 테마 인덱스
    val theme : String, //해당 테마 이름
    val themeImgIdx : String, // 해당 테마 이미지 인덱스
    val saves : Int, // 해당 테마 북마크 수
    val writerIdx : Int, // 테마 작성자
    val count : Int, // 해당 테마의 조회수
    val createdAt : String, // 해당 테마가 작성된 시간
    val themeImg : String, // 해당 테마의 이미지
    val sentenceNum : Int, // 해당 테마 안에 있는 문장 개수
    val curatorNum : Int, // 해당 테마에 참여한 큐레이터 수
    val curators : List<CuratorList>
)

data class CuratorList(
    val curatorIdx : Int, // 큐레이터 Idx
    val name : String, // 큐레이터 이름
    val img	: String, // 테마 작성자 프로필사진
    val keyword	: String, // 큐레이터 키워드
    val subscribe : Int, // 해당 큐레이터를 구독하고 있는 수
    val alreadySubscribed : Boolean // 현재 사용자가 이 큐레이터를 구독한 상태(true: 구독함, false: 구독하지 않음)
)