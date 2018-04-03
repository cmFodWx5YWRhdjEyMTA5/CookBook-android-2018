package com.dangtin.cookbook.constant;

import android.content.Context;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.data.models.Category;
import com.dangtin.cookbook.data.models.Featured;
import com.dangtin.cookbook.data.models.Food;
import com.dangtin.cookbook.data.models.HomeObject;
import com.dangtin.cookbook.data.models.Menu;

import java.util.ArrayList;

/**
 * Created by tinnd on 02/04/2018.
 */

public class FakeData {

    public static ArrayList<Category> getListCategory() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("Món Xào"));
        categories.add(new Category("Món Canh"));
        categories.add(new Category("Món Chiên"));
        categories.add(new Category("Món Nướng"));
        categories.add(new Category("Món Kho"));
        categories.add(new Category("Món Nộm"));
        categories.add(new Category("Món Bánh"));
        categories.add(new Category("Món Tráng Miệng"));

        return categories;
    }

    public static ArrayList<Featured> getListFeatured() {
        ArrayList<Featured> list = new ArrayList<>();
        list.add(new Featured("http://stg2.passp.asia/assets/brands/c1f2a8eebad0d792be86959eb0587743.jpg"));
        list.add(new Featured("http://stg2.passp.asia/assets/brands/518fdf2a064a050a975daeaf69eda2b3.jpg"));
        list.add(new Featured("http://stg2.passp.asia/assets/brands/8737325e3fbeb0125958fd0e8b1d772f.jpg"));

        return list;
    }

    public static ArrayList<HomeObject> getListHomeObject(Context context) {
        ArrayList<HomeObject> list = new ArrayList<>();

        ArrayList<Menu> listMenu = new ArrayList<>();
        listMenu.add(new Menu());
        listMenu.add(new Menu());
        listMenu.add(new Menu());
        list.add(new HomeObject(HomeObject.TYPE_MENU_LATEST,
                context.getString(R.string.title_menu_latest), listMenu, null));

        ArrayList<Food> listFood = new ArrayList<>();
        listFood.add(new Food());
        listFood.add(new Food());
        listFood.add(new Food());
        listFood.add(new Food());
        list.add(new HomeObject(HomeObject.TYPE_FOOD_LATEST,
                context.getString(R.string.title_food_latest), null, listFood));

        return list;
    }
}
