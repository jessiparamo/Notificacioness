package com.example.notificaciones;

import static com.example.notificaciones.MainActivity.Notification_ID;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

public class AbrirNotificacion extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abrir_notificacion);

        NotificationManagerCompat notificationManagerCompat= NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.areNotificationsEnabled();
        notificationManagerCompat.cancel(Notification_ID);

    }


}
