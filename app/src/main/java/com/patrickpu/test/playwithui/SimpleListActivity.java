package com.patrickpu.test.playwithui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SimpleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        ListView listView = (ListView) findViewById(R.id.simpleList);
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, DataService.getInstance().getSentences());
        listView.setAdapter(adapter);

    }
}
