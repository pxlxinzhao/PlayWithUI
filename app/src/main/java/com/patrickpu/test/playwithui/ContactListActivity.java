package com.patrickpu.test.playwithui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ContactListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        ListView list = findViewById(R.id.contactList);
        ListAdapter adapter = new ContactAdpater(this,R.layout.contact_row);
        list.setAdapter(adapter);
    }
}
