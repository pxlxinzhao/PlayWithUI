package com.patrickpu.test.playwithui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity{

    String FRAG_TAG = "main_frag";
    MainFrag currentFragment = null;
    ToggleButton tb = null;
    Button simpleBtn, contactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleBtn = findViewById(R.id.goSimple);
        contactBtn = findViewById(R.id.goContact);

        tb = (ToggleButton) findViewById(R.id.goPinkBtn);
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(FRAG_TAG, String.valueOf(tb.isChecked()));
                currentFragment.changeColor(!tb.isChecked());
            }
        });

        simpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SimpleListActivity.class));
            }
        });

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ContactListActivity.class));
            }
        });
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.v(FRAG_TAG, "Attaching fragment");
        currentFragment = (MainFrag) fragment;
    }

    public interface MainFragBase{
        void changeColor(boolean isDark);
    }
}
