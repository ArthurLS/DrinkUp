package com.example.mathieu.databasetest;

/**
 * Created by Mathieu on 30/04/2017.
 */

public class Rule {

    private long id ;
    String name ;
    String description ;

    public Rule(){} ;

    public Rule(String name, String description){
        this.name = name ;
        this.description = description ;
    }

    public void setName (String name){
        this.name = name ;
    }
    public void setDescription(String description){
        this.description = description ;
    }
    public long getId(){
        return this.id ;
    }
    public String getName(){
        return this.name ;
    }
    public String getDescription(){
        return this.description ;
    }
    public void setId(long id){
        this.id = id ;
    }
}
