package com.allanloji.language_cast.pojo;

/**
 * Created by allan on 10/04/18.
 */

public class Event {
    private String imageID;
    private String title;
    public String date;
    private String description;


    public Event(String imageID, String description) {
        this.imageID = imageID;
        this.description = description;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
