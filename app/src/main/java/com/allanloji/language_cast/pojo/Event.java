package com.allanloji.language_cast.pojo;

/**
 * Created by allan on 10/04/18.
 */

public class Event {
    private int imageID;
    private String title;
    public String date;
    private String description;

    public Event() {
    }

    public Event(int imageID, String title) {
        this.imageID = imageID;
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
