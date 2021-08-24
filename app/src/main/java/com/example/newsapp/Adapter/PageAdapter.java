package com.example.newsapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newsapp.UI.EntertainmentFragment;
import com.example.newsapp.UI.HealthFragment;
import com.example.newsapp.UI.HomeFragment;
import com.example.newsapp.UI.ScienceFragment;
import com.example.newsapp.UI.SportFragment;
import com.example.newsapp.UI.TechFragment;

public class PageAdapter extends FragmentPagerAdapter {
    private int tabcount;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new SportFragment();
            case 2:
                return new HealthFragment();
            case 3:
                return new ScienceFragment();

            case 4:
                return new EntertainmentFragment();
            case 5:
                return new TechFragment();
            default:
                return null;
        }

    }
    @Override
    public int getCount() {
        return tabcount;
    }
}
