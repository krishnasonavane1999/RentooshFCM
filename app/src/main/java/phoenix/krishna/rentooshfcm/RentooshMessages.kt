package phoenix.krishna.rentooshfcm

import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

import phoenix.krishna.rentooshfcm.R

class RentooshMessages : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {

        super.onMessageReceived(remoteMessage)
        showNotifications(remoteMessage!!.notification!!.title, remoteMessage.notification!!.body)


    }

    fun showNotifications(title: String?, message: String?) {

        val builder = NotificationCompat.Builder(this, "My Notifications")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_folder)
                .setContentText(message)
                .setAutoCancel(true)

        val managerCompat = NotificationManagerCompat.from(this)

        managerCompat.notify(999, builder.build())

    }
}
