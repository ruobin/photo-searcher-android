package com.ruobin.demo.photosearcher.data.source;

import com.ruobin.demo.photosearcher.data.PhotoDetailedInfo;
import com.ruobin.demo.photosearcher.data.PhotoSearchResult;
import com.ruobin.demo.photosearcher.data.PhotoSizesInfo;

import io.reactivex.Observable;

public interface PhotoDataSource {

    public Observable<PhotoSearchResult> getPhotoSearchResult(String searchKeyword);

    public Observable<PhotoDetailedInfo> getPhotoDetailedInfo(String photoId);

    public Observable<PhotoSizesInfo> getPhotoSizesInfo(String photoId);
}
