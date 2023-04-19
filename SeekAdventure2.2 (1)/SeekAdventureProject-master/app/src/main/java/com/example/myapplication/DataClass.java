package com.example.myapplication;


public class DataClass {

    private String dataMoments;
    private String dataFacts;
    private String dataActivities;
    private String dataImage;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String dataMoments() {
        return dataMoments;
    }

    public String dataFacts() {
        return dataFacts;
    }

    public String dataActivities() {
        return dataActivities;
    }

    public String getDataImage() {
        return dataImage;
    }

    public DataClass(String dataMoments, String dataFacts, String dataActivities, String dataImage) {
        this.dataMoments = dataMoments;
        this.dataFacts = dataFacts;
        this.dataActivities = dataActivities;
        this.dataImage = dataImage;
    }
    public DataClass(){

    }
}
