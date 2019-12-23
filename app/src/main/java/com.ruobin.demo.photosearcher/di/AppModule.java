package com.ruobin.demo.photosearcher.di;

import android.content.Context;

import com.google.gson.Gson;
import com.ruobin.demo.photosearcher.PhotoSearcherApplication;
import com.ruobin.demo.photosearcher.data.source.PhotoDataSource;
import com.ruobin.demo.photosearcher.data.source.remote.PhotoRemoteDataSource;
import com.ruobin.demo.photosearcher.search.PhotoSearchViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class AppModule {

    private PhotoSearcherApplication application;

    public AppModule(PhotoSearcherApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    public PhotoDataSource providePhotoDataSource(OkHttpClient okHttpClient, Gson gson) {
        return new PhotoRemoteDataSource(okHttpClient, gson);
    }

    @Provides
    @Singleton
    public PhotoSearchViewModel providePhotoSearchViewModel(PhotoDataSource photoDataSource) {
        return new PhotoSearchViewModel(photoDataSource);
    }

}