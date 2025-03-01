package com.example.graphqldemo.model;

public class Book {
    private String id;
    private String name;
    private int pageCount;
    private String authorName;

    public Book(String id, String name, int pageCount, String authorName) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.authorName = authorName;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}