package com.example.admin.active_tutoria;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 2016/11/02.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";


    public static final int VERSION = 2;

  public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);

  }
  @Override
    public void onCreate(SQLiteDatabase db){
    db.execSQL("CREATE Table" + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");
  }
  public void onUpgrade(SQLiteDatabase db,int OldVersion,int NewVersion){
     db.execSQL("DROP IF EXISTS" + TABLE_NAME);
      onCreate(db);
  }
    public boolean insertData(String name, String surname, String Marks) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,Marks);
        final long Answer = db.insert(TABLE_NAME, null, contentValues);
        if(Answer == -1)
            return  false;
        else
            return true;
    }
}



