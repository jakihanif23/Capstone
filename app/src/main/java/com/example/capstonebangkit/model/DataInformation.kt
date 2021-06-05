package com.example.capstonebangkit.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class DataInformation (
    var img: Int?,
    var judul: String?
) : Parcelable