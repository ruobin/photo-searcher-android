package com.ruobin.demo.photosearcher.data.source;

import com.ruobin.demo.photosearcher.data.PhotoDetailedInfo;
import com.ruobin.demo.photosearcher.data.PhotoSearchResult;

import java.util.Map;

import io.reactivex.Observable;

public interface PhotoDataSource {

    public Observable<PhotoSearchResult> getPhotoSearchResult(String searchKeyword);

    public Observable<PhotoDetailedInfo> getPhotoDetailedInfo(String photoId);
}
