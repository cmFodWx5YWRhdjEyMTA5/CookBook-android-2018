package com.dangtin.cookbook.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.data.models.Category;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {

    private ArrayList<Category> listCategory;
    private LayoutInflater inflater;

    public CategoryAdapter(Activity act, ArrayList<Category> list) {
        this.listCategory = list;
        inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        try {
            return listCategory.size();
        } catch (NullPointerException ex) {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_category, null);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Category category = listCategory.get(position);
        if (category != null) {
            holder.tvTitle.setText(category.getName());
        }

        return convertView;
    }

    class ViewHolder {
        private TextView tvTitle;
    }
}
