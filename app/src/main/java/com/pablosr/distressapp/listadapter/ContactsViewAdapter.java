package com.pablosr.distressapp.listadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pablosr.distressapp.R;
import com.pablosr.distressapp.models.Contact;
import java.util.ArrayList;

public class ContactsViewAdapter extends ArrayAdapter<Contact> {

    private ArrayList<Contact> arrayList;

    public ContactsViewAdapter(@NonNull Context context, ArrayList<Contact> arrayList) {
        super(context, 0, arrayList);
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.contact_list, parent, false);
        }

        Contact currentNumberPosition = getItem(position);


        TextView contact_name = currentItemView.findViewById(R.id.nameText);
        contact_name.setText(currentNumberPosition.getName());


        TextView contact_phone = currentItemView.findViewById(R.id.phoneText);
        contact_phone.setText(currentNumberPosition.getPhoneNumber());


        return currentItemView;
    }

    public ArrayList<Contact> getData() {
        return arrayList;
    }
}
