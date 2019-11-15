package com.example.assignment3;

import com.google.gson.annotations.SerializedName;

public class Item{

    private String id;

    private String name;

    private Weight weight;

    private String description;

    private String temperament;

    private String origin;

    @SerializedName("life_span")
    private String lifeSpan;

    @SerializedName("child_friendly")
    private String childFriendly;

    @SerializedName("dog_friendly")
    private String dogFriendly;

    @SerializedName("stranger_friendly")
    private String strangerFriendly;

    @SerializedName("wikipedia_url")
    private String wikipediaLink;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Weight getWeight() {
        return weight;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public String getLifespan() {
        return lifeSpan;
    }

    public String getChildFriendly() {
        return childFriendly;
    }

    public String getDogFriendly() {
        return dogFriendly;
    }

    public String getStrangerFriendly() {
        return strangerFriendly;
    }

    public String getWikipediaLink() {
        return wikipediaLink;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setLifespan(String lifespan) {
        this.lifeSpan = lifespan;
    }

    public void setChildFriendly(String childFriendly) {
        this.childFriendly = childFriendly;
    }

    public void setDogFriendly(String dogfriendly){
        this.dogFriendly = dogfriendly;
    }

    public void setStrangerFriendly(String strangerfriendly) {
        this.strangerFriendly = strangerfriendly;
    }

    public void setWikipediaLink(String wikipediaLink) {
        this.wikipediaLink = wikipediaLink;
    }

    public class Weight{

        private String imperial;
        private String metric;

        public String getImperial() {
            return imperial;
        }

        public void setImperial(String imperial) {
            this.imperial = imperial;
        }

        public String getMetric() {
            return metric;
        }

        public void setMetric(String metric) {
            this.metric = metric;
        }
    }
}