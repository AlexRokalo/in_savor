package com.roof.pagination_android

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.roof.pagination.Entity
import com.roof.pagination.requests.PageKeyedRequest
import com.roof.pagination.usecase.ReadPageUseCase
import com.roof.pagination_android.paged_datasource.PagedDataSourceFactory
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BasePagedListViewModel<E : Entity, Request : PageKeyedRequest<E>>(
    readPageUseCase: ReadPageUseCase<E, Request>,
    var readPageRequest: Request,
    lifecycleDisposables: CompositeDisposable
) {

    var sourceFactory = PagedDataSourceFactory(
        readPageUseCase,
        readPageRequest,
        lifecycleDisposables
    )


    var entities: LiveData<PagedList<E>>


    init {
        val config = PagedList.Config.Builder()
            .setPageSize(readPageRequest.pageSize)
            .setEnablePlaceholders(false)
            .build()

        entities = LivePagedListBuilder(sourceFactory, config).build()
    }


    fun refresh() {
        readPageRequest.page = 1
        sourceFactory.dataSourceLiveData.value?.invalidate()
    }
}