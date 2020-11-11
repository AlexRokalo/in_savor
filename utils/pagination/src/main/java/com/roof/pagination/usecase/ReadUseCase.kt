package com.roof.pagination.usecase

import com.roof.pagination.requests.ReadRequest
import io.reactivex.rxjava3.core.Single

abstract class ReadUseCase<A, Request : ReadRequest<A>> {
    abstract fun execute(request: Request): Single<A>
}