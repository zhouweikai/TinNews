package com.weikai.tinnews.save;

import com.weikai.tinnews.mvp.MvpContract;
import com.weikai.tinnews.retrofit.response.News;

import java.util.List;

public interface SavedNewsContract {

    interface View extends MvpContract.View<Presenter> {

        void loadSavedNews(List<News> newsList);

    }

    interface Presenter extends  MvpContract.Presenter<View, Model> {

        void loadSavedNews(List<News> newsList);

    }

    interface Model extends MvpContract.Model<Presenter> {

        void fetchData();

    }


}
