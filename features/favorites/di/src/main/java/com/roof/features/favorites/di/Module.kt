package com.roof.features.favorites.di

import com.roof.features.favorites.di.submodules.buildApiModule
import com.roof.features.favorites.di.submodules.services
import com.roof.features.favorites.di.submodules.viewModels
import org.koin.core.qualifier.StringQualifier

fun buildFavoritesModule(serverQualifier: StringQualifier) =
    viewModels + services + buildApiModule(serverQualifier)