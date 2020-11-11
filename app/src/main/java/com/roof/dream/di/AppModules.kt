package com.roof.dream.di

import com.roof.core.network.di.ServerQualifier
import com.roof.core.network.di.networkModule
import com.roof.di.main.navigationModule
import com.roof.di.profile.buildProfileModule
import com.roof.di.transactions.buildFilterModule
import org.koin.core.module.Module

private val featuresModules =
    buildProfileModule(serverQualifier = ServerQualifier.app) +
            buildFilterModule(serverQualifier = ServerQualifier.app)
/*TODO Add modules */
//    buildProfileModule(serverQualifier = ServerQualifier.app) +
//            buildTransactionsModule(serverQualifier = ServerQualifier.app) +
//            buildTransferModule(serverQualifier = ServerQualifier.app) +
//            buildSupportModule(serverQualifier = ServerQualifier.app)


internal val app: List<Module> =
    navigationModule + networkModule + featuresModules
