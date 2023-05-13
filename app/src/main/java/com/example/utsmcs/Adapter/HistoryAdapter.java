package com.example.utsmcs.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utsmcs.Database.TicketHelper;
import com.example.utsmcs.Model.Ticket;
import com.example.utsmcs.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Vector;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.DataHolder> {
    List<Ticket>tickets;
    LayoutInflater inflater;
    Context ctx;

    public HistoryAdapter(Context context, Vector<Ticket> tickets) {
        this.tickets = tickets;
        this.ctx = context;
    }

    @NonNull
    @Override
    public HistoryAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.from(ctx).inflate(R.layout.activity_item_ticket,parent,false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        //MASUK2IN DATA
        TicketHelper db = new TicketHelper(holder.itemView.getContext());
        holder.judulMatch.setText(tickets.get(position).getMatchName());
        holder.tanggal.setText(tickets.get(position).getMatchDate());
        holder.username.setText(tickets.get(position).getUsername());
        Picasso.get().load(tickets.get(position).getImgUrl()).fit().into(holder.gambar);
    }


    @Override
    public int getItemCount() {
        return tickets.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder{
        TextView judulMatch, tanggal, username;
        ImageView gambar;


        public DataHolder(@NonNull View itemView) {
            super(itemView);
            judulMatch = itemView.findViewById(R.id.matchName);
            tanggal = itemView.findViewById(R.id.matchDate);
            username = itemView.findViewById(R.id.username);
            gambar = itemView.findViewById(R.id.matchImg);
        }
    }
}



