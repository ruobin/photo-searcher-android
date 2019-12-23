package com.ruobin.demo.photosearcher.data;


import java.util.List;

/**
 * Immutable model class for response of flickr.photos.getSizes API
 *
 * API url example, https://www.flickr.com/services/rest/?method=flickr.photos.getSizes&api_key=3815c92a84e3f87a0ef5d5009086f8ab&photo_id=49253208131&format=json&nojsoncallback=1
 *
 */
public class PhotoSizesInfo {

    public class Sizes {

        public List<Size> getSize() {
            return size;
        }

        private List<Size> size;

        public class Size {

            public String getLabel() {
                return label;
            }

            public int getWidth() {
                return width;
            }

            public int getHeight() {
                return height;
            }

            public String getSource() {
                return source;
            }

            public String getUrl() {
                return url;
            }

            public String getMedia() {
                return media;
            }

            private String label;

            private int width;

            private int height;

            private String source;

            private String url;

            private String media;
        }

    }

    public Sizes getSizes() {
        return sizes;
    }

    private Sizes sizes;

    public String getStat() {
        return stat;
    }

    private String stat;
}
