package juidesai.edu.csulb.com.artattack;

/**
 * Created by jmd19 on 3/21/2017.
 */
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

public class Unlock extends BroadcastReceiver {
    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context = context;
        if (intent.getAction().equals(Intent.ACTION_USER_PRESENT)){


            callPush();

        }else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
        }
    }

    private void callPush()
    {
        try{
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder b = new NotificationCompat.Builder(context);

            b.setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setWhen(System.currentTimeMillis())
                    .setTicker("ArtTherapy")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Make a picture")
                    .setContentText("Keep Calm and Draw on a canvas")
                    .setDefaults(Notification.DEFAULT_VIBRATE| Notification.DEFAULT_SOUND| Notification.DEFAULT_LIGHTS)
                    .setContentIntent(contentIntent)
                    .setContentInfo("Information");


            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, b.build());
        }
        catch (Exception e)
        {
            System.out.print(e.toString());
        }
    }
}


