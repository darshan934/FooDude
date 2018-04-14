package com.example.darshan.foodude.Model;

import android.provider.MediaStore;

import java.util.jar.Attributes;

/**
 * Created by darshan on 28/3/18.
 */

public class Category {

    private String Name, Image;

    public Category(){

    }

    public  Category(String name, String image){
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
