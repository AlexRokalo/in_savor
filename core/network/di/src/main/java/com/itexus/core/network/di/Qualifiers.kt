package com.itexus.core.network.di

import org.koin.core.qualifier.StringQualifier

object ServerQualifier {
    val auth = StringQualifier("authServerQualifier")
    val app = StringQualifier("appServerQualifier")
}
