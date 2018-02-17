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

public class MainActivity extends LoggingActivity implements SecondFragment.OnFragmentInteractionListener{

    String FRAG_TAG = "main_frag";
    String FRAG_INDEX = "frag_index";
    int fragIndex = 2;
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
                if (fragIndex == 1){
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

        swapFragment();
    }

    //called by change fragment button
    public void changeFragment(View view){
        swapFragment();
    }

    private void swapFragment(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (fragIndex == 1){
            SecondFragment secondFragment = SecondFragment.newInstance("patrick", "pu");
            fragmentTransaction.replace(R.id.frag_container, secondFragment);
            fragIndex = 2;
        }else if(fragIndex == 2){
            MainFrag mainFrag = new MainFrag();
            fragmentTransaction.replace(R.id.frag_container, mainFrag);
            fragIndex = 1;
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(FRAG_INDEX, fragIndex);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        fragIndex = 3 - savedInstanceState.getInt(FRAG_INDEX);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onPostResume() {
        swapFragment();
        super.onPostResume();
    }
}
