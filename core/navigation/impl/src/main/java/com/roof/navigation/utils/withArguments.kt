package com.roof.navigation.utils

import android.os.Bundle
import androidx.fragment.app.Fragment

inline fun Fragment.withArguments(configure: (Bundle) -> Unit): Fragment {
    val arguments = Bundle()
    configure(arguments)
    this.arguments = arguments
    return this
}