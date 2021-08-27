package com.example.newsapp.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Adapter.Adapter;
import com.example.newsapp.Model.GetMainObj;
import com.example.newsapp.Model.GetModel;
import com.example.newsapp.Network.GetApi;
import com.example.newsapp.R;
import com.example.newsapp.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Retrofit;

public class HomeFragment extends Fragment {
    private ArrayList<GetModel> getmodel2;
    private GetMainObj getMainObj;
    private Retrofit retrofit;
    private GetApi getApi;
    Adapter adapter;
    String country = "us";
    private RecyclerView recyclerView;
    private MainViewModel mainViewModel;
    String apikey = "02a50775a2fc445bb056fae4a9950bd2";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, null);
        Locale locale = Locale.getDefault();
        country = locale.getCountry();
        recyclerView = v.findViewById(R.id.homer);
        mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        getmodel2 = new ArrayList<GetModel>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        findnews();
        return v;
    }
    private void findnews() {
        mainViewModel.makeApiCall();
        mainViewModel.getMainObjLiveData().observeForever(new Observer<List<GetModel>>() {
            @Override
            public void onChanged(List<GetModel> getModels) {
                adapter.notifyDataSetChanged();
                getmodel2.addAll(getModels);
            }
        });
        adapter = new Adapter(getContext(), getmodel2);
        recyclerView.setAdapter(adapter);
        /*
        RetrofitCall.getApiInterface().getmainobj(country, apikey).enqueue(new Callback<GetMainObj>() {
            @Override
            public void onResponse(Call<GetMainObj> call, Response<GetMainObj> response) {
                if (response.isSuccessful()) {
                    getmodel2.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<GetMainObj> call, Throwable t) {
            }
        });

         */
    }
}