package com.roof.pagination.requests

import com.roof.pagination.Entity

abstract class ItemKeyedRequest<E : Entity> : PaginationRequest<E>() {

    abstract var lastMessageId: String
    abstract var size: Int //PageSize
}