package com.example.alarmclock


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlertReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val notificationHelper = NotificationHelper(context)
        val nb = notificationHelper.getChannelNotification()
        notificationHelper.getManager()?.notify(1, nb?.build())
    }
}