package com.example.TutorialPreferences;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class TutorialPreferences extends Activity {
    /** Called when the activity is first created. */
    public static final String PREFS_NAME = "MyPrefsFile";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean silent = settings.getBoolean("silentMode", false);
        // setSilent(silent);
           CheckBox CheckBox01=(CheckBox) findViewById(R.id.CheckBox01);
        
           CheckBox01.setChecked(silent);
     //   CheckBox CheckBox01=(CheckBox) dialog_StoreInfo.findViewById(R.id.CheckBox01);
        CheckBox01.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                
                

                // Save user preferences. We need an Editor object to
                // make changes. All objects are from android.context.Context
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("silentMode", isChecked);

                // Don't forget to commit your edits!!!
                editor.commit();
            }
        });
        
       
        
    }
}