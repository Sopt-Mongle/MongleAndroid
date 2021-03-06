package com.example.mongleandroid.network

import com.example.mongleandroid.network.data.request.*
import com.example.mongleandroid.network.data.response.*
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.Query as Retrofit2HttpQuery



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
    fun RequestWritingTheme(
        @Header ("token") token:String?,
        @Body body: RequestWritingThemeData) : Call<ResponseWritingThemeData>

    //문장 올리기
    @POST("/post/sentence")
    fun RequestWritingSentence(
        @Header ("token") token: String?,
        @Body body: RequestWritingSentenceData) : Call<ResponseWritingSentenceData>

    //제목으로 책 검색
    @GET("/post/bookSearch")
    fun RequestWritingSentenceBookSearch(
        @Retrofit2HttpQuery("query") title: String
    ) :Call<ResponseWritingSentenceBookSearchData>

    //선택할 테마 목록 조회
    @GET("/post/theme")
    fun RequestWritingSentenceThemeSearch() :Call<ResponseWritingSentenceThemeSearchData>

    //테마 이미지 조회
    @GET("/post/themeImg")
    fun GetPostThemeImg() : Call<ResponseThemeImgData>

    //테마 없는 문장 목록 조회
    @GET("/post/getEmptySentence")
    fun RequestGetEmptySentence(@Body body : RequestGetEmptySentenceData) : Call<ResponseGetEmptySentenceData>

    //테마 없는 문장 테마 지정하기
    @GET("/post/setTheme")
    fun RequestSetEmptySentence(@Body body: RequestSetEmptySentenceData) : Call<ResponseSetEmptySentenceData>

    // 검색 - 최근 키워드 - 성공
    @GET("/search/recent")
    fun requestSearchRecentData(
        @Header("token") token: String?
    ) : Call<ResponseSearchRecentData>

    // 검색 - 최근 키워드 전체 삭제 - 성공
    @DELETE("/search/recent")
    fun requestSearchRecentDeleteRecent(
        @Header("token") token: String?
    ) : Call<ResponseSearchRecentDeleteData>

    // 검색 - 추천 키워드 - 성공
    @GET("/search/recommend")
    fun getRecommendKeyword() : Call<ResponseRecommendKeywordData>

    // 테마 검색 - 성공
    @GET("/search/theme")
    fun requestResultThemeData(
        @Header("token") token: String?,
        @Retrofit2HttpQuery("words") words: String
    ) : Call<ResponseResultThemeData>

    // 문장 검색 - 성공
    @GET("/search/sentence")
    fun requestResultSentenceData(
        @Retrofit2HttpQuery("words") words: String
    ) : Call<ResponseResultSentenceData>

    // 큐레이터 검색 - 성공
    @GET("/search/curator")
    fun requestResultCuratorData(
        @Header("token") token: String?,
        @Retrofit2HttpQuery("words") words: String
    ) : Call<ResponseResultCuratorData>

    // 로그인 - 성공
    @POST("/users/signin")
    fun RequestLoginData(@Body body: RequestLoginData) : Call<ResponseLoginData>

    // 회원가입 - 성공
    @POST("/users/signup")
    fun RequestJoinData(@Body body: RequestJoinData) : Call<ResponseJoinData>

    // 메인 - 오늘의 문장1 - 성공
    @GET("/main/sentences")
    fun RequestMainSentences(
        //@Header("Content-Type") content_type: String,
        @Header("token") token: String?
    ) : Call<ResponseTodaySentenceData>

    // 추천 큐레이터 - 성공
    @GET("/curator/recommend")
    fun getRecommendCurator() : Call<ResponseRecommendCuratorData>

    // 테마 속 큐레이터 - 성공
    @GET("/curator/themeInCurator")
    fun requestCuratorInThemeData(
        @Header("token") token: String?
    ) : Call<ResponseCuratorInThemeData>

    // 메인 - 지금 인기있는 큐레이터 목록 조회 - 성공
    @GET("/main/curators")
    fun GetMainQurators() : Call<ResponseMainNowHotData>

    //내서재 메인 프로필 조회
    @GET("/my/profile")
    fun lookLibraryProfile(
        @Header("token") token: String?
    ) : Call<ResponseMainLibraryData>

    //내서재 테마 조회
    @GET("/my/theme")
    fun lookLibraryThema(
        @Header("token") token: String?
    ) : Call<ResponseLibraryThemeData>

    //내서재 테마 조회
    @GET("/my/sentence")
    fun lookLibrarySentence(
        @Header("token") token: String?
    ) : Call<ResponseLibrarySentenceData>

    //내서재 구독 조회
    @GET("/my/subscribe")
    fun lookLibraryCurator(
        @Header("token") token: String?
    ) : Call<ResponseLibraryCuratorData>

    // 메인 - 오늘 하루 저장이 가장 많이 된 테마목록 조회 - 성공
    @GET("/main/themes")
    fun GetMainThemes(
        @Header("token") token: String?
    ) : Call<ResponseMainHotThemeData>

    // 메인 - 문장을 기다리고 있는 테마 목록 조회
    @GET("/main/waitThemes")
    fun GetMainWaitThemes(
        @Header("token") token: String?
    ) : Call<ResponseMainHotThemeData>

    // 메인 - 요즘 사람들이 많이 본 테마
    @GET("/main/nowThemes")
    fun GetMainNowThemes(
        @Header("token") token: String?
    ) : Call<ResponseMainHotThemeData>

    // 메인 - 뷰페이저 이미지 통신
    @GET("/main/editorsPick")
    fun GetMainEditorsPick(

    ) : Call<ResponseMainEditorsPick>

    // 키워드 큐레이터 리스트
    @GET("/curator/{keywordIdx}/keyword")
    fun getCuratorKeyword(
        @Header("token") token: String?,
        @Path("keywordIdx") params: Int
    ) : Call<ResponseCuratorKeywordData>

    // 큐레이터 구독 / 취소
    @PUT("/curator/{followedIdx}")
    fun getFollowIdx(
        @Header("token") token: String?,
        @Path("followedIdx") params: Int
    ) : Call<ResponseCuratorFollowedData>

    //테마 상세 조회
    @GET("/detail/theme/{themeIdx}")
    fun GetDetailTheme(
        @Header("token") token: String?,
        @Path ("themeIdx") params: Int
    ) : Call<ResponseThemeDetailData>
}