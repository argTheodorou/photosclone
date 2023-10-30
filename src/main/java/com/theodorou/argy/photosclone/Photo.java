package com.theodorou.argy.photosclone;

public class Photo {
    private String id;
    private String fileName;


    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public Photo() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFineName() {
        return fileName;
    }

    public void setFineName(String fineName) {
        this.fileName = fineName;
    }
}
