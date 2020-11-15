package com.roof.di.main

import com.roof.di.main.submodules.data.dataModule
import com.roof.di.main.submodules.presentationModule

val navigationModule = presentationModule + dataModule