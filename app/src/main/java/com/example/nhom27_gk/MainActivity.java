package com.example.nhom27_gk;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.example.nhom27_gk.dao.DatabaseHelper;
import com.example.nhom27_gk.dao.QTV_DAO;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    private QTV_DAO mQTV_DAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setEvent();
    }

    private void setEvent() {
        mQTV_DAO=new QTV_DAO(this);
    }

}