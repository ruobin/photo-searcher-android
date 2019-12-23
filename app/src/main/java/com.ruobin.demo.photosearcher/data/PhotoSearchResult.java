package com.ruobin.demo.photosearcher.data;


//{ "photos":{"page":1,"pages":"3934","perpage":100,"total":"393394",
//        "photo":[
//        {"id":"49262093617","owner":"186116107@N07","secret":"0584567f63","server":"65535","farm":66,"title":"Old building","ispublic":1,"isfriend":0,"isfamily":0},
//        {"id":"49261418598","owner":"11168644@N07","secret":"588f5d93f3","server":"65535","farm":66,"title":"","ispublic":1,"isfriend":0,"isfamily":0},
//        {"id":"49262083432","owner":"185945797@N04","secret":"04846a3a8d","server":"65535","farm":66,"title":"No escape","ispublic":1,"isfriend":0,"isfamily":0},
//        {"id":"49261875171","owner":"125532120@N06","secret":"7022d3b734","server":"65535","farm":66,"title":"EI-DBK, Boeing 777-200ER, Alitalia, Los Angeles","ispublic":1,"isfriend":0,"isfamily":0},
//        {"id":"49262038152","owner":"26982917@N02","secret":"3d9d0b0b9e","server":"65535","farm":66,"title":"Mazda, MX-5, Shek O, Hong Kong","ispublic":1,"isfriend":0,"isfamily":0}
//        ]
//        }


public class PhotoSearchResult {

    public PhotoResponse getPhotos() {
        return photos;
    }

    public String getStat() {
        return stat;
    }

    private PhotoResponse photos;

    private String stat;

}
