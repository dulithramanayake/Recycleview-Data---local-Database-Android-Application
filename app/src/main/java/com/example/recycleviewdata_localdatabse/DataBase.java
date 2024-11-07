package com.example.recycleviewdata_localdatabse;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    private final static String name="student_db";
    private final static int version=1;

    private final static String TABLE_STUDENT="student";

    private final static String ID="id";
    private static final String NAME="name";
    private static final String AGE="age";
    private static final String ADDRESS="address";
    private static final String DISTANCE="distance";
    private static final String GRADE="grade";


//    private static final String CREATE_STUDENT_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_STUDENT
//            +"("+ID+" INTEGER PRIMARY KEY AUTOINCERMENT ,"
//            +"("+NAME+" TEXT DEFAULT  '',"
//            +"("+AGE+" TEXT DEFAULT  '',"
//            +"("+ADDRESS+" TEXT DEFAULT  '',"
//            +"("+DISTANCE+" TEXT DEFAULT  '',"
//            +"("+GRADE+" TEXT DEFAULT  ''"
//            +")";

    private static final String CREATE_STUDENT_TABLE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_STUDENT + "(" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NAME + " TEXT DEFAULT '', " +
                    AGE + " INTEGER DEFAULT 0, " +  // Assuming age is an integer
                    ADDRESS + " TEXT DEFAULT '', " +
                    DISTANCE + " REAL DEFAULT 0.0, " +  // Assuming distance is a real number
                    GRADE + " TEXT DEFAULT ''" +
                    ")";


    public DataBase(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertStudent(Student student){
        boolean isInsert=false;
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,student.name);
        contentValues.put(AGE,student.age);
        contentValues.put(ADDRESS,student.address);
        contentValues.put(DISTANCE,student.distance);
        contentValues.put(GRADE,student.grade);
        isInsert = db.insert(TABLE_STUDENT,null,contentValues)>0;

        return isInsert;
    }
}
