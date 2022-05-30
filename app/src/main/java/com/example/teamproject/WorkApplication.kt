package com.example.teamproject

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class WorkApplication : Application() {

    private val channelID = "channel1"
    private var notificationManager: NotificationManager? = null

    companion object {
        const val TAG = "WorkApplication"
    }

    private val backgroundCoroutineScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {

        super.onCreate()
        delayCreateWork()
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    private fun delayCreateWork() {
        backgroundCoroutineScope.launch {
            createWorkManager()
        }
    }

    private fun createWorkManager() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val oneTimeWorkRequest = OneTimeWorkRequestBuilder<Worker>().setInitialDelay(
            getSixHourIntervalTime(),
            TimeUnit.MILLISECONDS
        ).setConstraints(constraints).build()

        Log.e(TAG, "Init WorkManager")
        WorkManager.getInstance(applicationContext)
            .enqueueUniqueWork("Notification Work", ExistingWorkPolicy.REPLACE, oneTimeWorkRequest)
    }
}
/*

    private fun displayNotification() {
        //1. 알림콘텐츠 설정

        //채널 ID
        val notificationId = 45
        //알림의 탭 작업 설정 -----------------------------------------------------------------------
        val tapResultIntent = Intent(this, MainActivity::class.java).apply {
            //현재 액티비티에서 새로운 액티비티를 실행한다면 현재 액티비티를 새로운 액티비티로 교체하는 플래그
            //flags = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
            //이전에 실행된 액티비티들을 모두 없엔 후 새로운 액티비티 실행 플래그
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            tapResultIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notification: Notification = NotificationCompat.Builder(this, channelID)
            .setContentTitle("FIFA 전적검색") // 노티 제목
            .setContentText("FIFA 전적이 업데이트 되었습니다!") // 노티 내용
            .setSmallIcon(android.R.drawable.ic_dialog_info) //아이콘이미지
            .setAutoCancel(true) // 사용자가 알림을 탭하면 자동으로 알림을 삭제합니다.
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent) //노티클릭시 인텐트작업
            .setWhen(System.currentTimeMillis())
            .build()
        notificationManager?.notify(notificationId, notification)
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //중요도
            val importance = NotificationManager.IMPORTANCE_HIGH
            //채널 생성
            val channel = NotificationChannel(channelID, "DemoChannel", importance).apply {
                description = "this is a demo"
            }
            notificationManager?.createNotificationChannel(channel)
        } else {

        }

    }
}*/
/*
    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "FIFA" //getString(R.string.Channel_name)
            val descriptionText = "FIFA" //getString(R.string.Channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channelID", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun createNotification() {
        val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = NotificationCompat.Builder(this, "channelId")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("title")
            .setContentText("text")
            .setContentIntent(pendingIntent) // 클릭시 설정된 PendingIntent가 실행된다
            .setAutoCancel(true) // true이면 클릭시 알림이 삭제된다
            //.setTimeoutAfter(1000)
            //.setStyle(new NotificationCompat.BigTextStyle().bigText(text))
            .setDefaults(Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        notificationManager!!.notify(101, builder.build())
    }

    fun destroyNotification(id: Int) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        notificationManager!!.cancel(id)
    }*//*

}*/
