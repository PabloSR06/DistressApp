package com.pablosr.distressapp;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.pablosr.distressapp.models.Contact;

import java.util.ArrayList;

public class LaunchActivity extends AppCompatActivity {

    private static LaunchActivity instance;

    private static SQLiteDatabase database;


    public ArrayList<Contact> getContacts(){
        Cursor myCursor = LaunchActivity.getDatabase().rawQuery("select ID, name, phoneNumber from contacts", null);

        ArrayList<Contact> contactList = new ArrayList<Contact>();

        while(myCursor.moveToNext()){
            Contact contact = new Contact();

            contact.setID(myCursor.getInt(0));
            contact.setName(myCursor.getString(1));
            contact.setPhoneNumber(myCursor.getInt(2)+"");
            contactList.add(contact);
        }
        return contactList;
    }


    public static SQLiteDatabase getDatabase(){
        return database;
    }

    public static LaunchActivity getInstance() {
        if (instance == null){
            instance = new LaunchActivity();
        }
        return instance;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                database = openOrCreateDatabase("my.db2", MODE_PRIVATE,null);
                database.execSQL("CREATE TABLE IF NOT EXISTS contacts ( ID INTEGER PRIMARY KEY autoincrement, name VARCHAR(200), phoneNumber INT)");

                startActivity(new Intent(LaunchActivity.this, MainActivity.class));

                finish();
            }
        }, 0);




    }
}