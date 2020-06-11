package com.example.mycoffeet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] images = new int[]{
            R.drawable.coffeecof,
            R.drawable.locatcofee,
            R.drawable.searchplace,
            R.drawable.joinus
    };

    public String[] headings = {
            "COFFEE",
            "WHEREVER YOU GO",
            "BE A PART",
            "JOIN US"
    };

    public  String[] descs = {
            "To all the coffee lovers around the country, we provide almost all the numbers of the coffee shops registered with us.",
            "You can search any place  nearby or with-in the specified city. We will display specific or all related shops to match your search.",
            "If you have a shop or somethings and want to be a part of our growing industry then add your place by following simple steps.",
            "We will handle everything for you. As you have the app in your pocket then you don't have to worry about anything."

    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject( View view, Object o) {
        return view == (ConstraintLayout) o ;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.images);
        TextView slideHeading = (TextView) view.findViewById(R.id.headings);
        TextView slideDescription = (TextView) view.findViewById(R.id.descs);

        slideImageView.setImageResource(images[position]);
        slideHeading.setText(headings[position]);
        slideDescription.setText(descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout)object);
    }

}
