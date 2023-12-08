package com.rafsan.class246gridviewandcustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewsDetails extends AppCompatActivity {

    ImageView coverImage;
    TextView textTITLE,textDESCRIPTION;

    FloatingActionButton floatButton;


    public  static String TITLE = "";
    public  static String DESCRIPTION = "";

    public static Bitmap MY_BITMAP = null;


    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_details);


        coverImage = findViewById(R.id.coverImage);
        textTITLE = findViewById(R.id.textTITLE);
        textDESCRIPTION = findViewById(R.id.textDESCRIPTION);
        floatButton = findViewById(R.id.floatButton);

        textTITLE.setText(TITLE);
        textDESCRIPTION.setText(DESCRIPTION);



        if (MY_BITMAP != null){

            coverImage.setImageBitmap(MY_BITMAP);

        }

        textToSpeech = new TextToSpeech(NewsDetails.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });

        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = textDESCRIPTION.getText().toString();

                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null,null);

            }
        });

    }
}