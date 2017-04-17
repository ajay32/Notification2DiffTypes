package com.hackingbuzz.notification2difftypes;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by navneet on 3/12/16.
 */

public class ResultActivity extends AppCompatActivity {



    // mRequestCode allows you to update the notification.
    int mRequestCode = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);



        String returnMessage = "Thank you";

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_stat_toggle_check_box)
                        .setContentText(returnMessage);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //update notification
        mNotificationManager.notify(mRequestCode, mBuilder.build());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}
