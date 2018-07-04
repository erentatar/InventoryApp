package com.example.android.inventoryapp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.inventoryapp.Data.ProductContract.ProductEntry;

public class ProductDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = ProductDbHelper.class.getSimpleName();
    private final static String DATABASE_NAME = "inventory.db";
    private final static int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_PRODUCTS_TABLE =
            "CREATE TABLE " + ProductEntry.TABLE_NAME + " ("
                    + ProductEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + ProductEntry.COLUMN_NAME + " TEXT NOT NULL, "
                    + ProductEntry.COLUMN_PRICE + " REAL NOT NULL DEFAULT 0, "
                    + ProductEntry.COLUMN_QUANTITY + " INTEGER NOT NULL DEFAULT 0, "
                    + ProductEntry.COLUMN_SUPPLIER_NAME + " TEXT, "
                    + ProductEntry.COLUMN_SUPPLIER_PHONE + " TEXT);";

    public ProductDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
