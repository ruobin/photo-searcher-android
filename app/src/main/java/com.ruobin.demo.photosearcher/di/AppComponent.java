package com.ruobin.demo.photosearcher.di;

import com.ruobin.demo.photosearcher.data.source.remote.PhotoRemoteDataSource;
import com.ruobin.demo.photosearcher.search.PhotoSearchActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(PhotoSearchActivity target);

    void inject(PhotoRemoteDataSource target);
}