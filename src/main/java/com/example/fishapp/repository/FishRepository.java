package com.example.fishapp.repository;
import com.example.fishapp.model.Fish;
import java.util.ArrayList;
import java.util.List;

public class FishRepository {
    private List<Fish> fishList = new ArrayList<>();

    public List<Fish> findAll() {
        return fishList;
    }

    public void save(Fish fish) {
        fishList.add(fish);
    }
}
