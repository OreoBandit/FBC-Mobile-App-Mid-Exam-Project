package com.example.utsmcs.Database;

import android.content.Context;

public class Database {
    private static Database instance;
    private UserHelper userHelper;
    private TicketHelper ticketHelper;

    private Database(Context ctx){
        userHelper = new UserHelper(ctx);
//        ticketHelper = new TicketHelper(ctx);

    }

    public static Database getInstance(Context ctx){
        //BUAT DB SINGLETON
        if(instance==null){
            synchronized (Database.class){
                if(instance==null){
                    instance=new Database(ctx);
                }
            }
        }
        return instance;
    }



}
