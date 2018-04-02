/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/02/22
 * ******************************************************************************
 */

package com.dangtin.cookbook.data.models.response;

import com.dangtin.cookbook.data.models.Category;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoryResponse {

    @SerializedName("data")
    private ArrayList<Category> listCategory;

    public ArrayList<Category> getListCategory() {
        return listCategory;
    }

    public void setListCategory(ArrayList<Category> listCategory) {
        this.listCategory = listCategory;
    }
}
