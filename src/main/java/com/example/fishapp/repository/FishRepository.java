package com.example.fishapp.repository;
import com.example.fishapp.model.Fish;
import com.example.fishapp.repository.FishRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FishRepository extends JpaRepository<Fish, Long> {
    List<Fish> findByNameContaining(String keyword);
    
}
