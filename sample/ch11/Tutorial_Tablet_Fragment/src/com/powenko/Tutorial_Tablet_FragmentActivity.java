package com.powenko;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Tutorial_Tablet_FragmentActivity extends Activity implements OnItemClickListener {
    /** 呼叫一啟動時，會呼叫的函數onCreate */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView l = (ListView) findViewById(R.id.number_list);
        ArrayAdapter numbers = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        new String [] {
                "one", "two", "three", "four", "five", "six"
        });
        l.setAdapter(numbers);
        l.setOnItemClickListener(this);
    }


    /**
     * 傳遞資料到Fragment 上。
     */
    private void stackAFragment(int nAndroids) {
        Fragment f = new TestFragment(nAndroids);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.the_frag, f);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }

        /**
         *  按像選項是，所產生的觸發事件
         */
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                stackAFragment(position + 1);
        }
}