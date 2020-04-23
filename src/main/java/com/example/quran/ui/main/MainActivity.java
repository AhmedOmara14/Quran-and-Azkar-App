package com.example.quran.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.example.quran.R;
import com.example.quran.databinding.ActivityMainBinding;
import com.example.quran.ui.ayes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        SystemClock.sleep(2000);

        Intent intent=new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);

    }
}
