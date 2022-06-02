package com.amlavati.digikraft.util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build

import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.amlavati.digikraft.R
import com.amlavati.digikraft.ui.two.BaseActivity

/**
 * Created by Sudarshan Bhatt on 01-06-2022
 * All rights reserved to https://www.amlavati.com
 */


private const val CHANNEL_ID = "StarWarsChannel"
private const val CHANNEL_NAME = "StarWarsChannelName"
private const val CHANNEL_DESCRIPTION = "StarWarsChannelDescription"

class NotificationHelper(context: Context) {


    private val notificationManager by lazy {
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel() =
        NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = CHANNEL_DESCRIPTION
            setSound(null, null)
        }

    private val notificationBuilder: NotificationCompat.Builder by lazy {
        NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(context.getString(R.string.app_name))
            .setContentIntent(contentIntent)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
    }

    fun getNotification(): Notification {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(createChannel())
        }

        return notificationBuilder.build()

    }

    fun updateNotification(notificationText: String? = null) {
        notificationText.let {
            notificationBuilder.setContentText(it)
            notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())
        }
    }


    private val contentIntent by lazy {
        PendingIntent.getActivity(
            context,
            0,
            Intent(context, BaseActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }


    companion object {
        const val NOTIFICATION_ID = 99
    }
}