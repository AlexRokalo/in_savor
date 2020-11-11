package com.roof.pagination_android.paged_datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.ItemKeyedDataSource
import com.roof.pagination.Entity
import com.roof.pagination.requests.PageKeyedRequest
import com.roof.pagination.usecase.ReadPageUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.BehaviorSubject

class PagedDataSource<E : Entity, Request : PageKeyedRequest<E>>(
    private val readPageUseCase: ReadPageUseCase<E, Request>,
    private val readPageRequest: Request,
    private val compositeDisposable: CompositeDisposable
) : ItemKeyedDataSource<String, E>() {

    private val isInitialProcessing = MutableLiveData<Boolean>()

    val isEmpty = BehaviorSubject.create<Boolean>()
    val error = BehaviorSubject.create<Throwable>()

    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<E>) {
        isInitialProcessing.postValue(true)
        compositeDisposable.add(
            readPageUseCase.execute(readPageRequest)
                .doOnError { error.onNext(it) }
                .doFinally { isInitialProcessing.postValue(false) }
                .subscribe({ page ->
                    // clear retry since last source succeeded
                    callback.onResult(page)
                    isEmpty.onNext(page.isEmpty())
                }, {})
        )
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<E>) {
        readPageRequest.page++
        compositeDisposable.add(
            readPageUseCase.execute(readPageRequest)
                .doOnError { error.onNext(it) }
                .subscribe({ page ->
                    // clear retry since last source succeeded
                    callback.onResult(page)
                }, {})
        )
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<E>) {
        // ignored, since we only ever append to our initial load
    }

    override fun getKey(item: E): String = item.id.toString()

}