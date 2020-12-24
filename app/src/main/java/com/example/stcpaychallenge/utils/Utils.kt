package com.example.stcpaychallenge.utils

import android.text.Html

object Utils {

    fun htmlToStringParser(input: String?): String? {
        return if (input != null) Html.fromHtml(input).toString() else ""
    }
}