package com.dangtin.cookbook.data.models;

/**
 * Created by tinnd on 03/04/2018.
 */

public class Featured {

    private int id;
    private String image;

    public Featured(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
