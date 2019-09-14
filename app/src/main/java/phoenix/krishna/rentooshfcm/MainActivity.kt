package phoenix.krishna.rentooshfcm

import androidx.appcompat.app.AppCompatActivity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel("Notify", "Notifications", NotificationManager.IMPORTANCE_DEFAULT)

            val manager = getSystemService<NotificationManager>(NotificationManager::class.java!!)
            manager!!.createNotificationChannel(channel)
        }

        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener { task ->
                    var msg = "Successful"
                    if (!task.isSuccessful) {
                        msg = "Failed"
                    }
                    Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                }

    }
}
