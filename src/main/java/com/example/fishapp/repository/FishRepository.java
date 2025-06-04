package com.example.fishapp.repository;
import com.example.fishapp.model.Fish;
import java.util.ArrayList;
import java.util.List;

public class FishRepository {
    private List<Fish> fishList = new ArrayList<>();
    private Long nextId = 1L; 

    public List<Fish> findAll() {
        return fishList;
    }

    public Fish findById(Long id) {
        for (Fish fish : fishList) {
            if (fish.getId() !=null && fish.getId().equals(id)) {
                return fish;
            }
        }
        return null;
    }

    public void save(Fish fish) {
        if (fish.getId() == null) {
            fish.setId(nextId++);
        }
        fishList.add(fish);
    }

    public void deleteById(Long id) {
        fishList.removeIf(fish -> fish.getId().equals(id));
    }
}
