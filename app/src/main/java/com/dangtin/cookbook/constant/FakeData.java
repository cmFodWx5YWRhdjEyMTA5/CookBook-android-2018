package com.dangtin.cookbook.constant;

import android.content.Context;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.data.models.Admob;
import com.dangtin.cookbook.data.models.Category;
import com.dangtin.cookbook.data.models.Featured;
import com.dangtin.cookbook.data.models.Food;
import com.dangtin.cookbook.data.models.HomeObject;
import com.dangtin.cookbook.data.models.KeywordHot;
import com.dangtin.cookbook.data.models.LevelDifficult;
import com.dangtin.cookbook.data.models.MaterialFood;
import com.dangtin.cookbook.data.models.Menu;
import com.dangtin.cookbook.data.models.News;
import com.dangtin.cookbook.data.models.QuantityFood;
import com.dangtin.cookbook.data.models.SearchHistory;

import java.util.ArrayList;

/**
 * Created by tinnd on 02/04/2018.
 */

public class FakeData {

    public static ArrayList<Category> getListCategory() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1,"Món Xào"));
        categories.add(new Category(2,"Món Canh"));
        categories.add(new Category(3,"Món Chiên"));
        categories.add(new Category(4,"Món Nướng"));
        categories.add(new Category(5,"Món Kho"));
        categories.add(new Category(6,"Món Nộm"));
        categories.add(new Category(7,"Món Bánh"));
        categories.add(new Category(8,"Món Tráng Miệng"));

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

        ArrayList<Admob> listAdmob = new ArrayList<>();
        listAdmob.add(new Admob());
        list.add(new HomeObject(HomeObject.TYPE_ADMOB, listAdmob));

        for (int i = 0; i < getListCategory().size(); i++) {
            list.add(new HomeObject(HomeObject.TYPE_CATEGORY, getListCategory().get(i).getName(), null, listFood));
        }

        list.add(new HomeObject(HomeObject.TYPE_ADMOB, listAdmob));

        return list;
    }

    public static ArrayList<Menu> getListMenu() {
        ArrayList<Menu> listMenu = new ArrayList<>();
        listMenu.add(new Menu());
        listMenu.add(new Menu());
        listMenu.add(new Menu());
        listMenu.add(new Menu());
        listMenu.add(new Menu());
        listMenu.add(new Menu());

        return listMenu;
    }

    public static ArrayList<QuantityFood> getListQuantityFood() {
        ArrayList<QuantityFood> list = new ArrayList<>();
        list.add(new QuantityFood(2));
        list.add(new QuantityFood(3));
        list.add(new QuantityFood(4));
        list.add(new QuantityFood(5));

        return list;
    }

    public static ArrayList<LevelDifficult> getListLevelDifficult() {
        ArrayList<LevelDifficult> list = new ArrayList<>();
        list.add(new LevelDifficult(1, "Dễ"));
        list.add(new LevelDifficult(2, "Trung bình"));
        list.add(new LevelDifficult(3, "Khó"));

        return list;
    }

    public static ArrayList<Food> getListFood() {
        ArrayList<Food> listMenu = new ArrayList<>();
        listMenu.add(new Food());
        listMenu.add(new Food());
        listMenu.add(new Food());
        listMenu.add(new Food());
        listMenu.add(new Food());
        listMenu.add(new Food());
        listMenu.add(new Food());
        listMenu.add(new Food());
        listMenu.add(new Food());
        listMenu.add(new Food());

        return listMenu;
    }

    public static ArrayList<MaterialFood> getListMaterialFood() {
        ArrayList<MaterialFood> list = new ArrayList<>();
        list.add(new MaterialFood("Thịt gà"));
        list.add(new MaterialFood("Thịt bò"));
        list.add(new MaterialFood("Trứng"));
        list.add(new MaterialFood("Bắp cải"));
        list.add(new MaterialFood("Hành"));
        list.add(new MaterialFood("Rau ngải cứu"));

        return list;
    }

    public static ArrayList<KeywordHot> getListKeywordHot() {
        ArrayList<KeywordHot> list = new ArrayList<>();
        list.add(new KeywordHot(1,"Thit ga"));
        list.add(new KeywordHot(2,"Suon sao"));
        list.add(new KeywordHot(3,"Ca kho"));
        list.add(new KeywordHot(4,"Hanh"));
        list.add(new KeywordHot(5,"Thuc don ngon"));
        list.add(new KeywordHot(6,"Che Buoi"));
        list.add(new KeywordHot(7,"Bo"));
        list.add(new KeywordHot(8,"Cach nau che"));
        list.add(new KeywordHot(9,"Tom Chien"));
        list.add(new KeywordHot(10,"Muc"));

        return list;
    }

    public static ArrayList<SearchHistory> getListSearchHistory() {
        ArrayList<SearchHistory> list = new ArrayList<>();
        list.add(new SearchHistory("Thit ga hap xa"));
        list.add(new SearchHistory("Tom chien"));
        list.add(new SearchHistory("Thi bo xao rau can"));
        list.add(new SearchHistory("Ca hap bia"));
        list.add(new SearchHistory("Che thap cam"));
        list.add(new SearchHistory("O mai khe"));
        list.add(new SearchHistory("Vit om gieng, sau, me"));
        list.add(new SearchHistory("Ca chep om dua"));
        list.add(new SearchHistory("Oc xoa sa uot"));
        list.add(new SearchHistory("Ech om sau"));

        return list;
    }

    public static ArrayList<News> getListNews() {
        ArrayList<News> list = new ArrayList<>();
        list.add(new News(1, "Dining out associated with increased exposure",
                "New study finds burgers and other foods consumed at restaurants," +
                        " fast food outlets or cafeterias", "11/04/2018 17:24"));
        list.add(new News(2, "Dining out associated with increased exposure",
                "New study finds burgers and other foods consumed at restaurants," +
                        " fast food outlets or cafeterias", "11/04/2018 17:24"));
        list.add(new News(3, "Dining out associated with increased exposure",
                "New study finds burgers and other foods consumed at restaurants," +
                        " fast food outlets or cafeterias", "11/04/2018 17:24"));
        list.add(new News(4, "Dining out associated with increased exposure",
                "New study finds burgers and other foods consumed at restaurants," +
                        " fast food outlets or cafeterias", "11/04/2018 17:24"));
        list.add(new News(5, "Dining out associated with increased exposure",
                "New study finds burgers and other foods consumed at restaurants," +
                        " fast food outlets or cafeterias", "11/04/2018 17:24"));


        return list;
    }
}
