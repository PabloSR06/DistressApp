package com.pablosr.distressapp;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);


        Button saveContact = findViewById(R.id.saveContact);
        saveContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ContentValues row = new ContentValues();
                row.put("name", "Nuevo");
                row.put("phoneNumber","33333333");
                LaunchActivity.getDatabase().insert("contacts", null, row);

                Toast.makeText(getApplicationContext(), R.string.contact_saved, Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(),UserContacts.class));
            }
        });
    }
}