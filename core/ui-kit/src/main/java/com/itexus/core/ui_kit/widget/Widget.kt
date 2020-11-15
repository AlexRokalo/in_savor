package com.itexus.core.ui_kit.widget

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner


abstract class Widget {

    var arguments: Bundle? = null

    abstract fun build(parent: ViewGroup, lifecycleOwner: LifecycleOwner): View

}
