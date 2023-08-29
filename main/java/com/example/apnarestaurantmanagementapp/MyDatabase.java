package com.example.apnarestaurantmanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 100;
    private static final String DATABASE_NAME = "restaurantDB1";
    public MyDatabase(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        UserTable.onCreate(db);
        ProductTable.onCreate(db);
        SaleTable.onCreate(db);
        ExpenseTable.onCreate(db);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //alter tables
        UserTable.onUpgrade(db, oldVersion, newVersion);
        ProductTable .onUpgrade(db, oldVersion, newVersion);
        SaleTable.onUpgrade(db, oldVersion, newVersion);
        ExpenseTable .onUpgrade(db, oldVersion, newVersion);
    }
    public boolean saveUser(String full_name,String userid,String password,String address,String usertype,String dateOfJoining,String status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name",full_name);
        contentValues.put("userid",userid);
        contentValues.put("password",password);
        contentValues.put("address",address);
        contentValues.put("usertype",usertype);
        contentValues.put("dateOfJoining",dateOfJoining);
        contentValues.put("status",status);
        long result = db.insert("users",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean saveExpense(String category,String title,String description,String doe,String remarks,String total,String status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("category",category);
        contentValues.put("title",title);
        contentValues.put("description",description);
        contentValues.put("doe",doe);
        contentValues.put("remarks",remarks);
        contentValues.put("total",total);
        contentValues.put("status",status);
        long result = db.insert("expenses",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean saveSale(String customerName,String productname,String productNo,int price,int qty,int total,String saleDate,String status,String remarks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("customerName",customerName);
        contentValues.put("productname",productname);
        contentValues.put("productNo",productNo);
        contentValues.put("price",price);
        contentValues.put("qty",qty);
        contentValues.put("total",total);
        contentValues.put("saleDate",saleDate);
        contentValues.put("status",status);
        contentValues.put("remarks",remarks);

        long result = db.insert("expenses",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(String table)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+table,null);
        return res;
    }
    public Cursor getDataByID(String table,String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+table+" where id='"+id+"'",null);
        return res;
    }
    public int delete(String tableName,String id,String value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tableName, id+"= ?",new String[] {value});
    }

}
