package com.example.utsmcs.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.utsmcs.Model.Ticket;
import com.example.utsmcs.Model.User;

import java.util.Vector;

public class TicketHelper {
    private DbHelper dbh;
    private SQLiteDatabase db;
    private final String TABLE_NAME = "ticket";
    Ticket ticket= new Ticket();

    public TicketHelper(Context ctx){dbh = new DbHelper(ctx);}

    public Vector<Ticket> getAllTicket(){
        db = dbh.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM ticket",null);
        Vector<Ticket> tickets = new Vector<>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Ticket ticket = new Ticket();
            ticket.setTicketId(cursor.getInt(cursor.getColumnIndexOrThrow("ticketId")));
            ticket.setMatchDate(cursor.getString(cursor.getColumnIndexOrThrow("matchDate")));
            ticket.setMatchName(cursor.getString(cursor.getColumnIndexOrThrow("matchName")));
            ticket.setImgUrl(cursor.getString(cursor.getColumnIndexOrThrow("imgUrl")));
            ticket.setUserId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            tickets.add(ticket);
            cursor.moveToNext();
        }

        db.close();
        return tickets;
    }

    public boolean insertTicket(String matchD, String matchN,String imgUrl, Integer idus){
        @SuppressLint("DefaultLocale") String insert_ticket = String.format("insert into ticket (matchDate, matchName, imgUrl ,id) values('%s', '%s', '%s', '%d')",matchD,matchN,imgUrl,idus);
        db = dbh.getWritableDatabase();
        try{
            db.execSQL(insert_ticket);
            return true;
        }
        catch(Exception x){
            x.printStackTrace();
            return false;
        }
    }

//    public Integer getUserID(){
//        String get_user_id = "Select id from user";
//    }

    public Vector<Ticket> filterTicket(Integer userId){
        @SuppressLint("DefaultLocale") String filter_ticket = String.format(
                "select ticket.ticketId as 'ticketId', " +
                "ticket.matchDate as 'matchDate'," +
                "ticket.matchName as 'matchName'," +
                "ticket.imgUrl as 'imgUrl'," +
                "users.username as 'username' " +
                "from ticket inner join users on ticket.id = users.id " +
                        "where '%d' = ticket.id",userId);

//        db = dbh.getReadableDatabase();
//        try{
//            db.execSQL(filter_ticket);
//            return true;
//        }catch(Exception x){
//            x.printStackTrace();
//            return false;
//        }


        db = dbh.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(filter_ticket,null);
        Vector<Ticket> tickets = new Vector<>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Ticket ticket = new Ticket();
            ticket.setTicketId(cursor.getInt(cursor.getColumnIndexOrThrow("ticketId")));
            ticket.setMatchDate(cursor.getString(cursor.getColumnIndexOrThrow("matchDate")));
            ticket.setMatchName(cursor.getString(cursor.getColumnIndexOrThrow("matchName")));
            ticket.setImgUrl(cursor.getString(cursor.getColumnIndexOrThrow("imgUrl")));
            ticket.setUsername(cursor.getString(cursor.getColumnIndexOrThrow("username")));
            tickets.add(ticket);
            cursor.moveToNext();
        }
        return tickets;
    }

    //SISA COPAS
//    public boolean cekUser(String email, String pass){
//        db = dbh.getReadableDatabase();
//        String cek_user = String.format("SELECT * FROM users where email LIKE '%s' AND password LIKE '%s'",email, pass);
//        Cursor cursor = db.rawQuery(cek_user,null);
//        if(!cursor.moveToFirst()){
//            return false;
//        }
//        return true;
//    }



}
