package com.ruobin.demo.photosearcher.data.source.remote;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.ruobin.demo.photosearcher.data.PhotoDetailedInfo;
import com.ruobin.demo.photosearcher.data.PhotoResponse;
import com.ruobin.demo.photosearcher.data.PhotoSearchResult;
import com.ruobin.demo.photosearcher.data.source.PhotoDataSource;

import java.util.Map;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PhotoRemoteDataSource implements PhotoDataSource {

    private static PhotoRemoteDataSource INSTANCE;

    OkHttpClient okHttpClient;

    Gson gson;

    private final static String FLICKR_API_KEY = "3815c92a84e3f87a0ef5d5009086f8ab";

    //URL: https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=3815c92a84e3f87a0ef5d5009086f8ab&tags=cars&format=json&nojsoncallback=1

    private final static String FLICKR_SERVICE_BASE_URL = "https://www.flickr.com/services/rest/";
    private final static String PHOTO_SEARCH_API_PATH = "?method=flickr.photos.search";
    private final static String FLICKR_SERVICE_URL_SUFFIX = "&format=json&nojsoncallback=1";


    //https://www.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=3815c92a84e3f87a0ef5d5009086f8ab&photo_id=49262093617&format=json&nojsoncallback=1
    private final static String PHOTO_GET_INFO_API_PATH = "?method=flickr.photos.getInfo";

    public static PhotoRemoteDataSource getInstance(OkHttpClient okHttpClient, Gson gson) {
        if (INSTANCE == null) {
            INSTANCE = new PhotoRemoteDataSource(okHttpClient, gson);
        }
        return INSTANCE;
    }

    public PhotoRemoteDataSource(OkHttpClient okHttpClient, Gson gson) {
        this.okHttpClient = okHttpClient;
        this.gson = gson;
    }

    @Override
    public Observable<PhotoSearchResult> getPhotoSearchResult(String searchKeyword) {

        final Request request = new Request.Builder()
                .url(FLICKR_SERVICE_BASE_URL
                        + PHOTO_SEARCH_API_PATH
                        + "&api_key=" + FLICKR_API_KEY
                        + "&tags=" + searchKeyword
                        + FLICKR_SERVICE_URL_SUFFIX)
                .build();

        return Flowable.fromCallable(new Callable<PhotoSearchResult>() {
            @Override
            public PhotoSearchResult call() throws Exception {
                Response response = okHttpClient.newCall(request).execute();
                return gson.fromJson(response.body().string(), PhotoSearchResult.class);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable();

    }

    @Override
    public Observable<PhotoDetailedInfo> getPhotoDetailedInfo(String photoId) {
        final Request request = new Request.Builder()
                .url(FLICKR_SERVICE_BASE_URL
                        + PHOTO_GET_INFO_API_PATH
                        + "&api_key=" + FLICKR_API_KEY
                        + "&photo_id=" + photoId
                        + FLICKR_SERVICE_URL_SUFFIX)
                .build();

        return Flowable.fromCallable(new Callable<PhotoDetailedInfo>() {
            @Override
            public PhotoDetailedInfo call() throws Exception {
                Response response = okHttpClient.newCall(request).execute();
                PhotoDetailedInfo info = gson.fromJson(response.body().string(), PhotoDetailedInfo.class);
                return info;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable();
    }
}
