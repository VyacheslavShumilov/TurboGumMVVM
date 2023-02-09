package com.vshum.turbogum.ui.liners

import com.vshum.turbogum.domain.entities.LinersEntity
import io.reactivex.rxjava3.core.Observable

interface LinersContract {

    interface ViewModel {

        val usersLiveData: Observable<List<LinersEntity>>
        val errorLiveData: Observable<Throwable>
        val progressLiveData: Observable<Boolean>
        val openProfileLiveData: Observable<Unit> // для открытия новой активити

        fun onRefresh()     //управляющий метод
        fun onProfileClick()
    }

}