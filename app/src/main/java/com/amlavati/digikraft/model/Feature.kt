package com.amlavati.digikraft.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

/**
 * Created by Sudarshan Bhatt on 02-06-2022
 * All rights reserved to https://www.amlavati.com
 */

@Parcelize
data class Feature(
    val geometry: Geometry,
    val id: String,
    val properties: PropertiesX,
    val type: String
) :Parcelable