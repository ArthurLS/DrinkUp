package com.example.mathieu.databasetest;

/**
 * Created by Mathieu on 30/04/2017.
 */

public class Card {
    private long id ;
    String name ;
    Integer img;

    public Card(){} ;

    public Card(String name, Integer img){
        this.name = name ;
        this.img = img;
    }
    public void setName (String name){
        this.name = name ;
    }
    public String getName(){
        return this.name ;
    }

    public void setId (long id){
        this.id = id ;
    }
    public long getId(){
        return this.id ;
    }

    public void setImage(Integer img){ this.img = img; }
    public Integer getImage(){ return this.img; }
}
