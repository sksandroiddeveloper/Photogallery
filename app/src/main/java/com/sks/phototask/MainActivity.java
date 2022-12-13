package com.sks.phototask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Created> sponsorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);


        sponsorList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.unsplash.com/").addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);
        Call<List<Created>> call = api.getsponser();
        call.enqueue(new Callback<List<Created>>() {
            @Override
            public void onResponse(Call<List<Created>> call, Response<List<Created>> response) {
                if (response.code() != 200) {
                    return;
                }
                List<Created> Sponsors = response.body();
                for (Created sponser : Sponsors) {
                   // if (sponser.getSponsorship() != null)
//
//
//                    String responsetest = "";
//                    responsetest +=sponser.getId();
//                    Log.v("Tag",""+responsetest);
                        sponsorList.add(sponser);
                }
                Putdataintorecyclerlist(sponsorList);

            }

            @Override
            public void onFailure(Call<List<Created>> call, Throwable t) {

            }
        });
    }

    private void Putdataintorecyclerlist(List<Created> sponsorList) {

        Adapter adapter = new Adapter(this, sponsorList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


}