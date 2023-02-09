package com.vshum.turbogum.domain.repos

import com.vshum.turbogum.domain.entities.LinersEntity
import io.reactivex.rxjava3.core.Single

interface LinersRepo {

    fun getLiners(): Single<List<LinersEntity>>
}