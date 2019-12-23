package com.ruobin.demo.photosearcher.data;

import java.util.List;

public class PhotoResponse {

    public List<PhotoBasicInfo> getPhotoList() {
        return photo;
    }

    private String page;

    private List<PhotoBasicInfo> photo;
}
