package com.ruobin.demo.photosearcher;

import android.app.Application;

import com.ruobin.demo.photosearcher.di.AppComponent;
import com.ruobin.demo.photosearcher.di.AppModule;
import com.ruobin.demo.photosearcher.di.DaggerAppComponent;

public class PhotoSearcherApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }

    public AppComponent getComponent() {
        return component;
    }
}