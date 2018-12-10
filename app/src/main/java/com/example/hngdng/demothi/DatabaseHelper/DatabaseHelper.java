package com.example.hngdng.demothi.DatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.hngdng.demothi.SinhVien.SinhVienEntry;
import com.example.hngdng.demothi.SinhVien;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "QLsinhvien.db";
    public static final String TABLE_NAME = "sinhVien";
    public static final String COL_ID = "ID";
    public static final String COL_MASV= "MaSV";
    public static final String COL_TENSV = "TenSV";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String createDB = "CREATE TABLE " +
                SinhVienEntry.TABLE_NAME + " (" +
                SinhVienEntry.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SinhVienEntry.COL_MASV + " TEXT NOT NULL, " +
                SinhVienEntry.COL_TENSV + " TEXT NOT NULL " +
                ");";
        db.execSQL(createDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SinhVienEntry.TABLE_NAME);
        onCreate(db);

    }
}
