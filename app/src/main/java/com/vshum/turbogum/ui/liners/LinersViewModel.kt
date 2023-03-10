package com.vshum.turbogum.ui.liners

import androidx.lifecycle.ViewModel
import com.vshum.turbogum.domain.entities.LinersEntity
import com.vshum.turbogum.domain.repos.LinersRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.Subject

class LinersViewModel(private val linersRepo: LinersRepo) : LinersContract.ViewModel, ViewModel() {

    override val usersLiveData: Observable<List<LinersEntity>> = BehaviorSubject.create()
    override val errorLiveData: Observable<Throwable> = BehaviorSubject.create()
    override val progressLiveData: Observable<Boolean> = BehaviorSubject.create()
    override val openProfileLiveData: Observable<Unit> = BehaviorSubject.create()

    override fun onRefresh() {
        loadData()
    }

    override fun onProfileClick() {
        (openProfileLiveData as BehaviorSubject).onNext(Unit)
    }

    private fun loadData() {
        progressLiveData.mutable().onNext(true)
        linersRepo.getLiners()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    progressLiveData.mutable().onNext(false)
                    usersLiveData.mutable().onNext(it)
                },
                onError = {
                    progressLiveData.mutable().onNext(false)
                    errorLiveData.mutable().onNext(it)
                }
            )
    }


    private fun <T : Any> Observable<T>.mutable(): Subject<T> {
        return this as? Subject<T>
            ?: throw IllegalStateException("It is not MutableLiveData")
    }
}