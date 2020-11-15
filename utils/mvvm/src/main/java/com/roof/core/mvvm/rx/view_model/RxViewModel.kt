package com.roof.core.mvvm.rx.view_model

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Adds methods and extensions for clearing disposables for ViewModel lifecycle.
 * */
open class RxViewModel : ViewModel() {

    private val lifecycleDisposables = CompositeDisposable()

    /* Lifecycle */
    override fun onCleared() {
        super.onCleared()
        lifecycleDisposables.clear()
    }


    /* Extensions */
    private fun Disposable.bindToLifecycle(): Disposable {
        lifecycleDisposables.add(this)
        return this
    }

    /**
     * Subscription utils. Holds disposables and clears them when ViewModel
     * destroying.
     * */
    fun <T : Any?> Single<T>.subscribeByViewModel(
        onError: (Throwable) -> Unit = {},
        onSuccess: (T) -> Unit = {}
    ): Disposable {
        return this
            .subscribe(onSuccess, onError)
            .bindToLifecycle()
    }

    fun <T : Any?> Maybe<T>.subscribeByViewModel(
        onError: (Throwable) -> Unit = {},
        onSuccess: (T) -> Unit = {}
    ): Disposable {
        return this
            .subscribe(onSuccess, onError)
            .bindToLifecycle()
    }

    fun Completable.subscribeByViewModel(
        onError: (Throwable) -> Unit = {},
        onComplete: () -> Unit = {}
    ): Disposable {
        return this.subscribe(onComplete, onError)
            .bindToLifecycle()
    }

    fun <T : Any?> Observable<T>.subscribeByViewModel(
        onError: (Throwable) -> Unit = {},
        onNext: (T) -> Unit = {}
    ): Disposable {
        return this.subscribe(onNext, onError)
            .bindToLifecycle()
    }
}
