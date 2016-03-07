package com.sandstorm.softspec.mini_trello.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Zen on 2/27/16.
 */
public class Card implements Serializable {

    private String title;
    private String description;
    private static long id = 1;
    private Date date;
    private final String currentCreatedTime;
    private List<Comment> commentList;


    public Card(String title , String description){
        this.title = title;
        this.description = description;
        date = new Date();
        currentCreatedTime = date.toLocaleString();
        commentList = new ArrayList<Comment>();
        id++;

    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return id == card.getId();


    }

    public static long getId() {
        return id;
    }

    public String getCreatedTime(){
        return currentCreatedTime;

    }

    public List<Comment> getCommentList(){
        return commentList;
    }

    public void addComment(String message){
        commentList.add(new Comment(message));
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
