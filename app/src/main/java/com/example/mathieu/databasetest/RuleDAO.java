package com.example.mathieu.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mathieu on 03/05/2017.
 */

public class RuleDAO {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private String[] allColumns = {DatabaseHelper.KEY_ID,
            DatabaseHelper.KEY_RULE_NAME, DatabaseHelper.KEY_DESCRIPTION};

    public RuleDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Rule createRule(String name, String description) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_RULE_NAME, name);
        values.put(DatabaseHelper.KEY_DESCRIPTION, description);
        long insertId = database.insert(DatabaseHelper.TABLE_RULE, null,
                values);
        Cursor cursor = database.query(DatabaseHelper.TABLE_RULE,
                allColumns, DatabaseHelper.KEY_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Rule newRule = cursorToRule(cursor);
        cursor.close();
        return newRule;
    }

    private Rule cursorToRule(Cursor cursor) {
        Rule rule = new Rule();
        rule.setId(cursor.getLong(0));
        rule.setName(cursor.getString(1));
        rule.setDescription(cursor.getString(2));
        return rule;
    }

    public void deleteRule(String name) {
        database.delete(DatabaseHelper.TABLE_RULE, DatabaseHelper.KEY_RULE_NAME
                + " = ?", new String[]{name});
    }

    public List<Rule> getAllRules() {
        List<Rule> rules = new ArrayList<Rule>();

        Cursor cursor = database.query(DatabaseHelper.TABLE_RULE,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Rule rule = cursorToRule(cursor);
            rules.add(rule);
            cursor.moveToNext();
        }
        cursor.close();
        return rules;
    }

    public int getId(String name) {
        Cursor cursor = database.query(DatabaseHelper.TABLE_RULE,new String[]{DatabaseHelper.KEY_ID},DatabaseHelper.KEY_RULE_NAME + "= ?", new String[]{name},null,null,null);
        cursor.moveToFirst();
        long id = cursor.getLong(0);
        return (int) id;
    }
    public boolean exist(String name) {
        Cursor cursor = database.query(DatabaseHelper.TABLE_RULE, new String[]{DatabaseHelper.KEY_ID}, DatabaseHelper.KEY_RULE_NAME + "= ?", new String[]{name}, null, null, null);
        if (cursor.getCount() == 0)
        {
           cursor.close();
            return false;
        }
        else {
            cursor.close();
            return true;
    }}
    public String getDescription (String name){
        Cursor cursor = database.query(DatabaseHelper.TABLE_RULE,new String[]{DatabaseHelper.KEY_DESCRIPTION},DatabaseHelper.KEY_RULE_NAME + "= ?",new String[]{name},null,null,null);
        cursor.moveToFirst();
        String description = cursor.getString(0);
        return description ;
    }
    }


