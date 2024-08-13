package com.example.quiz;

public class CategoryModels {
    private String CategoryId, CategoryName, CategoryImage;

    public CategoryModels(String categoryId, String categoryName, String categoryImage) {
        CategoryId = categoryId;
        CategoryName = categoryName;
        CategoryImage = categoryImage;
    }

    public CategoryModels(){

    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryImage() {
        return CategoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        CategoryImage = categoryImage;
    }
}
