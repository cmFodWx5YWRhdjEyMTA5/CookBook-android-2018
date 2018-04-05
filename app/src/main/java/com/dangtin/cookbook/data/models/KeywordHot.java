package com.dangtin.cookbook.data.models;

/**
 * Created by tinnd on 05/04/2018.
 */

public class KeywordHot {

    private int id;
    private String keyword;

    public KeywordHot(int id, String keyword) {
        this.id = id;
        this.keyword = keyword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
