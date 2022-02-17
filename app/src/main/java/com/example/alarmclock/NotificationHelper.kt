package com.example.alarmclock


import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import androidx.core.app.NotificationCompat
import android.app.NotificationManager as NotificationManager1


class NotificationHelper(base: Context?) : ContextWrapper(base) {
    val channelID = "channelID"
    val channelName = "Channel Name"

    private var mManager: NotificationManager1? = null

    fun NotificationHelper(base: Context?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel()
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private fun createChannel() {
        val channel = NotificationChannel(channelID, channelName, NotificationManager1.IMPORTANCE_HIGH)
        mManager?.createNotificationChannel(channel)
    }

    fun getManager(): NotificationManager? {
        if (mManager == null) {
            mManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        }
        return mManager
    }

    fun getChannelNotification(): NotificationCompat.Builder? {
        return NotificationCompat.Builder(applicationContext, channelID)
            .setContentTitle("Alarm!")
            .setContentText("Your AlarmManager is working.")
            .setSmallIcon(R.drawable.ic_baseline_android_24)
    }

}