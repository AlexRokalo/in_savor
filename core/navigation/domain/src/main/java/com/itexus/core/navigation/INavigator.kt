package com.itexus.core.navigation

interface INavigator<S> {
    fun attach(subject: S)
}