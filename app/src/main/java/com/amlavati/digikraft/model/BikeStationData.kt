package com.amlavati.digikraft.model

/**
 * Created by Sudarshan Bhatt on 02-06-2022
 * All rights reserved to https://www.amlavati.com
 */


data class BikeStationData(
    val crs: Crs,
    val features: List<Feature>,
    val type: String
)