package com.amlavati.digikraft.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.amlavati.digikraft.util.NotificationHelper

/**
 * Created by Sudarshan Bhatt on 02-06-2022
 * All rights reserved to https://www.amlavati.com
 */

const val SERVICE_COMMAND = "Command"
const val NOTIFICATION_TEXT = "NotificationText"
class MyForegroundServices : Service() {

    private val helper by lazy { NotificationHelper(this) }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)


        return START_STICKY
    }

    override fun stopService(name: Intent?): Boolean {
        stopForeground(true)
        stopSelf()
        return true
    }
}