package com.lambdaschool.extensionfunctions

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

fun Context.notification(notificationId: Int = 0, channelId: String = "") {
    val notificationBuilder = NotificationCompat.Builder(this, channelId)
    notificationBuilder
        .setPriority(NotificationManager.IMPORTANCE_HIGH)
        .setContentTitle("Notification")
        .setContentText("This is my Notification")
        .setSmallIcon(android.R.drawable.star_off)
        .setColor(ContextCompat.getColor(this, R.color.colorPrimary))

    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "Notification Channel"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val notificationChannel = NotificationChannel(channelId, name, importance)
        notificationManager.createNotificationChannel(notificationChannel)
    }

    notificationManager.notify(0, notificationBuilder.build())
}