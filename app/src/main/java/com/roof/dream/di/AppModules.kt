package com.roof.dream.di

import com.itexus.core.network.di.ServerQualifier
import com.itexus.core.network.di.networkModule
import com.itexus.di.main.navigationModule
import com.itexus.di.profile.buildProfileModule
import org.koin.core.module.Module

private val featuresModules = buildProfileModule(serverQualifier = ServerQualifier.app)
/*TODO Add modules */
//    buildProfileModule(serverQualifier = ServerQualifier.app) +
//            buildTransactionsModule(serverQualifier = ServerQualifier.app) +
//            buildTransferModule(serverQualifier = ServerQualifier.app) +
//            buildSupportModule(serverQualifier = ServerQualifier.app)


internal val app: List<Module> =
    navigationModule + networkModule + featuresModules
