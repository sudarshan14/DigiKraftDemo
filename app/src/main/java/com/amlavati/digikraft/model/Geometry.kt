package com.amlavati.digikraft.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Sudarshan Bhatt on 02-06-2022
 * All rights reserved to https://www.amlavati.com
 */

@Parcelize
data class Geometry(
    val coordinates: List<Double>,
    val type: String
):Parcelable