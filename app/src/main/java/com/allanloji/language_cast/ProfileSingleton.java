package com.allanloji.language_cast;

import android.content.Context;

import com.allanloji.language_cast.pojo.News;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.facebook.AccessToken;

import java.util.ArrayList;
import java.util.List;

public class ProfileSingleton {
    private static ProfileSingleton profileInstance;
    private String name, city, biography, photo, email;
    private ArrayList<String> languages;
    private AccessToken accessToken;
    private ArrayList<News> historyList;

    private ProfileSingleton(){
        historyList = new ArrayList<>();
    }

    public synchronized static void createProfileInstance(){
        if(profileInstance == null){
            profileInstance = new ProfileSingleton();
        }
    }

    public static ProfileSingleton getInstance() {
        createProfileInstance();;

        return profileInstance;
    }

    public static ProfileSingleton getProfileInstance() {
        return profileInstance;
    }

    public static void setProfileInstance(ProfileSingleton profileInstance) {
        ProfileSingleton.profileInstance = profileInstance;
    }

    public ArrayList<News> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(ArrayList<News> historyList) {
        this.historyList = historyList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
