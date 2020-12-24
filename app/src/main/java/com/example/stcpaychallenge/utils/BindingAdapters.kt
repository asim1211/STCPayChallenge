package com.example.stcpaychallenge.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("htmlToText")
fun bindLabeledTextView(textView: TextView, text: String?) {
    text?.let {
        textView.text = Utils.htmlToStringParser(text)
    }
}