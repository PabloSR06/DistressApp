package com.pablosr.distressapp;

import android.Manifest;
import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pablosr.distressapp.contacts.UserContacts;
import com.pablosr.distressapp.models.Contact;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        Button sendMessage = findViewById(R.id.sendMessage);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) { ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS,}, 1000);
            Toast.makeText(getApplicationContext(), "aaa.", Toast.LENGTH_LONG).show();

        }else{
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, UserContacts.class);

                    startActivity(intent);
                }
            });

            sendMessage.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    ArrayList<Contact> contacts = LaunchActivity.getInstance().getContacts();
                    for (Contact x: contacts) {
                        try {
                            SmsManager sms = SmsManager.getDefault();
                            sms.sendTextMessage(x.getPhoneNumber(), null, "hola", null, null);
                            Toast.makeText(getApplicationContext(), "Mensaje Enviado.", Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Mensaje no enviado, datos incorrectos.", Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}