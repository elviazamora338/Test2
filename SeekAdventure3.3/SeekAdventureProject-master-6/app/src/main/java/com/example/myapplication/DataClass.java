package com.example.myapplication;


public class DataClass {
    private String dataTitle;
    private String dataMoments;
    private String dataFacts;
    private String dataActivities;
    private String dataImage;
    private String key;
    private String dataDate;
    private String dataLocation;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataTitle() { return dataTitle; }

    public String getDataMoments() {
        return dataMoments;
    }

    public String getDataFacts() {
        return dataFacts;
    }

    public String getDataActivities() {
        return dataActivities;
    }

    public String getDataImage() {
        return dataImage;
    }

    public String getDataDate() {
        return dataDate;
    }

    public String getDataLocation() {
        return dataLocation;
    }

    public DataClass(String title, String dataMoments, String dataFacts, String dataActivities, String dataImage, String date, String location) {
        this.dataTitle = title;
        this.dataMoments = dataMoments;
        this.dataFacts = dataFacts;
        this.dataActivities = dataActivities;
        this.dataImage = dataImage;
        this.dataDate = date;
        this.dataLocation = location;
    }

    public DataClass(){

    }
}
