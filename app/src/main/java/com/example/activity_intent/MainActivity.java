package com.example.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button buttonImplicitIntent;
    Button buttonExplicitIntent;

    ImageView imageViewMap;
    float posX, posY;
    Intent intent;

    Intent movetogps;
    Intent movetocall;
    Bitmap mapbitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewMap = findViewById(R.id.imageViewMap);
        buttonImplicitIntent = findViewById(R.id.buttonImplictIntent);
        buttonExplicitIntent = findViewById(R.id.buttonexplictIntent);

        mapbitmap= BitmapFactory.decodeResource(getResources(), R.drawable.map);
        Bitmap resizedclearly = Bitmap.createScaledBitmap(mapbitmap, 1000, 1000, false);//공통적인 요소들을 넣을 것들은 배열로 정리하는 습관을 가지자
        mapbitmap = resizedclearly;
        imageViewMap.setImageBitmap(mapbitmap);

        imageViewMap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Bundle bundle = new Bundle();
                posX = motionEvent.getX();
                posY = motionEvent.getY();
                movetogps=new Intent(getApplicationContext(),ShowMessageActivity.class);
                movetogps.putExtra("X pos", posX);
                movetogps.putExtra("Y pos", posY);
                bundle.putString("Data #1", "Test Message");
                bundle.putFloat("X pos", posX);
                movetogps.putExtras(bundle);

                startActivity(movetogps);



                return false;
            }
        });

        buttonImplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Intent.ACTION_VIEW);
                Uri uri  = Uri.parse("http://www.naver.com");
                intent.setData(uri);
                startActivity(intent);
            }
        });
        buttonExplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movetocall = new Intent(Intent.ACTION_CALL);
                Uri uri2  = Uri.parse("tel:01071754994");
                movetocall.setData(uri2);
                startActivity(movetocall);
            }
        });



    }
}