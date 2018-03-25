package com.example.techtron.myapplication;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

   public SliderAdapter(Context context) {
       this.context = context;
   }

   //Arrays
    public int[] slide_images = {
           R.drawable.dumb_bob,
           R.drawable.patrick,
           R.drawable.sponge_moy
   };
   public String[] slide_headings  = {
           "DUMB BOB",
           "EVIL PATRICK",
           "MOI MI OI"
   };
   public String[] slide_description = {
           "boss:*kills me for the 20th time & takes me back to the unskippable cutscene before the battle* \nboss: You're finally here \nme: UrFiNaLlY hErE",
           "When I kick Ice under the Fridge",
           "when you're in an 11 minute cartoon in 2004 and you randomly get teleported into aninternet trend in 2016"

   };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }
    //to inflate all of the view inside the adapter
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imageView= (ImageView) view.findViewById( R.id.imageView);
        TextView textViewHeading = (TextView) view.findViewById( R.id.textViewHeader);
        TextView textViewDescription = (TextView) view.findViewById( R.id.textViewDescription);

        imageView.setImageResource(slide_images[position]);
        textViewHeading.setText(slide_headings[position]);
        textViewDescription.setText(slide_description[position]);

        container.addView(view);

        return view;
    }
}
