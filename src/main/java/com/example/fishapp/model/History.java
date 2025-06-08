package com.example.fishapp.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
public class History {
    @Id @GeneratedValue
    private Long id;
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String memo;

    @ManyToOne
    @JoinColumn(name = "fish_id")
    private Fish fish;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getMemo() { return memo; }
    public void setMemo(String memo) { this.memo = memo; }

    public Fish getFish() { return fish; }
    public void setFish(Fish fish) { this.fish = fish; }
}
