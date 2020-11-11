package com.roof.core.ui_kit.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.bindError(
    lifeCycleOwner: LifecycleOwner,
    error: LiveData<Int>,
    hideOnChange: Boolean = true
) {

    error.observe(lifeCycleOwner, Observer {
        this.error = context.getString(it)
    })

    if (hideOnChange) {
        editText?.onTextChanged { this.error = null }
    }

}