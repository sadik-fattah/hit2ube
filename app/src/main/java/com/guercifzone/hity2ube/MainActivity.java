package com.guercifzone.hity2ube;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
TextView txturl,txtquality,txtformat;
EditText editText;
Button btn,btnrefresh;
    @SuppressLint("MissingInflatedId")
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
        txturl = (TextView) findViewById(R.id.url);
        txtquality = (TextView) findViewById(R.id.quality);
        txtformat = (TextView) findViewById(R.id.format);
        editText = (EditText) findViewById(R.id.link);
        btn = (Button) findViewById(R.id.dwnd);
        btnrefresh = (Button) findViewById(R.id.refresh);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadurl();
            }
        });
        btnrefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Refresh();
            }
        });

if(editText.getText().toString().isEmpty()){
    Toast.makeText(this, "enter youtube link", Toast.LENGTH_SHORT).show();
    btn.setVisibility(View.GONE);
}else {
    btn.setVisibility(View.VISIBLE);
    Toast.makeText(this, "plaese wait", Toast.LENGTH_LONG).show();
}
    }

    private void Refresh() {
        txturl.setText("");
        txtquality.setText("");
        txtformat.setText("");
        editText.setText("");

    }

    private void loadurl() {
        try {
            //https://www.youtube.com/shorts/ZTS3YLjI0XE"
            VideoDownloader.getInstance().getResults(this, editText.getText().toString(), new OnVideoFoundListener() {
                @Override
                public void onVideo(ArrayList<VideoLink> videos) {
                    for (int i = 0; i < videos.size(); i++) {
                        Log.e("size:", videos.get(i).isAudioAvailable() + " server url --> " + videos.get(i).getQuality() + " quality : " + videos.get(i).getUrl());
                        txturl.setText(videos.get(i).getUrl());
                        txturl.setTextColor(Color.BLUE);
                        txtquality.setText("Quality :"+videos.get(i).getQuality());
                        txtformat.setText("Format :"+videos.get(i).getFormat());

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