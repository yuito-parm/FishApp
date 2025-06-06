package com.example.fishapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fishapp.model.Fish;
import com.example.fishapp.model.History;

public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findByFish(Fish fish);
    
}
