package com.itexus.di.main

import com.itexus.di.main.submodules.data.dataModule
import com.itexus.di.main.submodules.presentationModule

val navigationModule = presentationModule + dataModule