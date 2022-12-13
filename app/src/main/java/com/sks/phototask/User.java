package com.sks.phototask;

public class User {
    private Profile_image profile_image;

//    id	:	iuRJS3ktB0o
//    updated_at	:	2022-12-11T23:09:50Z
//    username	:	vork
//    name	:	Mark Boss
//    first_name	:		Mark
//    last_name	:	Boss
//    twitter_username	:	markb_boss
//    portfolio_url	:	https://markboss.me
//    bio	:	PhD. Student in the area of machine learning and hobby photographer. Also drone pilot in training and coffee enthusiast.
//    location	:	Tübingen, Germany


    String name;
    String bio;
    String location ;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Profile_image getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(Profile_image profile_image) {
        this.profile_image = profile_image;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
