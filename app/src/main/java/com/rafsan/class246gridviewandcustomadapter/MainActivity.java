package com.rafsan.class246gridviewandcustomadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList < HashMap < String, String > > arrayList = new ArrayList<>();
    HashMap < String,String > hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
    //------------- (Calling) Method-----------
        createTable();

        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);

    }
    //==================== Custom Adapter=================
    public class MyAdapter extends BaseAdapter{
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        @Override
        public int getCount() {
            return arrayList.size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View myView = layoutInflater.inflate(R.layout.items,parent,false);

            TextView textTitleName = myView.findViewById(R.id.textTitleName);
            ImageView imageView = myView.findViewById(R.id.imageView);

            HashMap < String,String > hashMap = arrayList.get(position);

            String titleName = hashMap.get("Title");
            String simage = hashMap.get("Image URL");
            String sDescription = hashMap.get("Description");

            textTitleName.setText(titleName);
        //------------ PICASSO---------------
            Picasso.get()
                    .load(simage)
                    .placeholder(R.drawable.img)
                    .into(imageView);
        //====== Random color==========
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            textTitleName.setBackgroundColor(color);

            CardView myCardView = myView.findViewById(R.id.myCardView);

            myCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    NewsDetails.TITLE = titleName;
                    NewsDetails.DESCRIPTION = sDescription;

                    Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                    NewsDetails.MY_BITMAP = bitmap;

                    startActivity(new Intent(MainActivity.this, NewsDetails.class));
                }
            });

            return myView  ;
        }
    }

   //=======================Method/Function====================

    private void createTable(){

        hashMap = new HashMap<>();
        hashMap.put("Title","Memorable 13 of the 13th World Cup");
        hashMap.put("Image URL","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/media/api_images/2023/11/19/World%20Cup%20story.jpg");
        hashMap.put("Description","The 13th edition of the ICC Men's ODI World Cup came to a close with Australia beating hosts India by five wickets in the final at the Narendra Modi Stadium in Ahmedabad yesterday. With the showpiece event in the rearview mirror, The Daily Star Sports looks at 13 moments that mesmerised the fans in the past 46 days.\n" +
                "\n" +
                "Kohli's 50th 100\n" +
                "\n" +
                "Undoubtedly, it was superstar Virat Kohli who provided the best moment when he surpassed his idol Sachin Tendulkar's record of 49 ODI tons in the semifinal against New Zealand in Mumbai. Tendulkar applauded from the stands as Kohli reached his 50th ODI ton in just his 277th innings. Kohli (765 runs in 11 matches) also became the first player to cross the 700-run mark in a single edition of the World Cup.\n" +
                "\n" +
                "Maxwell 201 not out\n" +
                "\n" +
                "To pull Australia out from the cusp of defeat at 91 for seven, Glenn Maxwell played one of the best innings the format has ever witnessed in Mumbai. Withstanding cramps and the scoreboard pressure, Maxwell smashed a 128-ball 201 as he singlehandedly saw the Aussies chase down the 291-run target.\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Title","Ranbir Kapoor and Rashmika Mandanna’s Animal trailer to release on THIS date\n" +
                "\n");
        hashMap.put("Image URL","https://filmfare.wwmindia.com/content/2023/nov/animal41700470428.jpg");
        hashMap.put("Description","Sandeep Reddy Vanga's upcoming film, Animal, has been generating immense buzz since its announcement, becoming one of the most anticipated releases of the year. The star-studded cast including Ranbir Kapoor, Anil Kapoor, Rashmika Mandanna, Bobby Deol, and Triptii Dimri has heightened excitement for its release.\n" +
                "\n" +
                "\n" +
                "Recently, Sandeep Reddy Vanga took to Instagram to unveil the long-awaited trailer release date. He announced, \"Trailer on Nov 23rd,\" with a monochromatic picture of himself with Ranbir Kapoor.\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Title","World's richest 1% emit as much carbon as bottom two-thirds: report");
        hashMap.put("Image URL","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2023/11/20/emission.jpg");
        hashMap.put("Description","The richest one percent of the global population are responsible for the same amount of carbon emissions as the world's poorest two-thirds, or five billion people, according to an analysis published Sunday by the non-profit Oxfam International.\n" +
                "\n" +
                "While fighting the climate crisis is a shared challenge, not everyone is equally responsible and government policies must be tailored accordingly, Max Lawson, who co-authored the report, told AFP.\n" +
                "\n" +
                "\"The richer you are, the easier it is to cut both your personal and your investment emissions,\" he said. \"You don't need that third car, or that fourth holiday, or you don't need to be invested in the cement industry.\"\n" +
                "\n" +
                "\"Climate Equality: A Planet for the 99%\", was based on research compiled by the Stockholm Environment Institute (SEI) and it examined the consumption emissions associated with different income groups up to the year 2019.\n");
        arrayList.add(hashMap);

    }
}