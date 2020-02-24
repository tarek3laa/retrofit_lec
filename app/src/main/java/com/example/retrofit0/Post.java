package com.example.retrofit0;

public class Post {

    private int userId, id;
    private String title, body;

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }


    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }



    public String getBody() {
        return body;
    }


}
