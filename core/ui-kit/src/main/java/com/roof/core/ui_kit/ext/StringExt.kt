package com.roof.core.ui_kit.ext

import java.util.regex.Pattern

/*
*  You can find a solution here
*  //https://stackoverflow.com/questions/5114762/how-do-format-a-phone-number-as-a-string-in-java
* */


fun String.toAmericanPhoneFormat(): String = "+ 1 ${
    this.replaceFirst(
        "(\\d{3})(\\d{3})(\\d+)".toRegex(),
        "($1) $2-$3"
    )
}"

private const val EMAIL_REGEX = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}"
fun String.textIsEmail(): Boolean = Pattern.compile(EMAIL_REGEX).matcher(this).matches()