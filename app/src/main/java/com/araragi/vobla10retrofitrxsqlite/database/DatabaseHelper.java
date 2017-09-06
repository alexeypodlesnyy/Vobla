package com.araragi.vobla10retrofitrxsqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.araragi.vobla10retrofitrxsqlite.database.DBContract.DATABASE_NAME;
import static com.araragi.vobla10retrofitrxsqlite.database.DBContract.DATABASE_VERSION;

/**
 * Created by Araragi on 2017-08-27.
 */

public class DatabaseHelper  extends SQLiteOpenHelper {

    private static DatabaseHelper mInstance = null;

    private Context mCxt;

    public static DatabaseHelper getInstance(Context ctx) {

        if (mInstance == null) {
            mInstance = new DatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }


    private static final String TAG = "DatabaseOpenHelper";


    DatabaseHelper(Context context){
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase _db) {
        _db.execSQL(DBContract.DATABASE_CREATE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion){
        Log.w(TAG, "Upgrading application's database from version " + oldVersion
                + " to " + newVersion + ", which will destroy all old data!");

        _db.execSQL("DROP TABLE IF EXISTS " + DBContract.DATABASE_TABLE_FLIGHTS +  ";");

        onCreate(_db);
    }








}
