package com.itexus.pagination.requests

import com.itexus.pagination.Entity

abstract class ItemKeyedRequest<E : Entity> : PaginationRequest<E>() {

    abstract var lastMessageId: String
    abstract var size: Int //PageSize
}