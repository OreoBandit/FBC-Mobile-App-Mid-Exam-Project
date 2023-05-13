package com.example.utsmcs.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utsmcs.Adapter.HomeAdapter;
import com.example.utsmcs.Adapter.ScheduleAdapter;
import com.example.utsmcs.Home;
import com.example.utsmcs.Model.Article;
import com.example.utsmcs.Model.Schedule;
import com.example.utsmcs.R;

import java.util.ArrayList;

public class ScheduleFragment extends Fragment {

    RecyclerView rv;
    ArrayList<Schedule> matches = new ArrayList<>();

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewrv = inflater.inflate(R.layout.fragment_schedule,container,false);
        rv = viewrv.findViewById(R.id.rv_schedule);
        RecyclerView rv = viewrv.findViewById(R.id.rv_schedule);
        ScheduleAdapter ads = new ScheduleAdapter(getContext(),matches, Home.currId);

        if(matches.isEmpty()){
            Schedule match1 = new Schedule("FBC VS Chelsea","Chelsea", "15 May 2023","https://static.toiimg.com/photo/msid-77325472/77325472.jpg" ,"M001","Rp. 50.000");
            Schedule match2 = new Schedule("FBC VS Man Utd","Man Utd", "23 May 2023", "https://static.toiimg.com/photo/msid-77325472/77325472.jpg","M002","Rp. 50.000");
            matches.add(match1);
            matches.add(match2);
        }

        rv.setAdapter(ads);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


        return viewrv;
    }
}