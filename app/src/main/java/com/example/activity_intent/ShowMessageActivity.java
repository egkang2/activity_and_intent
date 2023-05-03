package com.example.activity_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowMessageActivity extends AppCompatActivity {
    TextView textViewShowMessage;
    TextView textViewXpos;
    TextView textViewYpos;
    Button gobacktomap;
    Intent backtomap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);
        textViewShowMessage = findViewById(R.id.textViewShowMessage);
        textViewXpos = findViewById(R.id.textViewXpos);
        textViewYpos = findViewById(R.id.textViewYpos);
        gobacktomap=findViewById(R.id.gobacktomap);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Log.d("MyApp", "뭐가 문제냐 대체?: " + bundle);
        if (bundle != null) {
            String str = bundle.getString("Data #1");
            textViewShowMessage.setText(str);

            Float posX = bundle.getFloat("X pos");
            textViewXpos.setText(String.valueOf(posX));

            Float posY = bundle.getFloat("Y pos");
            textViewYpos.setText(String.valueOf(posY));
        } else {
            // Handle the case when bundle is null
        }
        gobacktomap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backtomap = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(backtomap);

            }
        });




    }


}
