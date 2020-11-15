package com.roof.core.mvvm.rx.binding

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputLayout
import com.roof.core.mvvm.rx.view_model.RxFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable

fun TextInputLayout.bindError(
    lifeCycleOwner: RxFragment,
    error: Observable<Int>,
    hideOnChange: Boolean = true
) = with(lifeCycleOwner) {

    error.observeOn(AndroidSchedulers.mainThread())
        .doOnNext {
            this@bindError.error = this@bindError.context.getString(it)
        }.subscribeInLifecycle()

    if (hideOnChange) {
        editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                this@bindError.error = null
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }
}

fun TextInputLayout.bind(
    lifeCycleOwner: RxFragment,
    value: Observable<String>
) = with(lifeCycleOwner) {

    value.observeOn(AndroidSchedulers.mainThread())
        .doOnNext {
            this@bind.editText?.setText(it)
        }.subscribeInLifecycle()

}

fun TextInputLayout.bind(
    value: Int?,
    hideOnChange: Boolean = true
) {

    this@bind.error = value?.let { this.context.getString(it) }
    if (hideOnChange) {
        editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                this@bind.error = null
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }
}