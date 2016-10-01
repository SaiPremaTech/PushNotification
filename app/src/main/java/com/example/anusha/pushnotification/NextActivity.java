package com.example.anusha.pushnotification;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Bundle extras = getIntent().getExtras();
       // extras.getString("YOUR_CUSTOM_FIELD");

        if(null!=extras && getIntent().getExtras().containsKey("message") && getIntent().getExtras().containsKey("author")){
            TextView message = (TextView)findViewById(R.id.message);
            TextView author = (TextView)findViewById(R.id.author);
            message.setText(extras.getString("message"));
            //author.setText(extras.getString("author"));

        }
    }
}
