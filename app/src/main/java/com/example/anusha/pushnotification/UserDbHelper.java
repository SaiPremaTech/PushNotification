package com.example.anusha.pushnotification;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Anusha on 7/28/2016.
 */
public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
    "CREATE TABLE "+UserContract.NewUserInfo.TABLE_NAME+"("+ UserContract.NewUserInfo.MESSAGE_TO_USER+" TEXT,"+
            UserContract.NewUserInfo.AUTHOR_OF_MESSAGE+" TEXT);";


    public UserDbHelper(Context context)
    {
    super(context,DATABASE_NAME, null, DATABASE_VERSION);
    Log.e("DATABASE OPERATIONS","Database created/opened.....");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Table created....");
    }


    public void addInformations(String message_view,String author_view,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.NewUserInfo.MESSAGE_TO_USER,message_view);
        contentValues.put(UserContract.NewUserInfo.AUTHOR_OF_MESSAGE,author_view);
        db.insert(UserContract.NewUserInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS","One message is inserted");
    }


    public Cursor getInformations(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections = {UserContract.NewUserInfo.MESSAGE_TO_USER, UserContract.NewUserInfo.AUTHOR_OF_MESSAGE};
        cursor = db.query(UserContract.NewUserInfo.TABLE_NAME,projections,null,null,null,null,null);

        return cursor;

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
