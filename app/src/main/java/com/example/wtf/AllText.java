package com.example.wtf;
//自定义小类
public class AllText {
    private String name;
    private int imageId;
    public AllText(String name,int imageId){
        this.imageId=imageId;
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
