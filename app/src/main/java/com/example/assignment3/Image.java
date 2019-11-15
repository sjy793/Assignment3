package com.example.assignment3;

import java.util.List;

public class Image {

    public String id;
    public String url;

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
