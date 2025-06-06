package com.example.fishapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

@Entity
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "名前は必須です")
    private String name;

    @Min(value = 1, message = "価格は1円以上で入力してください")
    private int price;
    private String feature;
    private String review;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    @OneToMany(mappedBy = "fish", cascade = CascadeType.ALL)
    private List<History> histories = new ArrayList<>();

    public List<History> getHistories() { return histories; }
    public void setHistories(List<History> histories) { this.histories = histories; }
}