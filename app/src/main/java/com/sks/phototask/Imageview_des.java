package com.sks.phototask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Imageview_des extends AppCompatActivity {
    TextView username;
    ImageView profileimage,backpress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview_des);
        username = findViewById(R.id.textView6);
        String text = getIntent().getStringExtra("descr");
        username.setText(text);
        profileimage = findViewById(R.id.imageView3);
        String imageurl = getIntent().getStringExtra("imagebanner");
        Glide.with(this)
                .load(imageurl)
                .into(profileimage);
      backpress = findViewById(R.id.imageViewBackarrow);
        backpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Imageview_des.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}