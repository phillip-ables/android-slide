package com.example.techtron.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPagerSlide;
    LinearLayout linearLayoutDot;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPagerSlide = (ViewPager) findViewById(R.id.viewPagerSlide);
        linearLayoutDot = (LinearLayout) findViewById(R.id.linearLayoutDot);

        sliderAdapter = new SliderAdapter(this);

        viewPagerSlide.setAdapter(sliderAdapter);
    }

    public void addDotsIndicator(){

        mDots = new TextView[3];

        for(int i =0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            

        }
    }
}
