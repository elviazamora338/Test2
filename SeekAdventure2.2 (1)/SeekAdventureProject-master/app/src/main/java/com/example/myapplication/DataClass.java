package com.example.myapplication;


public class DataClass {

    private String title;
    private String dataMoments;
    private String dataFacts;
    private String dataActivities;
    private String dataImage;
    private String key;
    private String date;
    private String location;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataTitle() { return title; }

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
        return date;
    }

    public String getDataLocation() {
        return location;
    }

    public DataClass(String title, String dataMoments, String dataFacts, String dataActivities, String dataImage, String date, String location) {
        this.title = title;
        this.dataMoments = dataMoments;
        this.dataFacts = dataFacts;
        this.dataActivities = dataActivities;
        this.dataImage = dataImage;
        this.date = date;
        this.location = location;
    }
    public DataClass(){

    }
}
