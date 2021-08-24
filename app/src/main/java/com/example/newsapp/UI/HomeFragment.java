package com.example.newsapp.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.Adapter.Adapter;
import com.example.newsapp.Network.GetApi;
import com.example.newsapp.Network.RetrofitCall;
import com.example.newsapp.R;
import com.example.newsapp.Model.getMainObj;
import com.example.newsapp.Model.getModel;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {
    private ArrayList<getModel> getmodel2;
    private com.example.newsapp.Model.getMainObj getMainObj;
    private Retrofit retrofit;
    private GetApi getApi;
    Adapter adapter;
    String country = "us";
    private RecyclerView recyclerView;
    String apikey = "02a50775a2fc445bb056fae4a9950bd2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, null);
        Locale locale=Locale.getDefault();
        country=locale.getCountry();
        recyclerView = v.findViewById(R.id.homer);
        getmodel2 = new ArrayList<getModel>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        findnews();
        adapter = new Adapter(getContext(), getmodel2);
        recyclerView.setAdapter(adapter);
        return v;
    }

    private void findnews() {
        RetrofitCall.getApiInterface().getmainobj(country, apikey).enqueue(new Callback<getMainObj>() {
            @Override
            public void onResponse(Call<getMainObj> call, Response<getMainObj> response) {
                if (response.isSuccessful()) {
                    getmodel2.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<getMainObj> call, Throwable t) {
            }
        });

    }
}