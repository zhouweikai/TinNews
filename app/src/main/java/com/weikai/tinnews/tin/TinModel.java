package com.weikai.tinnews.tin;

import android.annotation.SuppressLint;

import com.weikai.tinnews.TinApplication;
import com.weikai.tinnews.database.AppDatabase;
import com.weikai.tinnews.retrofit.NewsRequestApi;
import com.weikai.tinnews.retrofit.RetrofitClient;
import com.weikai.tinnews.retrofit.response.News;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TinModel implements TinContract.Model {

    private TinContract.Presenter presenter;

    private final NewsRequestApi newsRequestApi;

    private final AppDatabase db;

    public TinModel() {
        newsRequestApi = RetrofitClient.getInstance().create(NewsRequestApi.class);

        db = TinApplication.getDataBase();
    }



    @Override
    public void setPresenter(TinContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void fetchData(String country) {
        newsRequestApi.getNewsByCountry(country)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter(baseResponse -> baseResponse != null && baseResponse.articles != null)
            .subscribe(baseResponse -> {

                presenter.showNewsCard(baseResponse.articles);
            });
    }

    @SuppressLint("CheckResult")
    @Override
    public void saveFavoriteNews(News news) {

        Completable.fromAction(() -> db.newsDao().insertNews(news)).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() ->{

        }, error -> {
            presenter.onError();
        });
    }
}
