package com.itexus.pagination.usecase

import com.itexus.pagination.Entity
import com.itexus.pagination.requests.PaginationRequest


abstract class ReadPageUseCase<E : Entity, Request : PaginationRequest<E>> :
    ReadUseCase<List<E>, Request>()

