package com.example.anusha.pushnotification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pushbots.push.Pushbots;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends Activity {
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    TextView message,author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pushbots.sharedInstance().init(this);
        Pushbots.sharedInstance().setCustomHandler(CustomHandler.class);

        Bundle extras = getIntent().getExtras();
        // extras.getString("YOUR_CUSTOM_FIELD");
        message = (TextView) findViewById(R.id.message);
        author = (TextView) findViewById(R.id.author);


        if (null != extras && getIntent().getExtras().containsKey("message")) {
            // && getIntent().getExtras().containsKey("author")) {

            message.setText(extras.getString("message"));
            Calendar c2 = Calendar.getInstance();
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String date = sdf2.format(c2.getTime());

           author.setText(date);

        }
    }



        public void addMessage(View view)
        {
            Calendar c1 = Calendar.getInstance();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strdate1 = sdf1.format(c1.getTime());
        String message_view = message.getText().toString();
       // String author_view = author.getText().toString();
        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userDbHelper.addInformations(message_view,strdate1,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Message Saved",Toast.LENGTH_LONG).show();
        userDbHelper.close();
        }


    public void viewMessage(View view)
    {
        Intent intent = new Intent(this,DataListActivity.class);
        startActivity(intent);
    }


}



