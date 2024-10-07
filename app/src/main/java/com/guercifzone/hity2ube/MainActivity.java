package com.guercifzone.hity2ube;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.guercifzone.hity2ube.Lib.OnVideoFoundListener;
import com.guercifzone.hity2ube.Lib.VideoDownloader;
import com.guercifzone.hity2ube.Lib.VideoLink;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
   try {
       //VideoDownloader.getInstance().getResults(this, "https://www.youtube.com/shorts/ZTS3YLjI0XE", new OnVideoFoundListener() {
       VideoDownloader.getInstance().getResults(this, "https://www.youtube.com/watch?v=vyqQRczjMoQ", new OnVideoFoundListener() {
           @Override
           public void onVideo(ArrayList<VideoLink> videos) {
               for (int i = 0; i < videos.size(); i++) {
                   Log.e("size", videos.get(i).isAudioAvailable() + " " + videos.get(i).getQuality() + "adf  " + videos.get(i).getUrl());

               }
           }

           @Override
           public void onError(String error) {
               Log.e("size", error);
           }
       });

   }catch (Exception e){
       e.printStackTrace();
   }
    }
}