package com.roof.di.transactions

import com.roof.di.transactions.submodules.buildApiModule
import com.roof.di.transactions.submodules.services
import com.roof.di.transactions.submodules.viewModels
import org.koin.core.qualifier.StringQualifier

fun buildFilterModule(serverQualifier: StringQualifier) =
    viewModels + services + buildApiModule(serverQualifier)