package com.hackingbuzz.notification2difftypes;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);



        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Creates an explicit intent for an Activity in your app
                Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);

                stackBuilder.addParentStack(ResultActivity.class);

                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(
                                0,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );

                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(MainActivity.this)
                                .setAutoCancel(true)
                                .setSmallIcon(android.R.drawable.gallery_thumb)  // you can see on let side where you get line numbers...its not getting any icon image...so not gonna show
                               // .setColor(Color.RED)
                                .setContentTitle("Wao! Try out this magic makeup Prouduct");

                Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.simp);
                NotificationCompat.BigPictureStyle s = new NotificationCompat.BigPictureStyle().bigPicture(largeIcon);
                s.setSummaryText("This is ash proudct buy it");
                mBuilder.setStyle(s);

                mBuilder.setContentIntent(resultPendingIntent);
                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(1, mBuilder.build());
            }
        });



        // button 2 gets clicked

        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Creates an explicit intent for an Activity in your app
                Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);

                stackBuilder.addParentStack(ResultActivity.class);

                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(
                                0,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );
                // Create the reply action and add the remote input.

                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(MainActivity.this)
                                .setSmallIcon(R.drawable.fb)  // its taking 128 px not more..than that.
                                .setAutoCancel(true)
                                .setContentTitle("Downloading Resource");

                mBuilder.setContentIntent(resultPendingIntent);
                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mBuilder.setProgress(0, 100, true);
                mNotificationManager.notify(1, mBuilder.build());
            }
        });


// button 3..................................******************************************

        b3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Key for the string that's delivered in the action's intent.
                String replyLabel = "Reply Here";


                // Creates an explicit intent for an Activity in your app
                Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);

                stackBuilder.addParentStack(ResultActivity.class);

                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(
                                0,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );
                // Create the reply action and add the remote input.

                // Add to your action, enabling Direct Reply for it

                // this is adding action on notification..means user can click on this particular text n intent will fire up..
                NotificationCompat.Action action =
                        new NotificationCompat.Action.Builder(R.drawable.fb, replyLabel, resultPendingIntent)
                                .setAllowGeneratedReplies(true)
                                .build();

                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(MainActivity.this)
                                .addAction(action)
                                .setAutoCancel(true)
                                .setSmallIcon(R.drawable.fb)
                                .setContentTitle("This is the example of reply tutorial")
                                .setContentText("no need to say anything..bye hate you");

                mBuilder.setContentIntent(resultPendingIntent);
                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(1, mBuilder.build());
            }
        });
    }
}
