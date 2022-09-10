package com.startjava.graduation;

public class Book {

    private String name = "";
    private String author = "";
    private int year;
    public static final int FIX_NAME_SIZE = 35;
    public static final int FIX_AUTHOR_SIZE = 25;
    public static final int FIX_YEAR_SIZE = 4;
    public static final int FIX_SIZE = FIX_NAME_SIZE + FIX_AUTHOR_SIZE + FIX_YEAR_SIZE;
    public static final int INFO_LEN = FIX_SIZE + 15;

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

    public int getSize() {
        return (name.isBlank() ? FIX_NAME_SIZE : name.length()) +
                (author.isBlank() ? FIX_AUTHOR_SIZE : author.length()) +
                FIX_YEAR_SIZE;
    }

    public String toReportString() {
        return String.format("| %-" + FIX_AUTHOR_SIZE + "s | %-" + FIX_NAME_SIZE + "s | %" + FIX_YEAR_SIZE +
                        "d |",
                BookshelfMain.leftString(author, FIX_AUTHOR_SIZE),
                BookshelfMain.leftString(name, FIX_NAME_SIZE),
                year);
    }
}