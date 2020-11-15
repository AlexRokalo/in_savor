package com.roof.features.main.di

import com.roof.features.main.di.submodules.buildApiModule
import com.roof.features.main.di.submodules.services
import com.roof.features.main.di.submodules.viewModels
import org.koin.core.qualifier.StringQualifier

fun buildMainModule(serverQualifier: StringQualifier) =
    viewModels + services + buildApiModule(serverQualifier)