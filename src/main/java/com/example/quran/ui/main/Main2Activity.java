package com.example.quran.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quran.R;
import com.example.quran.databinding.ActivityMain2Binding;
import com.google.android.material.tabs.TabLayout;

public class Main2Activity extends AppCompatActivity {
    private tabaccess tabaccess;
    private ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding= DataBindingUtil.setContentView(this,R.layout.activity_main2);
        intialzation();
             binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                 @Override
                 public void onTabSelected(TabLayout.Tab tab) {
                     String num=tab.getPosition()+"";
                     if (num.equals("0")) {
                         tab.setIcon(R.drawable.ic_bookmark_black_24dp);
                     }
                     else if(num.equals("1")){
                         tab.setIcon(R.drawable.ic_book_black_24dp);
                     }
                     else {
                         tab.setIcon(R.drawable.ic_library_books_black_24dp);
                     }
                 }

                 @Override
                 public void onTabUnselected(TabLayout.Tab tab) {
                     String num=tab.getPosition()+"";
                     if (num.equals("0")) {
                         tab.setIcon(R.drawable.ic_bookmark_border_black_24dp);
                     }
                     else if(num.equals("1")){
                         tab.setIcon(R.drawable.ic_book_black_versiom2);
                     }
                     else {
                         tab.setIcon(R.drawable.ic_library_books_black_versin2);
                     }
                 }

                 @Override
                 public void onTabReselected(TabLayout.Tab tab) {
                     String num=tab.getPosition()+"";
                     if (num.equals("0")) {
                         tab.setIcon(R.drawable.ic_bookmark_black_24dp);
                     }
                     else if(num.equals("1")){
                         tab.setIcon(R.drawable.ic_book_black_24dp);
                     }
                     else {
                         tab.setIcon(R.drawable.ic_library_books_black_24dp);
                     }
                 }
             });
    }
    public void intialzation(){
        tabaccess=new tabaccess(getSupportFragmentManager());
        binding.viewpager.setAdapter(tabaccess);
        binding.tabLayout.setupWithViewPager(binding.viewpager);
        binding.tabLayout.selectTab(binding.tabLayout.getTabAt(0));
        binding.tabLayout.selectTab(binding.tabLayout.getTabAt(0).setIcon(R.drawable.ic_bookmark_border_black_24dp));
        binding.tabLayout.selectTab(binding.tabLayout.getTabAt(1).setIcon(R.drawable.ic_book_black_versiom2));
        binding.tabLayout.selectTab(binding.tabLayout.getTabAt(2).setIcon(R.drawable.ic_library_books_black_versin2));

    }
}
