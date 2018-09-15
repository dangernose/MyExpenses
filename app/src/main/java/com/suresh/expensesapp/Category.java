package com.suresh.expensesapp;

public class Category {
    private Integer categoryId;
    private String categoryName;
    private int categoryicon;



    public Category(Integer categoryId, String categoryName, int categoryicon) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryicon = categoryicon;
    }

    public Category(String categoryName, int categoryicon) {
        this.categoryName = categoryName;
        this.categoryicon = categoryicon;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryicon() {
        return categoryicon;
    }

    public void setCategoryicon(int categoryicon) {
        this.categoryicon = categoryicon;
    }
}
