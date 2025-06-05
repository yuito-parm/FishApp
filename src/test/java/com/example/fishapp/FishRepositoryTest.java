package com.example.fishapp;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.fishapp.model.Fish;
import com.example.fishapp.repository.FishRepository;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class FishRepositoryTest {
    @Autowired
    FishRepository fishRepository;

    @Test
    void 登録した魚が保存されていること () {
        Fish fish = new Fish();
        fish.setName("テスト魚");
        fish.setPrice(100);
        fish.setFeature("テスト特徴");
        fish.setReview("テストレビュー");
        fish.setHistory(LocalDate.of(2024, 6, 1));

        Fish savedFish = fishRepository.save(fish);

        Fish found = fishRepository.findById(savedFish.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("テスト魚");
    }
}
