package com.pablosr.distressapp.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.pablosr.distressapp.LaunchActivity;
import com.pablosr.distressapp.MainActivity;
import com.pablosr.distressapp.R;
import com.pablosr.distressapp.listadapter.ContactsViewAdapter;
import com.pablosr.distressapp.models.Contact;

import java.util.ArrayList;

public class UserContacts extends AppCompatActivity {

    private ContactsViewAdapter contactAdapter;
    private static UserContacts instance;


    public static UserContacts getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_contacts);
        instance = this;

        Button newContact = findViewById(R.id.newContact);
        ListView contactList = findViewById(R.id.list);


        newContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(UserContacts.this, NewContact.class);
                startActivity(intent);
            }
        });


        contactAdapter = new ContactsViewAdapter(this, LaunchActivity.getInstance().getContacts());

        contactList.setAdapter(contactAdapter);

        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(getApplicationContext(), EditContact.class));

            }
        });

    }

    public void reloadAllData(){
        // get new modified random data
        ArrayList<Contact> objects = LaunchActivity.getInstance().getContacts();
        // update data in our adapter
        contactAdapter.getData().clear();
        contactAdapter.getData().addAll(objects);
        // fire the event
        contactAdapter.notifyDataSetChanged();
    }
}