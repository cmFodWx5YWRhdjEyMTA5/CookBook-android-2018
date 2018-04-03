package com.dangtin.cookbook.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.data.models.Featured;
import com.dangtin.cookbook.utils.GlideUtils;

import java.util.ArrayList;

/**
 * Created by tinnd on 03/04/2018.
 */

public class FeaturedPagerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<Featured> mListFeatured;

    public FeaturedPagerAdapter(Context context, ArrayList<Featured> mListData) {
        this.mContext = context;
        this.mListFeatured = mListData;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Featured featured = mListFeatured.get(position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.item_featured, container, false);
        ImageView imgFeatured = (ImageView) layout.findViewById(R.id.image_featured);
        GlideUtils.loadUrl(featured.getImage(), imgFeatured);
        container.addView(layout);
        return layout;
    }

    @Override
    public int getCount() {
        return mListFeatured.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
