package com.example.newsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.UI.WebView;
import com.example.newsapp.Model.GetModel;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<GetModel> getmodel;
    public Adapter(Context context, ArrayList<GetModel> getmodel) {
        this.context  =  context;
        this.getmodel =  getmodel;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layoiut_item, null, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(context, WebView.class);
              intent.putExtra("url",getmodel.get(position).getUrl());
              context.startActivity(intent);
            }
        });
        holder.mtime.setText("Published at:"+getmodel.get(position).getPublishedAt());
        holder.mauthor.setText(getmodel.get(position).getAuthor());
        holder.mheading.setText(getmodel.get(position).getTitle());
        holder.mcontent.setText(getmodel.get(position).getContent());
        Glide.with(context).load(getmodel.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {

        return getmodel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mheading, mcontent, mauthor, mtime;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading = itemView.findViewById(R.id.mainheading);
            mcontent = itemView.findViewById(R.id.contextmain);
            mauthor = itemView.findViewById(R.id.author);
            mtime = itemView.findViewById(R.id.time12);
            imageView = itemView.findViewById(R.id.image12);
            cardView = itemView.findViewById(R.id.cardview);


        }
    }
}
