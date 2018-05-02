package com.allanloji.language_cast.pojo;

public class News {
    private String image;
    private String title;
    public String date;
    private String description;
    private String direction;

    public News(String image, String title, String date, String description, String direction) {
        this.image = image;
        this.title = title;
        this.date = date;
        this.description = description;
        this.direction = direction;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
