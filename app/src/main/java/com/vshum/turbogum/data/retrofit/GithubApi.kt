package com.vshum.turbogum.data.retrofit

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface GithubApi {
    @GET("dataLinersTestMVVM.json")
    fun getUsers(): Single<List<LinersEntityDto>>

//    @GET("users/{login}")
//    fun getProfile(): Single<ProfileEntityDto>
}