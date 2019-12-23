package com.ruobin.demo.photosearcher.data;

import java.util.List;

/**
 * Immutable model class for response of flickr.photos.getInfo API
 *
 * API url example, https://www.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=3815c92a84e3f87a0ef5d5009086f8ab&photo_id=49253208131&format=json&nojsoncallback=1
 *
 */
public final class PhotoDetailedInfo {

    public class Photo {

        public Urls getUrls() {
            return urls;
        }

        private Urls urls;

        public class Urls {

            public List<Url> getUrl() {
                return url;
            }

            private List<Url> url;

            public class Url {

                public String get_content() {
                    return _content;
                }

                private String _content;
            }
        }
    }

    public Photo getPhoto() {
        return photo;
    }

    private Photo photo;

    public String getStat() {
        return stat;
    }

    private String stat;
}
