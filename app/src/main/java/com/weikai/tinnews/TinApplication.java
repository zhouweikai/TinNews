package com.weikai.tinnews;

import android.app.Application;
import androidx.room.Room;

import com.facebook.stetho.Stetho;
import com.weikai.tinnews.database.AppDatabase;

public class TinApplication extends Application {
    public static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "tin_db").build();
    }

    public static AppDatabase getDataBase() {
        return database;
    }

}
