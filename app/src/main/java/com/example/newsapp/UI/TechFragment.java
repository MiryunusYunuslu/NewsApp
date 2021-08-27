package com.example.newsapp.UI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Adapter.Adapter;
import com.example.newsapp.Model.GetModel;
import com.example.newsapp.R;
import com.example.newsapp.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;
public class TechFragment extends Fragment {
    private ArrayList<GetModel> getmodel2;
    private Adapter adapter;
    private RecyclerView recyclerView;
    private MainViewModel mainViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tech, null);
        recyclerView = v.findViewById(R.id.techer);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getmodel2 = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        findnews();
        return v;
    }
    private void findnews() {
        String category = "technology";
        mainViewModel.makeApiCallForCategories(category);
        mainViewModel.getMainObjLiveData().observeForever(new Observer<List<GetModel>>() {
            @Override
            public void onChanged(List<GetModel> getModels) {
                getmodel2.addAll(getModels);
                adapter = new Adapter(getContext(), getmodel2);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }
}

