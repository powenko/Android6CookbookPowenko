package com.powenko;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TestFragment extends Fragment {
    private int nAndroids;

    public TestFragment() {

    }

   public TestFragment(int nAndroids) {
                this.nAndroids = nAndroids;
    }

    @Override
    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        if (null != saved) {
                nAndroids = saved.getInt("nAndroids");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle toSave) {
        toSave.putInt("nAndroids", nAndroids);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saved) {
        int n;
        Context c = getActivity().getApplicationContext();
        LinearLayout l = new LinearLayout(c);
        for (n = 0; n < nAndroids; n++) {
                ImageView i = new ImageView(c);
                i.setImageResource(R.drawable.icon);
                l.addView(i);
        }
        return l;
    }
}