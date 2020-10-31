package com.itexus.core.mvvm.rx.view_model

import androidx.fragment.app.Fragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Adds methods and extensions for clearing disposables for Fragment lifecycle.
 * */
open class RxFragment : Fragment() {

    private val lifecycleDisposables = CompositeDisposable()

    override fun onDestroyView() {
        super.onDestroyView()
        lifecycleDisposables.clear()
    }


    /* Extensions */
    private fun Disposable.bindToLifecycle(): Disposable {
        lifecycleDisposables.add(this)
        return this
    }

    /**
     * Subscription utils. Holds disposables and clears them when Fragment
     * destroying.
     * */
    fun <T : Any?> Single<T>.subscribeInLifecycle(
        onError: (Throwable) -> Unit = {},
        onNext: (T) -> Unit = {}
    ): Disposable {
        return this
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onNext, onError)
            .bindToLifecycle()
    }

    fun Completable.subscribeInLifecycle(
        onError: (Throwable) -> Unit = {},
        onComplete: () -> Unit = {}
    ): Disposable {
        return this.observeOn(AndroidSchedulers.mainThread())
            .subscribe(onComplete, onError)
            .bindToLifecycle()
    }

    fun <T : Any?> Observable<T>.subscribeInLifecycle(
        onError: (Throwable) -> Unit = {},
        onComplete: (T) -> Unit = {}
    ): Disposable {
        return this.observeOn(AndroidSchedulers.mainThread())
            .subscribe(onComplete, onError)
            .bindToLifecycle()
    }

}
