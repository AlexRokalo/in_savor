package com.roof.filter.di

import com.roof.filter.di.submodules.buildApiModule
import com.roof.filter.di.submodules.services
import com.roof.filter.di.submodules.usecases
import com.roof.filter.di.submodules.viewModels
import org.koin.core.qualifier.StringQualifier

fun buildRestoranDetailsModule(serverQualifier: StringQualifier) =
    viewModels + usecases + services + buildApiModule(serverQualifier)