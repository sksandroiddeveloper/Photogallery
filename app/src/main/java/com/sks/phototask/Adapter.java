package com.sks.phototask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context mContext;
    private List<Created> sponsorList;


    public Adapter(Context mContext, List<Created> sponsorList) {
        this.mContext = mContext;
        this.sponsorList = sponsorList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.photoitem_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        if (sponsorList.get(position) != null && sponsorList.get(position).getSponsorship() != null) {
        holder.id.setText(sponsorList.get(position).getUser().getName());
        Glide.with(mContext).load(sponsorList.get(position).getUser().getProfile_image().getMedium()).into(holder.imgview);
        Glide.with(mContext).load(sponsorList.get(position).getUrls().getRegular()).into(holder.imageView2);
        holder.textView2.setText(sponsorList.get(position).getAlt_description());


//holder.id.setText(sponsorList.get(position).);

        //click listener
        holder.imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   Toast.makeText(mContext, sponsorList.get(position).getUser().getName()+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, ProfileImage.class);
                intent.putExtra("name", sponsorList.get(position).getUser().getName());
                intent .putExtra("image",sponsorList.get(position).getUser().getProfile_image().getMedium());
                intent.putExtra("bio",sponsorList.get(position).getUser().getBio());
                intent.putExtra("location",sponsorList.get(position).getUser().getLocation());
                mContext.startActivity(intent);
            }
        });
holder.imageView2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, Imageview_des.class);
        intent.putExtra("descr", sponsorList.get(position).getAlt_description());
        intent .putExtra("imagebanner",sponsorList.get(position).getUrls().getRegular());
        mContext.startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return sponsorList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, textView2;
        ImageView imgview, imageView2;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView);
            imgview = itemView.findViewById(R.id.imageView);
            imageView2 = itemView.findViewById(R.id.imageView3);
            textView2 = itemView.findViewById(R.id.textView2);

        }
    }

}
