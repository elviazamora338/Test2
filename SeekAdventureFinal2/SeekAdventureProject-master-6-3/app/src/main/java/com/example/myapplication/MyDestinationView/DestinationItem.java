package com.example.myapplication.MyDestinationView;

public class DestinationItem {
    String destinationName, destinationDesc, destinationCrime, destinationAttractions, destinationWeather;
    int destinationImage;

    public DestinationItem(String destinationName, String destinationDesc, String destinationCrime, String destinationAttractions,
                           String destinationWeather, int destinationImage) {
        this.destinationName = destinationName;
        this.destinationDesc = destinationDesc;
        this.destinationCrime = destinationCrime;
        this.destinationAttractions = destinationAttractions;
        this.destinationWeather = destinationWeather;
        this.destinationImage = destinationImage;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public String getDestinationDesc() { return destinationDesc; }

    public String getDestinationCrime() {
        return destinationCrime;
    }

    public String getDestinationAttractions() {
        return destinationAttractions;
    }

    public String getDestinationWeather() {
        return destinationWeather;
    }

    public int getDestinationImage() {
        return destinationImage;
    }

}
