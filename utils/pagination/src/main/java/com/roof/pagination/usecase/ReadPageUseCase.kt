package com.roof.pagination.usecase

import com.roof.pagination.Entity
import com.roof.pagination.requests.PaginationRequest


abstract class ReadPageUseCase<E : Entity, Request : PaginationRequest<E>> :
    ReadUseCase<List<E>, Request>()

