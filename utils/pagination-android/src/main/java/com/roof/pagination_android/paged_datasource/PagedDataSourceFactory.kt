package com.roof.pagination_android.paged_datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.roof.pagination.Entity
import com.roof.pagination.requests.PageKeyedRequest
import com.roof.pagination.usecase.ReadPageUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable


class PagedDataSourceFactory<E : Entity, Request : PageKeyedRequest<E>>(
    private val readPageUseCase: ReadPageUseCase<E, Request>,
    var readPageRequest: Request,
    private val compositeDisposable: CompositeDisposable
) : DataSource.Factory<String, E>() {


    val dataSourceLiveData = MutableLiveData<PagedDataSource<E, Request>>()

    val isEmpty: LiveData<Boolean>
        get() = _isEmpty
    private val _isEmpty = MutableLiveData<Boolean>()

    val error: LiveData<Throwable>
        get() = _error
    private val _error = MutableLiveData<Throwable>()

    override fun create(): PagedDataSource<E, Request> {
        val dataSource = PagedDataSource(readPageUseCase, readPageRequest, compositeDisposable)
        dataSourceLiveData.postValue(dataSource)
        compositeDisposable.addAll(
            dataSource.isEmpty.subscribe { _isEmpty.postValue(it) },
            dataSource.error.subscribe { _error.postValue(it) }
        )
        return dataSource
    }

}