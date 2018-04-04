package com.dangtin.cookbook.data.models;

/**
 * Created by tinnd on 04/04/2018.
 */

public class LevelDifficult {

    private int level;
    private String title;

    public LevelDifficult(int level, String title) {
        this.level = level;
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
