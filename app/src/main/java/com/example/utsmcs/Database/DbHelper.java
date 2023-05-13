package com.example.utsmcs.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {


    //CREATE TABLE
    private final String CREATE_TABLE_USER =
            "CREATE TABLE users (id integer PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT NOT NULL, email TEXT unique)";

    private final String CREATE_TABLE_TICKET =
            "CREATE TABLE ticket (ticketId integer PRIMARY KEY AUTOINCREMENT, matchDate TEXT, matchName TEXT, imgUrl TEXT, id integer, FOREIGN KEY(id) references users(id))";

    //NAMA DATABASE
    public DbHelper(@Nullable Context ctx) {
        super(ctx, "FBC_club", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_TICKET);
    }


    //DROP TABLE UNTUK users
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS ticket");
    }
}