package com.example.fishapp.repository;
import com.example.fishapp.model.Fish;
import com.example.fishapp.repository.FishRepository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FishRepository extends JpaRepository<Fish, Long> {
    
    
}
