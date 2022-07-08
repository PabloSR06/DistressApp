package com.pablosr.distressapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.pablosr.distressapp.listadapter.ContactsViewAdapter;
import com.pablosr.distressapp.models.Contact;

import java.util.ArrayList;

public class UserContacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_contacts);

        Button newContact = findViewById(R.id.newContact);

        newContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(UserContacts.this, NewContact.class);
                startActivity(intent);
            }
        });


        ContactsViewAdapter contactAdapter = new ContactsViewAdapter(this, LaunchActivity.getInstance().getContacts());

        ListView contactList = findViewById(R.id.list);

        contactList.setAdapter(contactAdapter);

    }
}