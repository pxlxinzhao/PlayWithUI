package com.patrickpu.test.playwithui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.patrickpu.test.playwithui.R;

public class MainFrag extends Fragment implements MainActivity.MainFragBase{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void changeColor(boolean isDark) {
        ((TextView)getView().findViewById(R.id.textToPink)).setTextColor(getResources().getColor(isDark ? R.color.colorDark : R.color.colorPink));
    }

}