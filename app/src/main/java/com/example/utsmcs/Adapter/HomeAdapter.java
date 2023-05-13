package com.example.utsmcs.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utsmcs.Model.Article;
import com.example.utsmcs.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.DataHolder> {
    List<Article>news;
    LayoutInflater inflater;
    Context ctx;

    public HomeAdapter(Context context, List<Article> news) {
        this.news = (ArrayList<Article>) news;
        this.ctx = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HomeAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_item_news, parent, false);
//        View view = LayoutInflater.from(ctx).inflate(R.layout.activity_item_news,parent,false);
        return new DataHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        holder.judul.setText(news.get(position).getJudul());
        holder.subJudul.setText(news.get(position).getSubjudul());
        holder.tanggal.setText(news.get(position).getNewsTanggal());
        Picasso.get().load(news.get(position).getImgLink()).fit().centerCrop().into(holder.gambar);
    }


    @Override
    public int getItemCount() {
        return news.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder{
        TextView judul, subJudul, tanggal;
        ImageView gambar;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.newsJudul);
            subJudul = itemView.findViewById(R.id.newsSubJudul);
            gambar = itemView.findViewById(R.id.newsImg);
            tanggal = itemView.findViewById(R.id.newsDate);
        }
    }
}



