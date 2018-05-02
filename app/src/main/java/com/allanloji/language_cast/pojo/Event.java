package com.allanloji.language_cast.pojo;

/**
 * Created by allan on 10/04/18.
 */

public class Event {
    private String imageID;
    private String title;
    public String date;
    private String description;
    private String post_url;
    private String id;

    public Event(String imageID, String description, String post_url) {
        this.imageID = imageID;
        this.description = description;
        this.post_url = post_url;
    }

    public Event(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPost_url() {
        return post_url;
    }

    public void setPost_url(String post_url) {
        this.post_url = post_url;
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
