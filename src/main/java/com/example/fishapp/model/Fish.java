package com.example.fishapp.model;

import java.time.LocalDate;

public class Fish {
    private Long id;
    private String name;
    private int price;
    private String feature;
    private String review;
    private LocalDate history;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public String getFeature() { return feature; }
    public void setFeature(String feature) { this.feature = feature; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

    public LocalDate getHistory() { return history; }
    public void setHistory(LocalDate history) { this.history = history; }
}
