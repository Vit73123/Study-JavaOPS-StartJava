package com.startjava.graduation;

public class Book {

    private String name = "";
    private String author = "";
    private int year;
    private int len = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
        setLen();
    }

    public void setAuthor(String author) {
        this.author = author.trim();
        setLen();
    }

    public void setYear(int year) {
        this.year = year;
        setLen();
    }

    public int getLen() {
        return len;
    }

    public void setLen() {
        len = name.length() + author.length() + String.valueOf(year).length();
    }

    public String toString() {
        return name + ", " + author + ", " + year;
    }
}