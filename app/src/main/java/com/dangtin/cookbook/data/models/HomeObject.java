package com.dangtin.cookbook.data.models;

import java.util.ArrayList;

/**
 * Created by tinnd on 03/04/2018.
 */

public class HomeObject {

    public static final int TYPE_MENU_LATEST = 0;
    public static final int TYPE_FOOD_LATEST = 1;
    public static final int TYPE_CATEGORY = 2;
    public static final int TYPE_ADMOB = 3;

    private int type;
    private String title;
    private ArrayList<Menu> listMenu;
    private ArrayList<Food> listFood;

    public HomeObject(int type, String title, ArrayList<Menu> listMenu, ArrayList<Food> listFood) {
        this.type = type;
        this.title = title;
        this.listMenu = listMenu;
        this.listFood = listFood;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Menu> getListMenu() {
        return listMenu;
    }

    public void setListMenu(ArrayList<Menu> listMenu) {
        this.listMenu = listMenu;
    }

    public ArrayList<Food> getListFood() {
        return listFood;
    }

    public void setListFood(ArrayList<Food> listFood) {
        this.listFood = listFood;
    }
}
