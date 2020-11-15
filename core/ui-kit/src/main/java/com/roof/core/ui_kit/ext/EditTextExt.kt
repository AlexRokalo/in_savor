package com.roof.core.ui_kit.ext

import android.widget.EditText
import com.redmadrobot.inputmask.MaskedTextChangedListener


fun EditText.configurePhoneInput(phoneMask: String) {
    with(MaskedTextChangedListener(phoneMask, this)) {
        this@configurePhoneInput.addTextChangedListener(this)
        this@configurePhoneInput.onFocusChangeListener = this
    }
}