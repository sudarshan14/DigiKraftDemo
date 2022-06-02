package com.amlavati.digikraft.networking

import com.amlavati.digikraft.model.BikeStationData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sudarshan Bhatt on 02-06-2022
 * All rights reserved to https://www.amlavati.com
 */

interface RetrofitApis {
    @GET("mim/plan/map_service.html")
    suspend fun getBikeStationData(
        @Query("mtype") mType: String?,
        @Query("co") co: String?
    ): Response<BikeStationData>
}