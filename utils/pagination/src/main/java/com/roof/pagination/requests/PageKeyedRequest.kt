package com.roof.pagination.requests

abstract class PageKeyedRequest<E> : PaginationRequest<E>() {

    abstract var page: Int  //PageNumber
    abstract var pageSize: Int //PageSize

}