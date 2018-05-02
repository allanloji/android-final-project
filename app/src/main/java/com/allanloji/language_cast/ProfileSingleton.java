package com.allanloji.language_cast;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class ProfileSingleton {
    private static ProfileSingleton profileInstance;
    private String name, city, biography;
    private ArrayList<String> languages;

    private ProfileSingleton(){
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
}
