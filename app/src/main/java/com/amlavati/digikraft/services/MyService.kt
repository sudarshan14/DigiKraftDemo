package com.amlavati.digikraft.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.amlavati.digikraft.networking.RetrofitService
import com.amlavati.digikraft.repository.DataSourceRepository
import com.amlavati.digikraft.util.UNI_TAG
import com.amlavati.digikraft.util.debugLogger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by Sudarshan Bhatt on 02-06-2022
 * All rights reserved to https://www.amlavati.com
 */


class MyService : Service() {

    val TAG = "MyService"

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }


    override fun onCreate() {
        super.onCreate()

        Log.d(TAG, "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        var i = 0
//        Log.d(TAG, "onStartCommand")
//        Thread {
//            while (i < 10) {
//                Log.d(TAG, "service is running")
//                Thread.sleep(1000)
//                i++
//            }
//        }.start()
        val retrofitService = RetrofitService.retrofitService
        val repository = DataSourceRepository(retrofitService)
        CoroutineScope(Dispatchers.IO).launch {
            val op = repository.getBikeStationData("pub_transport", "stacje_rowerowe")

            withContext(Dispatchers.Main) {
                if (op.isSuccessful) {
                    debugLogger(UNI_TAG, "${op.body()}")
                }
            }

        }

// START_NOT_STICKY tells the system not to recreate the service with an undefined Intent
        return START_NOT_STICKY
    }
}