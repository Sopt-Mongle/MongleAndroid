package com.example.mongleandroid.network

import com.example.mongleandroid.network.data.request.*
import com.example.mongleandroid.network.data.response.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


// 행동 (post, get ...) 과 어떤 서버 (uri)에 대한 정의
interface RequestInterface {
    //post 통신 할 때, 어떤 서버에게 요청할 지 명시
    //서버의 주소를 넣어 해당 서버와 post 방식의 통신을 하겠다

    //요청 처리를 할 때, 어떤 객제를 넘겨줄 지 명시
    //해당 함수가 호출될 때, 요청 처리가 됨
    //반드시 레트포핏에 해당하는 call을 임포트 해야한다. call은 해당 함수의 반환 값임
    //즉 request를 인자값으로 넣어서 response를 리턴값으로 받는 함수를 정의한다.


    //테마 만들기
    @POST("/post/theme")
    fun RequestWritingTheme(@Body body: RequestWritingThemeData) : Call<ResponseWritingThemeData>

    //문장 올리기
    @POST("/post/sentence")
    fun RequestWritingSentence(@Body body: RequestWritingSentenceData) : Call<ResponseWritingSentenceData>

    //제목으로 책 검색
    @GET("/post/bookSearch")
    fun RequestWritingSentenceBookSearch(@Body body: RequestWritingSentenceBookSearchData) :Call<ResponseWritingSentenceBookSearchData>

    //선택할 테마 목록 조회
    @GET("/post/theme")
    fun RequestWritingSentenceThemeSearch(@Body body: RequestWritingSentenceThemeSearchData) :Call<ResponseWritingSentenceThemeSearchData>

    //테마 없는 문장 목록 조회
    @GET("/post/getEmptySentence")
    fun RequestGetEmptySentence(@Body body : RequestGetEmptySentenceData) : Call<ResponseGetEmptySentenceData>

    //테마 없는 문장 테마 지정하기
    @GET("/post/setTheme")
    fun RequestSetEmptySentence(@Body body: RequestSetEmptySentenceData) : Call<ResponseSetEmptySentenceData>



}