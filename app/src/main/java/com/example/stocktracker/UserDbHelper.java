package com.example.stocktracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "mywbut";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "products";
    private static final String FIRST_COL = "name";
    private static final String SECOND_COL = "model";
    private static final String THIRD_COL = "quantity";
    private static final String FOURTH_COL = "sellprice";
    private static final String FIFTH_COL = "purchasedfrom";
    private static final String SIXTH_COL = "costprice";

    private static final String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " (" + FIRST_COL + " text, " + SECOND_COL + " text, " + THIRD_COL + " text, " + FOURTH_COL + " text, " + FIFTH_COL + " text, " + SIXTH_COL + " text)";

    public UserDbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        Log.i("DB Message","Database Created");
    }

    public void insertData(String name,String model,String quantity,String sellprice,String purchasedfrom,String costprice, SQLiteDatabase db){
        ContentValues content=new ContentValues();

        content.put(FIRST_COL,name);
        content.put(SECOND_COL,model);
        content.put(THIRD_COL,quantity);
        content.put(FOURTH_COL,sellprice);
        content.put(FIFTH_COL,purchasedfrom);
        content.put(SIXTH_COL,costprice);
        db.insert(TABLE_NAME,null,content);

        Log.i("DB_Message","1 data inserted");

    }

    public Cursor viewData(SQLiteDatabase db){
        Cursor cursor;
        cursor=db.rawQuery("Select * From " + TABLE_NAME,null);
        return cursor;
    }

    public Cursor searchData(String name,SQLiteDatabase db){
        Cursor cursor;
        cursor=db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + FIRST_COL + " LIKE " + "'" +  name+ "'",null);
        return cursor;
    }

    public  int updateData(String name,String model,String quantity,String sellprice,String purchasedfrom,String costprice,SQLiteDatabase db){
        ContentValues content=new ContentValues();


        content.put(SECOND_COL,model);
        content.put(THIRD_COL,quantity);
        content.put(FOURTH_COL,sellprice);
        content.put(FIFTH_COL,purchasedfrom);
        content.put(SIXTH_COL,costprice);

        String where="name=?";

        String[] whereArgs={String.valueOf(name)};

        int num_rows=db.update(TABLE_NAME,content,where,whereArgs);
        return  num_rows;
    }

    public int deleteData(String name,SQLiteDatabase db){
        String where="name=?";
        String[] whereArgs={String.valueOf(name)};

        int num_rows=db.delete(TABLE_NAME,where,whereArgs);
        return num_rows;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.i("DB Message","Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
