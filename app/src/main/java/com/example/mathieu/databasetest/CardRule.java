package com.example.mathieu.databasetest;

/**
 * Created by Mathieu on 01/05/2017.
 */

public class CardRule {
    private long id ;
    String cardName ;
    String ruleName ;

    public CardRule(){};
    public CardRule(String cardName, String ruleName){
        this.cardName = cardName ;
        this.ruleName = ruleName ;
    }
    public void setCard( String cardName){
        this.cardName = cardName ;
    }
    public void setRule(String rule){
        this.ruleName = rule ;
    }
    public long getId(){
        return this.id ;
    }
    public String getRule(){
        return this.ruleName ;
    }
    public String getCard(){
        return this.cardName ;
    }
    public void setId (long id){
        this.id = id ;
    }
}