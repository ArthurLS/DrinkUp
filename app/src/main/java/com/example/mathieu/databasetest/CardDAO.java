package com.example.mathieu.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mathieu on 02/05/2017.
 */

public class CardDAO {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private String[] allColumns = { DatabaseHelper.KEY_ID,
            DatabaseHelper.KEY_CARD_NAME};

    public CardDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Card createCard(String name, int img) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_CARD_NAME, name);
        long insertId = database.insert(DatabaseHelper.TABLE_CARD, null,
                values);
        Cursor cursor = database.query(DatabaseHelper.TABLE_CARD,
                allColumns, DatabaseHelper.KEY_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Card newCard = cursorToCard(cursor);
        cursor.close();
        newCard.setImage(img);
        return newCard;
    }
    private Card cursorToCard(Cursor cursor) {
        Card card = new Card();
        card.setId( cursor.getLong(0));
        card.setName(cursor.getString(1));
        return card;
    }

    public void deleteCard(Card card) {
        long id = card.getId();
        System.out.println("Card deleted with id: " + id);
        database.delete(DatabaseHelper.TABLE_CARD, DatabaseHelper.KEY_ID
                + " = ?",new String[]{String.valueOf(id)});
    }
    public List<Card> getAllCards() {
        List<Card> cards = new ArrayList<Card>();

        Cursor cursor = database.query(DatabaseHelper.TABLE_CARD,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Card card = cursorToCard(cursor);
            cards.add(card);
            cursor.moveToNext();
        }
        cursor.close();
        return cards;
    }
    public int getId (String name){
        Cursor cursor = database.rawQuery("select"+DatabaseHelper.KEY_ID+"from"+ DatabaseHelper.TABLE_CARD+"where card_name = ?",new String[]{name});
        cursor.moveToFirst();
        long id = cursor.getLong(0) ;
        return (int) id ;
    }
    public boolean exist(String name) {
        Cursor cursor = database.query(DatabaseHelper.TABLE_CARD, new String[]{DatabaseHelper.KEY_ID}, DatabaseHelper.KEY_CARD_NAME + "= ?", new String[]{name}, null, null, null);
        if (cursor.getCount() == 0)
        {
            cursor.close();
            return false;
        }
        else
            cursor.close();
            return true;
    }
}
