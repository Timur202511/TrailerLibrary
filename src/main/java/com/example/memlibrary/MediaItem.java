package com.example.memlibrary;

public class MediaItem {

    private String title;
    private String videoPath;
    private double imdbRating;
    private String myOpinion;


    public MediaItem(String title, String videoPath, double imdbRating, String myOpinion){

        this.title = title;
        this.videoPath = videoPath;
        this.imdbRating = imdbRating;
        this.myOpinion = myOpinion;
    }


    public String getTitle(){
        return title;
    }

    public String getVideoPath(){
        return videoPath;
    }

    public double getImdbRating(){
        return imdbRating;
    }
    public String getMyOpinion(){
        return myOpinion;
    }
}