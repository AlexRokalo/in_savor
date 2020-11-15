package com.roof.core.navigation

interface INavigator<S> {
    fun attach(subject: S)
}