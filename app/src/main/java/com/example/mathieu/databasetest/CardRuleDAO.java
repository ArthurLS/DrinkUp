package com.example.mathieu.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mathieu on 03/05/2017.
 */

public class CardRuleDAO {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private String[] allColumns = { DatabaseHelper.KEY_ID,
            DatabaseHelper.KEY_CARD_NAME,DatabaseHelper.KEY_RULE_NAME};

    public CardRuleDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }
    public CardRule createCardRule(String cardName, String ruleName) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_CARD_NAME, cardName);
        values.put(DatabaseHelper.KEY_RULE_NAME, ruleName);
        long insertId = database.insert(DatabaseHelper.TABLE_CARD_RULE, null,
                values);
        Log.i("TAG", "id inserted: "+insertId);
        Cursor cursor = database.query(DatabaseHelper.TABLE_CARD_RULE,allColumns,
                DatabaseHelper.KEY_ID + " = " + insertId ,null, null,null,null);

        Log.i("TAG", DatabaseUtils.dumpCursorToString(cursor));
        cursor.moveToFirst();
        CardRule cardRule = cursorToCardRule(cursor);
        cursor.close();
        return cardRule;
    }
    public CardRule cursorToCardRule(Cursor cursor){
        CardRule cardRule = new CardRule() ;
        cardRule.setId( cursor.getLong(0));
        cardRule.setCard(cursor.getString(1));
        cardRule.setRule(cursor.getString(2));
        return cardRule;
    }

    public void cleanTable(){
        database.execSQL("DROP TABLE IF EXISTS " + DatabaseHelper.TABLE_CARD_RULE);
        database.execSQL(DatabaseHelper.CREATE_TABLE_CARD_RULE);
    }

    public void deleteCardRule(String name) {
        database.delete(DatabaseHelper.TABLE_CARD_RULE, DatabaseHelper.KEY_CARD_NAME
                + " = ?", new String [] {name});
    }
    public List<CardRule> getAllCardRules(){
        List<CardRule> cardRules = new ArrayList<CardRule>();

        Cursor cursor = database.query(DatabaseHelper.TABLE_CARD_RULE,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CardRule cardRule = cursorToCardRule(cursor);
            cardRules.add(cardRule);
            cursor.moveToNext();
        }
        cursor.close();
        return cardRules;
    }
}