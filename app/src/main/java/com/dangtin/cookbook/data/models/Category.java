/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/02/01
 * ******************************************************************************
 */

package com.dangtin.cookbook.data.models;

import com.google.gson.annotations.SerializedName;

public class Category {

    private int id;

    @SerializedName("keisuke_name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
