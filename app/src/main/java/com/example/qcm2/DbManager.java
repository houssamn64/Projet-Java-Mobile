package com.example.qcm2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper {

    private static final String dbname="qcm.db";
    public DbManager(Context context)
    {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry="create table users(id integer primary key autoincrement, nom text, email text, password text)";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);

    }

    public String AddRecord (String n, String em, String pwd)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("nom", n);
        cv.put("email", em);
        cv.put("password", pwd);

        long res=db.insert("users",null,cv);
        if (res==-1)
            return "failed";
        else
            return "successfully inserted";

    }
}
