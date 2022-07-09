package com.pablosr.distressapp.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.pablosr.distressapp.LaunchActivity;
import com.pablosr.distressapp.MainActivity;
import com.pablosr.distressapp.R;
import com.pablosr.distressapp.listadapter.ContactsViewAdapter;

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

        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(getApplicationContext(), EditContact.class));

            }
        });

    }
}