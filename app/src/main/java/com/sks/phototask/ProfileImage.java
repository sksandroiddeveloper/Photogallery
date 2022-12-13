package com.sks.phototask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProfileImage extends AppCompatActivity {
TextView username,bio,location;
ImageView profileimage,backpress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_image);
        username = findViewById(R.id.textView3);
        bio =findViewById(R.id.textView5);
        location = findViewById(R.id.textView4);
        backpress = findViewById(R.id.imageViewBackarrow);
        backpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileImage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        String name_text = getIntent().getStringExtra("name");
        username.setText(name_text);
        String biography = getIntent().getStringExtra("bio");
        bio.setText(biography);
        String locations = getIntent().getStringExtra("location");
        location.setText(locations);
        profileimage = findViewById(R.id.imageView);
        String imageurl = getIntent().getStringExtra("image");
        Glide.with(this)
                .load(imageurl)
                .into(profileimage);


    }
}