package com.amlavati.digikraft.repository

import com.amlavati.digikraft.model.BikeStationData
import com.amlavati.digikraft.networking.RetrofitApis
import retrofit2.Response

/**
 * Created by Sudarshan Bhatt on 02-06-2022
 * All rights reserved to https://www.amlavati.com
 */

class DataSourceRepository(
    private val retrofitApi: RetrofitApis
) {
    suspend fun getBikeStationData(pType: String?, co: String?): Response<BikeStationData> =
        retrofitApi.getBikeStationData(pType, co)

}