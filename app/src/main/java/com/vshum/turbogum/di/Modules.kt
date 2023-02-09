package com.vshum.turbogum.di

import com.vshum.turbogum.data.retrofit.RetrofitLinersRepoImpl
import com.vshum.turbogum.data.retrofit.GithubApi
import com.vshum.turbogum.domain.repos.LinersRepo
import com.vshum.turbogum.ui.liners.LinersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single( qualifier("url")) {"https://raw.githubusercontent.com/VyacheslavShumilov/JsonTurbo/main/"}

    single {
        Retrofit.Builder()
            .baseUrl(get<String>(named("url")))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) //RxJava3 Adapter
            .build()
    }

    single <GithubApi> {
        get<Retrofit>().create(GithubApi::class.java)
    }

    single<LinersRepo> {
        RetrofitLinersRepoImpl(get())
    }

//    single<ProfileRepo> {
//        RetrofitProfileRepoImpl(get())
//    }

    viewModel { LinersViewModel(get()) }
//    viewModel { ProfileViewModel(get()) }
}