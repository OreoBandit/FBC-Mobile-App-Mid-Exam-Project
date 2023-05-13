package com.example.utsmcs.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utsmcs.Database.TicketHelper;
import com.example.utsmcs.Fragments.ScheduleFragment;
import com.example.utsmcs.Home;
import com.example.utsmcs.Model.Article;
import com.example.utsmcs.Model.Schedule;
import com.example.utsmcs.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.DataHolder> {
    List<Schedule>matches;
    LayoutInflater inflater;
    Context ctx;
    Integer currId;

    public ScheduleAdapter(Context context, ArrayList<Schedule> matches, Integer currId) {
        this.matches = matches;
        this.ctx = context;
        this.currId = currId;
//        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ScheduleAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.activity_item_schedule, parent, false);
        View view = inflater.from(ctx).inflate(R.layout.activity_item_schedule,parent,false);
        return new DataHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {

        holder.judulMatch.setText(matches.get(position).getMatchname());
        holder.tanggal.setText(matches.get(position).getMatchDate());
        holder.harga.setText(matches.get(position).getHarga());
        Picasso.get().load(matches.get(position).getImgLink()).fit().into(holder.gambar);
        //BUY TICKET
        holder.buyticket.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TicketHelper db = new TicketHelper(v.getContext());
                db.insertTicket(matches.get(holder.getAdapterPosition()).getMatchDate(), matches.get(holder.getAdapterPosition()).getMatchname(), matches.get(holder.getAdapterPosition()).getImgLink(),currId);
                Toast.makeText(v.getContext(), "successfully bought ticket!",Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return matches.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder{
        TextView judulMatch, tanggal, harga;
        Button buyticket;
        ImageView gambar;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            buyticket = itemView.findViewById(R.id.btnBuy);
            judulMatch = itemView.findViewById(R.id.matchJudul);
            tanggal = itemView.findViewById(R.id.matchDate);
            harga = itemView.findViewById(R.id.matchHarga);
            gambar = itemView.findViewById(R.id.matchImg);
        }
    }
}



