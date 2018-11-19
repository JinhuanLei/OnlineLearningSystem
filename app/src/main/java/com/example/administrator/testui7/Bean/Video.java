package com.example.administrator.testui7.Bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Administrator on 2017/4/12.
 */

public class Video extends BmobObject{
    private String videoName;
    private Integer rating;
    private Integer price;
    private Integer numPlaying;
    private String auther;
    private BmobFile videoFile;
    private BmobFile videoImg;
    private String videoInt;

    public String getVideoInt() {
        return videoInt;
    }

    public void setVideoInt(String videoInt) {
        this.videoInt = videoInt;
    }

    public BmobFile getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(BmobFile videoImg) {
        this.videoImg = videoImg;
    }

    public BmobFile getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(BmobFile videoFile) {
        this.videoFile = videoFile;
    }
    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public Integer getNumPlaying() {
        return numPlaying;
    }

    public void setNumPlaying(Integer numPlaying) {
        this.numPlaying = numPlaying;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

}
