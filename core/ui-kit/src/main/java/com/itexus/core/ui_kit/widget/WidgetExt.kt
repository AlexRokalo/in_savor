package com.itexus.core.ui_kit.widget

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T : Widget> LifecycleOwner.bindWidget(
    container: ViewGroup,
    widget: T,
    configure: View.() -> Unit = {}
) {
    container.removeAllViews()
    val view = widget.build(container, this)
    view.configure()
    container.addView(view)
}

fun <T : Widget> LifecycleOwner.bindWidgets(
    container: ViewGroup,
    vararg widgets: T
) {
    container.removeAllViews()
    widgets.forEach { widget ->
        val view = widget.build(container, this)
        container.addView(view)
    }
}

fun <T : Widget> LifecycleOwner.bindWidget(
    container: ViewGroup,
    liveData: LiveData<T>,
    configure: View.() -> Unit = {}
) {
    liveData.observe(this, Observer {
        container.removeAllViews()
        val view = it?.build(container, this)
        view?.configure()
        view?.let(container::addView)
    })
}
