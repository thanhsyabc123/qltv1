package com.example.quanlythuvien.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlythuvien.database.DbHelper;

import java.sql.SQLDataException;

public class DemoDB {
    private SQLiteDatabase db;

    public DemoDB(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
}
