package com.ruobin.demo.photosearcher.data;





//{ "photo": { "id": "49262093617", "secret": "0584567f63", "server": "65535", "farm": 66, "dateuploaded": "1577068449", "isfavorite": 0, "license": 0, "safety_level": 0, "rotation": 0, "originalsecret": "39a0567a2e", "originalformat": "jpg",
//        "owner": { "nsid": "186116107@N07", "username": "ravinderemail0001", "realname": "Smart rwl", "location": "panipat", "iconserver": "65535", "iconfarm": 66, "path_alias": "" },
//        "title": { "_content": "Old building" },
//        "description": { "_content": "" },
//        "visibility": { "ispublic": 1, "isfriend": 0, "isfamily": 0 },
//        "dates": { "posted": "1577068449", "taken": "2019-12-22 11:57:14", "takengranularity": 0, "takenunknown": 0, "lastupdate": "1577068574" }, "views": 0,
//        "editability": { "cancomment": 0, "canaddmeta": 0 },
//        "publiceditability": { "cancomment": 1, "canaddmeta": 0 },
//        "usage": { "candownload": 1, "canblog": 0, "canprint": 0, "canshare": 1 },
//        "comments": { "_content": 0 },
//        "notes": {
//        "note": [
//
//        ] },
//        "people": { "haspeople": 0 },
//        "tags": {
//        "tag": [
//        { "id": "186094777-49262093617-349", "author": "186116107@N07", "authorname": "ravinderemail0001", "raw": "plants", "_content": "plants", "machine_tag": "" },
//        { "id": "186094777-49262093617-553", "author": "186116107@N07", "authorname": "ravinderemail0001", "raw": "building", "_content": "building", "machine_tag": "" },
//        { "id": "186094777-49262093617-1399", "author": "186116107@N07", "authorname": "ravinderemail0001", "raw": "buildings", "_content": "buildings", "machine_tag": "" },
//        { "id": "186094777-49262093617-102", "author": "186116107@N07", "authorname": "ravinderemail0001", "raw": "old", "_content": "old", "machine_tag": "" },
//        { "id": "186094777-49262093617-1223", "author": "186116107@N07", "authorname": "ravinderemail0001", "raw": "clouds", "_content": "clouds", "machine_tag": "" },
//        { "id": "186094777-49262093617-169", "author": "186116107@N07", "authorname": "ravinderemail0001", "raw": "trees", "_content": "trees", "machine_tag": "" },
//        { "id": "186094777-49262093617-623", "author": "186116107@N07", "authorname": "ravinderemail0001", "raw": "cars", "_content": "cars", "machine_tag": "" },
//        { "id": "186094777-49262093617-192", "author": "186116107@N07", "authorname": "ravinderemail0001", "raw": "roof", "_content": "roof", "machine_tag": "" },
//        { "id": "186094777-49262093617-61577", "author": "186116107@N07", "authorname": "ravinderemail0001", "raw": "surroundings", "_content": "surroundings", "machine_tag": "" },
//        { "id": "186094777-49262093617-73", "author": "186116107@N07", "authorname": "ravinderemail0001", "raw": "park", "_content": "park", "machine_tag": "" }
//        ] },
//        "urls": {
//        "url": [
//        { "type": "photopage", "_content": "https:\/\/www.flickr.com\/photos\/186116107@N07\/49262093617\/" }
//        ] }, "media": "photo" }, "stat": "ok" }

import java.util.List;

/**
 * Immutable model class for a PhotoDetailedInfo
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
                private String type;

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
