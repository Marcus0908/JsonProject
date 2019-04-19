package com.health.jsonap;

public class Data {


    public int id;
    public String name;
    public int pwd;

    public Data(int id, String name, int pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public int getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }
}
