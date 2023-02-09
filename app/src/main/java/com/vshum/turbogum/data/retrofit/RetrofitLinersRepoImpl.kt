package com.vshum.turbogum.data.retrofit

import com.vshum.turbogum.domain.entities.LinersEntity
import com.vshum.turbogum.domain.repos.LinersRepo
import io.reactivex.rxjava3.core.Single

class RetrofitLinersRepoImpl(private val api: GithubApi) : LinersRepo {


    override fun getLiners(): Single<List<LinersEntity>> = api.getUsers()
        .map { users ->
            users.map {
                it.toLinersEntity()
            }
        }
}