package com.example.utsmcs.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utsmcs.Adapter.HistoryAdapter;
import com.example.utsmcs.Adapter.HomeAdapter;
import com.example.utsmcs.Database.TicketHelper;
import com.example.utsmcs.Home;
import com.example.utsmcs.Model.Article;
import com.example.utsmcs.Model.Ticket;
import com.example.utsmcs.R;

import java.util.ArrayList;
import java.util.Vector;

public class HistoryFragment extends Fragment {

    RecyclerView rv;
    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewrv = inflater.inflate(R.layout.fragment_history,container,false);
        rv = viewrv.findViewById(R.id.rv_history);
        RecyclerView rv = viewrv.findViewById(R.id.rv_history);
        TicketHelper db = new TicketHelper(getContext());
        Vector<Ticket>tickets1 = db.filterTicket(Home.currId);
        HistoryAdapter adph = new HistoryAdapter(getContext(),tickets1);
        rv.setAdapter(adph);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        System.out.println(tickets1.get(0).getTicketId());

        return viewrv;
    }
}