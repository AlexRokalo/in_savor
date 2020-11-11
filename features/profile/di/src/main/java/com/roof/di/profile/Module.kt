package com.roof.di.profile

import com.roof.di.profile.submodules.buildApiModule
import com.roof.di.profile.submodules.services
import com.roof.di.profile.submodules.usecases
import com.roof.di.profile.submodules.viewModels
import org.koin.core.qualifier.StringQualifier

fun buildProfileModule(serverQualifier: StringQualifier) =
    viewModels + usecases + services + buildApiModule(serverQualifier)