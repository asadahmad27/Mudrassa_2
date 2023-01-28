package com.example.recycleview;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "student.db";
    private static final String TABLE_NAME_STD = "students";
    private static final String TABLE_NAME_SDD = "data";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";

    private static final String SDD_COLUMN_ID = "id";
    private static final String SDD_COLUMN_MANZIL = "MANZIL";
    private static final String SDD_COLUMN_SABAQ = "SABAQ";
    private static final String SDD_COLUMN_SABQI = "SABQI";
//    private static final String SDD_COLUMN_DAY = "id";

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_STD + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT"
                + ")";
        sqLiteDatabase.execSQL(sql);

        sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_SDD + "("
                + SDD_COLUMN_ID + " INTEGER,"
                + SDD_COLUMN_MANZIL + " TEXT,"
                + SDD_COLUMN_SABAQ + " TEXT,"
                + SDD_COLUMN_SABQI + "TEXT"
                + ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME_STD;
        sqLiteDatabase.execSQL(sql);
        sql = "DROP TABLE IF EXISTS " + TABLE_NAME_SDD;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());

        db.insert(TABLE_NAME_STD, null, values);
        db.close();
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME_STD;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                students.add(new Student(name, R.drawable.person_24, id));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }
}
