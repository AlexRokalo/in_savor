package com.roof.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import io.reactivex.rxjava3.core.*

fun <T> Flowable<T>.toLiveData(): LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher { subscriber ->
        this.subscribe({
            subscriber.onNext(it)
        }, {})
    }
}

fun <T> Observable<T>.toLiveData(backPressureStrategy: BackpressureStrategy = BackpressureStrategy.DROP): LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher { subscriber ->
        this.toFlowable(backPressureStrategy).subscribe({
            subscriber.onNext(it)
        }, {})
    }
}

fun <T> Single<T>.toLiveData(): LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher { subscriber ->
        this.toFlowable().subscribe({
            subscriber.onNext(it)
        }, {})
    }

}

fun <T> Maybe<T>.toLiveData(): LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher { subscriber ->
        this.toFlowable().subscribe({
            subscriber.onNext(it)
        }, {})
    }
}