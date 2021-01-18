package com.nevco.appa.Controller;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import com.nevco.appa.R;

public class MainActivity extends AppCompatActivity implements MyListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
        startActivityForResult(intent, 101);
        new NotificationService().setListener(this);

    }

    @Override
    public void setValue(String packageName) {
        storeData(packageName);
    }

    public void storeData(String dataToBeSent) {

        // class to add values in the database
        ContentValues values = new ContentValues();
        values.put(ContentProvider.name, dataToBeSent);
        getContentResolver().insert(ContentProvider.CONTENT_URI, values);

    }


}






