package com.startjava.graduation;

public class Book {

    private String name = "";
    private String author = "";
    private int year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim();
        this.name = name;
    }

    public void setAuthor(String author) {
        author = author.trim();
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLen() {
        return name.length() + author.length() + String.valueOf(year).length();
    }

    public String toString() {
        return name + ", " + author + ", " + year;
    }
}