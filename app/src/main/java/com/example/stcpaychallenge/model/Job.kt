package com.example.stcpaychallenge.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Job(
    @SerializedName("type") val type: String = "",
    @SerializedName("url") val url: String = "",
    @SerializedName("company") val company: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("description") val description: String = ""
) : Parcelable