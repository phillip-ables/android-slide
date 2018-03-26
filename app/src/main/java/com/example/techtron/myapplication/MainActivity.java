package com.example.techtron.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPagerSlide;
    LinearLayout linearLayoutDot;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button buttonNext, buttonPrev;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPagerSlide = (ViewPager) findViewById(R.id.viewPagerSlide);
        linearLayoutDot = (LinearLayout) findViewById(R.id.linearLayoutDot);

        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonPrev = (Button ) findViewById(R.id.buttonPrevious);

        sliderAdapter = new SliderAdapter(this);

        viewPagerSlide.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        viewPagerSlide.addOnPageChangeListener(viewListener);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPagerSlide.setCurrentItem(currentPage++);
            }
        });
        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPagerSlide.setCurrentItem(currentPage--);
            }
        });
    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        linearLayoutDot.removeAllViews();

        for(int i =0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            linearLayoutDot.addView(mDots[i]);
        }

        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            currentPage = position;

            if(position == 0){
                buttonNext.setEnabled(true);
                buttonPrev.setEnabled(false);
                buttonPrev.setVisibility(View.INVISIBLE);

                buttonNext.setText("Next");
                buttonPrev.setText("");
            } else if ( position == mDots.length -1) {
                buttonNext.setEnabled(true);
                buttonPrev.setEnabled(true);
                buttonPrev.setVisibility(View.VISIBLE);

                buttonNext.setText("Finish");
                buttonPrev.setText("Back");
            }else {
                buttonNext.setEnabled(true);
                buttonPrev.setEnabled(true);
                buttonPrev.setVisibility(View.VISIBLE);

                buttonNext.setText("Next");
                buttonPrev.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
