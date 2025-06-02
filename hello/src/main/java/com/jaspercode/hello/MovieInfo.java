package com.jaspercode.hello;

public class MovieInfo {
    private String name;

    public MovieInfo(){
    }

    public MovieInfo(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
}
