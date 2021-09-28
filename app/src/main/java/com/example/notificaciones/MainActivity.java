package com.example.notificaciones;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class MainActivity extends AppCompatActivity {

    private Button btnNotificaciones, btnNuevaNotificacion,btnGrupoNotificaciones;

    private final static String Channel_ID="Notificación";
    public final static int  Notification_ID =0;
    private PendingIntent AbrirpendingIntent;
    private static final String KEY_TEXT_REPLY = "key_text_reply";



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnNuevaNotificacion = findViewById(R.id.button2);
        btnNuevaNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotificationChannel();
                crearNuevaNotificacion();
            }
        });

        btnNotificaciones = findViewById(R.id.button);
        btnNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotificationChannel();
                setAbrirpendingIntent();
                crearNotificacion();

            }


        });

    }

    private void crearNuevaNotificacion() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), Channel_ID)
                .setSmallIcon(R.drawable.ic_baseline_message_24)
                .setContentTitle("OF Gaby")
                .setContentText("hola jessica como estas?")
                .setColor(Color.GRAY)
                .setVibrate(new long[]{1000,1000,1000,1000})
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(AbrirpendingIntent);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(Notification_ID, builder.build());

    }

    private void setAbrirpendingIntent(){
        Intent intent = new Intent( this, AbrirNotificacion.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(AbrirNotificacion.class);
        stackBuilder.addNextIntent(intent);
        AbrirpendingIntent = stackBuilder.getPendingIntent(1,AbrirpendingIntent.FLAG_UPDATE_CURRENT);

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notification";
            NotificationChannel notificationChannel = new NotificationChannel(Channel_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void crearNotificacion() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), Channel_ID)
                .setSmallIcon(R.drawable.ic_baseline_directions_run_24)
                .setContentTitle("Notificacion Ejercicio")
                .setContentText("Trotaste 7 kilimetros en una hora")
                .setColor(Color.GREEN)
                .setVibrate(new long[]{1000,1000,1000,1000})
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(AbrirpendingIntent)
                .addAction(R.drawable.ic_baseline_directions_run_24,"ABRIR",AbrirpendingIntent);



        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
            notificationManagerCompat.notify(Notification_ID, builder.build());



    }



}
