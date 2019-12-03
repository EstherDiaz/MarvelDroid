package com.example.marveldroid.data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PersistenceHelper extends SQLiteOpenHelper{

    public PersistenceHelper(@Nullable Context context,
                                  @Nullable String name,
                                  @Nullable SQLiteDatabase.CursorFactory factory,
                                  int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatabaseUtils.CREATE_TABLE_USER);
        sqLiteDatabase.execSQL(DatabaseUtils.CREATE_TABLE_MARKS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS mark");
        onCreate(sqLiteDatabase);
    }
}
