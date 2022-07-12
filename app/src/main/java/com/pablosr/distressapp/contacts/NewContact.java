package com.pablosr.distressapp.contacts;

import android.Manifest;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pablosr.distressapp.LaunchActivity;
import com.pablosr.distressapp.MainActivity;
import com.pablosr.distressapp.R;

import org.w3c.dom.Text;

public class NewContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);


        Button saveContact = findViewById(R.id.saveContact);
        EditText newName = (EditText) findViewById(R.id.newName);
        EditText newPhone = (EditText) findViewById(R.id.newPhone);

        saveContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ContentValues row = new ContentValues();
                row.put("name", newName.getText().toString());
                row.put("phoneNumber", newPhone.getText().toString());
                LaunchActivity.getDatabase().insert("contacts", null, row);

                Toast.makeText(getApplicationContext(), R.string.contact_saved, Toast.LENGTH_SHORT).show();

                UserContacts.getInstance().reloadAllData();
                finish();
            }
        });
    }


}