import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import phoenix.krishna.rentooshfcm.R;

public class RentooshMessage extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        super.onMessageReceived(remoteMessage);
        showNotifications(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());


    }

    public void showNotifications(String title,String message){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"My Notifications")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_folder)
                .setContentText(message)
                .setAutoCancel(true);

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);

        managerCompat.notify(999,builder.build());

    }
}
