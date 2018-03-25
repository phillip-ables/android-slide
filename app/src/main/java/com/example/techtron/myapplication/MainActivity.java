package com.example.techtron.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPagerSlide;
    LinearLayout linearLayoutDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPagerSlide = (ViewPager) findViewById(R.id.viewPagerSlide);
        linearLayoutDot = (LinearLayout) findViewById(R.id.linearLayoutDot);
    }
}
