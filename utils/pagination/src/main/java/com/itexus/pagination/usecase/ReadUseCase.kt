package com.itexus.pagination.usecase

import com.itexus.pagination.requests.ReadRequest
import io.reactivex.rxjava3.core.Single

abstract class ReadUseCase<A, Request : ReadRequest<A>> {
    abstract fun execute(request: Request): Single<A>
}