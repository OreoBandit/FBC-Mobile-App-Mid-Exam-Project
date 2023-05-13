package com.example.utsmcs.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.utsmcs.Model.User;

import java.util.Vector;

public class UserHelper {
    private DbHelper dbh;
    private SQLiteDatabase db;
    private final String TABLE_NAME = "user";
    User user = new User();

    public UserHelper(Context ctx){dbh = new DbHelper(ctx);}

    public Vector<User> getAllUser(){
        db = dbh.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM user",null);

        Vector<User> User = new Vector<>();

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            User users = new User();
            users.setId(cursor.getInt(0));
            users.setUsername(cursor.getString(1));
            User.add(users);
            cursor.moveToNext();
        }

        db.close();
        return User;
    }

    public boolean insertUser(String username, String password, String email){
        String insert_user = String.format("insert into users (username,password,email) values('%s', '%s', '%s')",username,password,email);
        db = dbh.getWritableDatabase();
        try{
            db.execSQL(insert_user);
            return true;
        }
        catch(Exception x){
            x.printStackTrace();
            return false;
        }
    }

    public Integer cekUser(String email, String pass){
        db = dbh.getReadableDatabase();
        String cek_user = String.format("SELECT * FROM users where email LIKE '%s' AND password LIKE '%s'",email, pass);
        Cursor cursor = db.rawQuery(cek_user,null);
        if(!cursor.moveToFirst()){
            return -1;
        }
        return cursor.getInt(cursor.getColumnIndexOrThrow("id"));
    }



}
