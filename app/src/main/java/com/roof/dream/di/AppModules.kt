package com.roof.dream.di

import com.itexus.core.network.di.networkModule
import com.itexus.di.main.navigationModule
import org.koin.core.module.Module
import org.koin.dsl.module

private val featuresModules = module { }
/*TODO Add modules */
//    buildProfileModule(serverQualifier = ServerQualifier.app) +
//            buildTransactionsModule(serverQualifier = ServerQualifier.app) +
//            buildTransferModule(serverQualifier = ServerQualifier.app) +
//            buildSupportModule(serverQualifier = ServerQualifier.app)


internal val app: List<Module> =
    navigationModule + networkModule + featuresModules
