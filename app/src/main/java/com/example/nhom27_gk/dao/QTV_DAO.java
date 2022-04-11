package com.example.nhom27_gk.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.nhom27_gk.model.QuanTriVien;

import java.util.ArrayList;
import java.util.List;

public class QTV_DAO {

    public static final String TAG = "QTV_DAO";

    // Database fields
    private SQLiteDatabase mDatabase;
    private DatabaseHelper mDatabaseHelper;
    private Context mContext;
    private String[] mAllColumns = { DatabaseHelper.COLUMN_QTV_ID,
            DatabaseHelper.COLUMN_QTV_NAME, DatabaseHelper.COLUMN_QTV_USERNAME,
            DatabaseHelper.COLUMN_QTV_PASSWORD };

    public QTV_DAO(Context context) {
        this.mContext = context;
        mDatabaseHelper = new DatabaseHelper(context);
        // open the database
        try {
            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException on openning database " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        mDatabase = mDatabaseHelper.getWritableDatabase();
    }

    public void close() {
        mDatabaseHelper.close();
    }

    public QuanTriVien addQTV(String name, String username, String password) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_QTV_NAME, name);
        values.put(DatabaseHelper.COLUMN_QTV_USERNAME, username);
        values.put(DatabaseHelper.COLUMN_QTV_PASSWORD, password);
        long insertId = mDatabase
                .insert(DatabaseHelper.TABLE_QTV, null, values);
        Cursor cursor = mDatabase.query(DatabaseHelper.TABLE_QTV, mAllColumns,
                DatabaseHelper.COLUMN_QTV_ID + " = " + insertId, null, null,
                null, null);
        cursor.moveToFirst();
        QuanTriVien qtv = cursorToQTV(cursor);
        cursor.close();
        return qtv;
    }

    public void deleteQTV(QuanTriVien qtv) {
        int id = qtv.getMaQTV();
        mDatabase.delete(DatabaseHelper.TABLE_QTV, DatabaseHelper.COLUMN_QTV_ID
                + " = " + id, null);
    }

    public List<QuanTriVien> getAllQTV() {
        List<QuanTriVien> listQTV = new ArrayList<QuanTriVien>();

        Cursor cursor = mDatabase.query(DatabaseHelper.TABLE_QTV, mAllColumns,
                null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                QuanTriVien company = cursorToQTV(cursor);
                listQTV.add(company);
                cursor.moveToNext();
            }

            // make sure to close the cursor
            cursor.close();
        }
        return listQTV;
    }

    public QuanTriVien getQTVById(long id) {
        Cursor cursor = mDatabase.query(DatabaseHelper.TABLE_QTV, mAllColumns,
                DatabaseHelper.COLUMN_QTV_ID + " = ?",
                new String[] { String.valueOf(id) }, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        QuanTriVien qtv = cursorToQTV(cursor);
        return qtv;
    }

    protected QuanTriVien cursorToQTV(Cursor cursor) {
        QuanTriVien qtv = new QuanTriVien();
        qtv.setMaQTV(cursor.getInt(0));
        qtv.setTenQTV(cursor.getString(1));
        qtv.setTenTK(cursor.getString(2));
        qtv.setMatKhau(cursor.getString(3));
        return qtv;
    }


}
