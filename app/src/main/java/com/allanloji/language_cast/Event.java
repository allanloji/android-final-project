package com.allanloji.language_cast;

/**
 * Created by allan on 10/04/18.
 */

public class Event {
    private int imageID;
    private String title;
    private String description;

    public Event() {
    }

    public Event(int imageID, String title) {
        this.imageID = imageID;
        this.title = title;
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
