package com.ruobin.demo.photosearcher.search;

import com.ruobin.demo.photosearcher.data.PhotoSearchResult;
import com.ruobin.demo.photosearcher.data.source.PhotoDataSource;

import javax.inject.Inject;

import io.reactivex.Observable;

public class PhotoSearchViewModel {

    private PhotoDataSource dataSource;

    @Inject
    public PhotoSearchViewModel(PhotoDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Observable<PhotoSearchResult> getPhotoList(String searchKeyword) {
        return dataSource.getPhotoSearchResult(searchKeyword);
    }
}
