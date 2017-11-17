package com.example.matri.catplan;

/**
 * Created by matri on 11/9/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.matri.catplan.User;
public class dbHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CatPlan.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_id = "id";
    private static final String COLUMN_u_name = "name";
    private static final String COLUMN_u_password = "password";

    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table users (id integer primary key not null auto_increment , " +
            "name text not null , password text not null);";

    public dbHelper(Context context)
    {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertUser(User u)
    {
       db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_u_name, u.getUsername());
        values.put(COLUMN_u_password, u.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String u_name)
    {
        db = this.getReadableDatabase();
        String query = "select u_name, u_password from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);

        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);
                if(a.equals(u_name))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        String query = "DROP TABLE IF EXIST" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
