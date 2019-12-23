package com.ruobin.demo.photosearcher.data;

import java.util.List;

/**
 * Immutable model class for response of flickr.photos.search API
 *
 * API url example, https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=3815c92a84e3f87a0ef5d5009086f8ab&text=cars&format=json&nojsoncallback=1
 *
 */
public class PhotoSearchResult {

    public PhotoResponse getPhotos() {
        return photos;
    }

    private PhotoResponse photos;

    public class PhotoResponse {

        public List<PhotoBasicInfo> getPhotoList() {
            return photo;
        }

        private String page;

        private List<PhotoBasicInfo> photo;

        public class PhotoBasicInfo {

            private String id;
            private String owner;
            private String title;
            private String inpublic;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOwner() {
                return owner;
            }

            public void setOwner(String owner) {
                this.owner = owner;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getInpublic() {
                return inpublic;
            }

            public void setInpublic(String inpublic) {
                this.inpublic = inpublic;
            }
        }
    }

    public String getStat() {
        return stat;
    }

    private String stat;

}
