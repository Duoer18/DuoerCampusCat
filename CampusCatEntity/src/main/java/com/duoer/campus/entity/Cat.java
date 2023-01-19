package com.duoer.campus.entity;

public class Cat {
    private Integer catId;
    private String catName;
    private Integer categoryId;
    private String category;
    private Integer colorId;
    private String color;
    private Integer characterId;
    private String character;
    private Integer locationId;
    private String location;
    private Integer recordCount;
    private String username;

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer category_id) {
        this.categoryId = category_id;
//        this.category = NormalAttributesExchanger.categoryMap.get(category_id);
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
//        this.color = NormalAttributesExchanger.colorMap.get(colorId);
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
//        this.character = NormalAttributesExchanger.characterMap.get(characterId);
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
//        this.location = NormalAttributesExchanger.locationMap.get(locationId);
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catId=" + catId +
                ", catName='" + catName + '\'' +
                ", categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", colorId=" + colorId +
                ", color='" + color + '\'' +
                ", characterId=" + characterId +
                ", character='" + character + '\'' +
                ", locationId=" + locationId +
                ", location='" + location + '\'' +
                ", recordCount=" + recordCount +
                ", username='" + username + '\'' +
                '}';
    }
}
