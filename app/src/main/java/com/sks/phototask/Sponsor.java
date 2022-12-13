package com.sks.phototask;

public class Sponsor {

//      "id": "kSlnstJTnY8",
//              "updated_at": "2022-12-10T21:33:44Z",
//              "username": "windows",
//              "name": "Windows",
//              "first_name": "Windows",
//              "last_name": null,
//              "twitter_username": "windows",
//              "portfolio_url": "https://www.windows.com",
//              "bio": "Makes the everyday easier.",
//              "location": null,
//              "links":


    String id;
    String username;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Sponsor(String id, String username) {
        this.id = id;
        this.username = username;
    }
}
