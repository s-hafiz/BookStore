package com.begginers.bookstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shafiz on 1/21/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    //Creating variables
    public static final String DATABASE_NAME = "BookStore.db";
    public static final String TABLE_NAME = "book_cataloge";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "BOOKID";
    public static final String COL4 = "QUANTITY";
    public static final int DATABASE_VERSION = 1;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase  sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" ("+COL1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL2+" TEXT,"+COL3+" INTEGER,"+COL4+" INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean insertData(String NAME,String BOOKID,String QUANTITY){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,NAME);
        contentValues.put(COL3,BOOKID);
        contentValues.put(COL4,QUANTITY);
        long resutl=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (resutl==-1) return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }

    public boolean updateData(String id,String NAME,String BOOKID,String QUANTITY){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,NAME);
        contentValues.put(COL3,BOOKID);
        contentValues.put(COL4,QUANTITY);
        sqLiteDatabase.update(TABLE_NAME,contentValues,"ID = ?",new String[] {id});
        return true;
    }

}
