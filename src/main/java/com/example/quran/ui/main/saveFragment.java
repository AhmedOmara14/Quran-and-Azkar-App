package com.example.quran.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quran.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class saveFragment extends Fragment {
   private tabaccess_save tabaccess_save;
   private View view;
   private ViewPager viewPager;
   private TabLayout tabLayout;
    public saveFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_save, container, false);
        intialization();
        return view;
    }
    public void intialization(){
        viewPager=view.findViewById(R.id.view_pager);
        tabLayout=view.findViewById(R.id.tabLayout2);
        tabaccess_save= new tabaccess_save(getChildFragmentManager());
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(tabaccess_save);

    }
}
