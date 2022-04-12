package com.example.nhom27_gk.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.nhom27_gk.model.SanPham;

public class SP_DAO extends SQLiteOpenHelper {
    public SP_DAO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    public void Insert(SanPham sp){
        try {
            SQLiteDatabase database = getWritableDatabase();
            String sql = "Insert into SanPham value (null,"+sp.getTenSP()+","+sp.getXuatXu()+","+sp.getDonGia()+","+sp.getTrangThai()+")";
        }
        catch (Exception e){

        }
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
