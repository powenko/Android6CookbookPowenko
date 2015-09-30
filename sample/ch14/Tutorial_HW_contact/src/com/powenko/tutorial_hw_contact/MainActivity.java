package com.powenko.tutorial_hw_contact;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;


public class MainActivity extends Activity {

	//textView1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(GetContacts());
    }
    public StringBuffer GetContacts(){
    	Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
        String _ID = ContactsContract.Contacts._ID;
        String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
        String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;
       
        Uri PhoneCONTENT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String Phone_CONTACT_ID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
        String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
        
        Uri EmailCONTENT_URI =  ContactsContract.CommonDataKinds.Email.CONTENT_URI;
        String EmailCONTACT_ID = ContactsContract.CommonDataKinds.Email.CONTACT_ID;
        String DATA = ContactsContract.CommonDataKinds.Email.DATA;
 
        StringBuffer output = new StringBuffer();
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(CONTENT_URI, null,null, null, null); 
   
        if (cursor.getCount() > 0) {  
            while (cursor.moveToNext()) { 
               String contact_id = cursor.getString(cursor.getColumnIndex( _ID ));
               String name = cursor.getString(cursor.getColumnIndex( DISPLAY_NAME ));
               int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex( HAS_PHONE_NUMBER )));
               if (hasPhoneNumber > 0) {
                   output.append("\n First Name:" + name);
                   Cursor phoneCursor = contentResolver.query(PhoneCONTENT_URI, null, Phone_CONTACT_ID + " = ?", new String[] { contact_id }, null);       
                   while (phoneCursor.moveToNext()) {
                      String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER));
                      output.append("\n Phone number:" + phoneNumber);
                   } 
                   phoneCursor.close();
                   Cursor emailCursor = contentResolver.query(EmailCONTENT_URI,    null, EmailCONTACT_ID+ " = ?", new String[] { contact_id }, null);
                   while (emailCursor.moveToNext()) {
                     String  email = emailCursor.getString(emailCursor.getColumnIndex(DATA));
                     output.append("\nEmail:" + email);
                   }
                   emailCursor.close();
                   output.append("\n");
               }
            }
        }
         return output;
    }
}
