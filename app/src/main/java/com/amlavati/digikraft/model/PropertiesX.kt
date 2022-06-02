package com.amlavati.digikraft.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Sudarshan Bhatt on 02-06-2022
 * All rights reserved to https://www.amlavati.com
 */

@Parcelize
data class PropertiesX(
    val bike_racks: String,
    val bikes: String,
    val free_racks: String,
    val label: String,
    val updated: String
) : Parcelable