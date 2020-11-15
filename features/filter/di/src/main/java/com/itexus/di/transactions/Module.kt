package com.itexus.di.transactions

import com.itexus.di.transactions.submodules.buildApiModule
import com.itexus.di.transactions.submodules.services
import com.itexus.di.transactions.submodules.viewModels
import org.koin.core.qualifier.StringQualifier

fun buildFilterModule(serverQualifier: StringQualifier) =
    viewModels + services + buildApiModule(serverQualifier)