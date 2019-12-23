package com.ruobin.demo.photosearcher.data;


//{"id":"49262093617","owner":"186116107@N07","secret":"0584567f63","server":"65535","farm":66,"title":"Old building","ispublic":1,"isfriend":0,"isfamily":0},

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
