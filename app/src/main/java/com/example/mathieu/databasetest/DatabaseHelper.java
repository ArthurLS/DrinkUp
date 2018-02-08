package com.example.mathieu.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Mathieu on 30/04/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database";
    public static final String TABLE_CARD = "cards";
    public static final String TABLE_RULE = "rules";
    public static final String TABLE_CARD_RULE = "cards_rules";
    public static final String KEY_ID = "id";
    public static final String KEY_CARD_NAME = "card_name";
    public static final String KEY_RULE_NAME = "rule_name" ;
    public static final String KEY_DESCRIPTION = "description";

    public static final String CREATE_TABLE_CARD = "CREATE TABLE "
            + TABLE_CARD + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_CARD_NAME
            + " TEXT);";

    public static final String CREATE_TABLE_RULE = "CREATE TABLE " + TABLE_RULE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_RULE_NAME + " TEXT,"
            + KEY_DESCRIPTION + " TEXT" + ");";

    public static final String CREATE_TABLE_CARD_RULE = "CREATE TABLE "
            + TABLE_CARD_RULE + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_CARD_NAME + " TEXT," + KEY_RULE_NAME
            + " TEXT" + ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CARD);
        db.execSQL(CREATE_TABLE_RULE);
        db.execSQL(CREATE_TABLE_CARD_RULE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RULE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARD_RULE);
        onCreate(db);
    }
}