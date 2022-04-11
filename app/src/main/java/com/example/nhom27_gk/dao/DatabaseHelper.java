package com.example.nhom27_gk.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "QLDHSP_27";

    // Table Names
    public static final String TABLE_QTV = "QuanTriVien";
    public static final String TABLE_KH = "KhachHang";
    public static final String TABLE_DDH = "DonDatHang";
    public static final String TABLE_TTDH = "ThongTinDonHang";
    public static final String TABLE_SP = "SanPham";

    // columns of the QTV table
    public static final String COLUMN_QTV_ID = "maQTV";
    public static final String COLUMN_QTV_NAME = "tenQTV";
    public static final String COLUMN_QTV_USERNAME = "tenTK";
    public static final String COLUMN_QTV_PASSWORD = "matKhau";

    // columns of the KhachHang table
    public static final String COLUMN_KH_ID = "maKH";
    public static final String COLUMN_KH_NAME = "tenKH";
    public static final String COLUMN_KH_ADDRESS = "diaChi";
    public static final String COLUMN_KH_PHONENUMBER = "sdt";
    public static final String COLUMN_KH_USERNAME = "tenTK";
    public static final String COLUMN_KH_PASSWORD = "matKhau";

    // columns of the DonDatHang table
    public static final String COLUMN_DDH_ID = "maDDH";
    public static final String COLUMN_DDH_DATE = "ngayDH";
    public static final String COLUMN_DDH_STATUS = "trangThai";
    public static final String COLUMN_DDH_ID_KH = "maKH";

    // columns of the ThongTinDonHang table
    public static final String COLUMN_TTDH_ID = "maCTDH";
    public static final String COLUMN_TTDH_ID_DH = "maDDH";
    public static final String COLUMN_TTDH_ID_SP = "maSP";
    public static final String COLUMN_TTDH_AMOUNT = "soLuong";
    public static final String COLUMN_TTDH_PRICE = "donGia";

    // columns of the SanPham table
    public static final String COLUMN_SP_ID = "maSP";
    public static final String COLUMN_SP_NAME = "tenSP";
    public static final String COLUMN_SP_ORIGIN = "xuatXu";
    public static final String COLUMN_SP_PRICE = "donGia";
    public static final String COLUMN_SP_STATUS = "trangThai";


    // SQL statement of the QTV table creation
    private static final String SQL_CREATE_TABLE_QTV = "CREATE TABLE " + TABLE_QTV + "("
            + COLUMN_QTV_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_QTV_NAME + " TEXT NOT NULL, "
            + COLUMN_QTV_USERNAME + " TEXT NOT NULL, "
            + COLUMN_QTV_PASSWORD + " TEXT NOT NULL "
            +");";

    // SQL statement of the KhachHang table creation
    private static final String SQL_CREATE_TABLE_KH = "CREATE TABLE " + TABLE_KH + "("
            + COLUMN_KH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_KH_NAME + " TEXT NOT NULL, "
            + COLUMN_KH_ADDRESS + " TEXT NOT NULL, "
            + COLUMN_KH_PHONENUMBER + " TEXT NOT NULL, "
            + COLUMN_KH_USERNAME + " TEXT NOT NULL, "
            + COLUMN_KH_PASSWORD + " TEXT NOT NULL "
            +");";

    // SQL statement of the DonDatHang table creation
    private static final String SQL_CREATE_TABLE_DDH = "CREATE TABLE " + TABLE_DDH + "("
            + COLUMN_DDH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DDH_DATE + " NUMERIC NOT NULL, "
            + COLUMN_DDH_STATUS + " NUMERIC NOT NULL, "
            + COLUMN_DDH_ID_KH + " TEXT NOT NULL, "
            + "FOREIGN KEY("+ COLUMN_DDH_ID_KH +") REFERENCES "+ TABLE_KH +"("+ COLUMN_KH_ID +")"
            +");";

    // SQL statement of the TTDonHang table creation
    private static final String SQL_CREATE_TABLE_TTDH = "CREATE TABLE " + TABLE_TTDH + "("
            + COLUMN_TTDH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TTDH_ID_DH + " TEXT NOT NULL, "
            + COLUMN_TTDH_ID_SP + " TEXT NOT NULL, "
            + COLUMN_TTDH_AMOUNT + " INTEGER NOT NULL, "
            + COLUMN_TTDH_PRICE + " REAL NOT NULL, "
            + "FOREIGN KEY("+ COLUMN_TTDH_ID_DH +") REFERENCES "+ TABLE_DDH +"("+ COLUMN_DDH_ID +"),"
            + "FOREIGN KEY("+ COLUMN_TTDH_ID_SP +") REFERENCES "+ TABLE_SP +"("+ COLUMN_SP_ID +")"
            +");";

    // SQL statement of the SanPham table creation
    private static final String SQL_CREATE_TABLE_SP = "CREATE TABLE " + TABLE_SP + "("
            + COLUMN_SP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SP_NAME + " TEXT NOT NULL, "
            + COLUMN_SP_ORIGIN + " TEXT NOT NULL, "
            + COLUMN_SP_PRICE + " REAL NOT NULL, "
            + COLUMN_SP_STATUS + " NUMERIC NOT NULL "
            +");";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_QTV);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_KH);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_DDH);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_SP);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_TTDH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.w(LOG,
                "Upgrading the database from version " + oldVersion + " to "+ newVersion);
        // clear all data
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TTDH);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SP);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DDH);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_KH);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_QTV);

        // recreate the tables
        onCreate(sqLiteDatabase);
    }
}
