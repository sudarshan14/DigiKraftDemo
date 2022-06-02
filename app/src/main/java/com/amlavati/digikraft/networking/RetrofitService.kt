package com.amlavati.digikraft.networking

import com.amlavati.digikraft.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Sudarshan Bhatt on 02-06-2022
 * All rights reserved to https://www.amlavati.com
 */


private const val TIME_OUT: Long = 120

//private val okHttpClient = OkHttpClient.Builder()
//    .readTimeout(TIME_OUT, TimeUnit.SECONDS)
//    .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
//    .addInterceptor { chain ->
//        val resp = chain.proceed(chain.request())
//        // Deal with the response code
//        if (resp.code == 200) {
//            try {
//                val myJson =
//                    resp.peekBody(2048).string() // peekBody() will not close the response
//                debugLogger(UNI_TAG, myJson)
//            } catch (e: Exception) {
//                exceptionLogger(UNI_TAG, " exception parsing data", e)
//            }
//        } else {
//            println(resp)
//        }
//        resp
//    }
//    .build()


private val retrofit = Retrofit.Builder()
    .baseUrl(Constants.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
//    .client(okHttpClient)
    .build()


object RetrofitService {
    val retrofitService: RetrofitApis by lazy {
        retrofit.create(RetrofitApis::class.java)
    }
}

/* can create Api Interface in this same file as well
* */

//interface RetrofitApi {
//
//    @GET("mim/plan/map_service.html")
//    suspend fun getBikeStationData(
//        @Query("mtype") city: String?,
//        @Query("co") appid: String
//    ): Response<BikeStationData>
//
//
//}