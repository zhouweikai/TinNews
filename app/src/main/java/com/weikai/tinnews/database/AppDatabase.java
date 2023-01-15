package com.weikai.tinnews.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.weikai.tinnews.retrofit.response.News;

@Database(entities = {News.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
}

