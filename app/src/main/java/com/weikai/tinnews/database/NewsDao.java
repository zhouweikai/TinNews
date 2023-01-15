package com.weikai.tinnews.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.weikai.tinnews.retrofit.response.News;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface NewsDao {

    @Insert
    void insertNews(News news);

    @Query("SELECT * FROM news")
    Flowable<List<News>> getAll();

    @Query("DELETE FROM news")
    void deleteAllNews();
}

