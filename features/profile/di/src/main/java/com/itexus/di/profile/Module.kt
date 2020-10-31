package com.itexus.di.profile

import com.itexus.di.profile.submodules.buildApiModule
import com.itexus.di.profile.submodules.services
import com.itexus.di.profile.submodules.usecases
import com.itexus.di.profile.submodules.viewModels
import org.koin.core.qualifier.StringQualifier

fun buildProfileModule(serverQualifier: StringQualifier) =
    viewModels + usecases + services + buildApiModule(serverQualifier)