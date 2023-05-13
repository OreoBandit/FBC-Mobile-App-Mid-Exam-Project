package com.example.utsmcs.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utsmcs.Adapter.HomeAdapter;
import com.example.utsmcs.Model.Article;
import com.example.utsmcs.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView rv;
    ArrayList<Article> news = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewrv = inflater.inflate(R.layout.fragment_home,container,false);
        rv = viewrv.findViewById(R.id.rv_news);
        RecyclerView rv = viewrv.findViewById(R.id.rv_news);
        HomeAdapter adpHome = new HomeAdapter(getContext(),news);

        if(news.isEmpty()){
            Article news1 = new Article("FBC comeback!","https://phantom-marca.unidadeditorial.es/2fb1d3b863c33b7fff69c8a173752187/resize/1200/f/jpg/assets/multimedia/imagenes/2022/11/25/16694129388697.jpg","FBC comeback","10 April 2023");
            Article news2 = new Article("FBC IS CHAMPION","https://img.olympicchannel.com/images/image/private/t_s_pog_staticContent_hero_xl/f_auto/primary/ydk9vatpnihwfquy6zq3", "FBC berhasil meraih piala dunia","18 April 2023");
            news.add(news1);
            news.add(news2);
        }


        rv.setAdapter(adpHome);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


        return viewrv;
    }
}