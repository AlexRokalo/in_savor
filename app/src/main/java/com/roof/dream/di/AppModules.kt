package com.roof.dream.di

import com.roof.core.network.di.ServerQualifier
import com.roof.core.network.di.networkModule
import com.roof.di.main.navigationModule
import com.roof.di.profile.buildProfileModule
import com.roof.di.transactions.buildFilterModule
import com.roof.features.favorites.di.buildFavoritesModule
import org.koin.core.module.Module

private val featuresModules =
    buildProfileModule(serverQualifier = ServerQualifier.app) +
            buildFilterModule(serverQualifier = ServerQualifier.app) +
            buildFavoritesModule(serverQualifier = ServerQualifier.app)


internal val app: List<Module> =
    navigationModule + networkModule + featuresModules
