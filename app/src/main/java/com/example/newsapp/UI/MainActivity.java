package com.example.newsapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toolbar;

import com.example.newsapp.Adapter.PageAdapter;
import com.example.newsapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private TabItem home, sport, entertainment, science, tech, health;
    private PageAdapter pageAdapter;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //retrofitbuilder();
        //toolbar=(Toolbar)findViewById(R.id.toolbar12);
        //setSupportActionBar(toolbar);
        home = findViewById(R.id.home1);
        sport = findViewById(R.id.home2);
        health = findViewById(R.id.home3);
        science = findViewById(R.id.home4);
        entertainment = findViewById(R.id.home5);
        tech = findViewById(R.id.home6);
        viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout=findViewById(R.id.include);
        pageAdapter=new PageAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pageAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5){
                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    /*
    private void retrofitbuilder() {
       Gson gson=new GsonBuilder().setLenient().create();
       retrofit=new Retrofit.Builder().baseUrl(getBaseurl).addConverterFactory(GsonConverterFactory.create(gson)).build();
       GetApi getApi=retrofit.create(GetApi.class);
        //Call<getMainObj> call=getApi.getmainobj();
    }

     */

}
