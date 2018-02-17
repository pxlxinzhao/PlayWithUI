package com.patrickpu.test.playwithui;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements SecondFragment.OnFragmentInteractionListener{

    String FRAG_TAG = "main_frag";
    Fragment currentFragment = null;
    ToggleButton tb;
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
                if (currentFragment instanceof MainFrag){
                    ((MainFrag) currentFragment).changeColor(!tb.isChecked());
                }
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

        MainFrag mainFrag = new MainFrag();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frag_container, mainFrag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void changeFragment(View view){
        Log.v(FRAG_TAG, "function gets called");
//        Toast.makeText(this, "OMG", Toast.LENGTH_SHORT).show();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (currentFragment instanceof MainFrag){
            SecondFragment secondFragment = SecondFragment.newInstance("patrick", "pu");
            fragmentTransaction.replace(R.id.frag_container, secondFragment);
        }else if(currentFragment instanceof SecondFragment){
            MainFrag mainFrag = new MainFrag();
            fragmentTransaction.replace(R.id.frag_container, mainFrag);
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.v(FRAG_TAG, "Attaching fragment");
        currentFragment = fragment;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public interface MainFragBase{
        void changeColor(boolean isDark);
    }
}
