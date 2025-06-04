package com.example.fishapp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.fishapp.model.Fish;
import com.example.fishapp.repository.FishRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;






@Controller
public class FishController {
    @Autowired
    private FishRepository fishRepository;

    @GetMapping("/fish")
    public String listFish(Model model) {
        model.addAttribute("fishList", fishRepository.findAll());
        return "fish-list";
    }
    
    @GetMapping("/fish/add")
    public String showAddForm() {
        return "fish-add";
    }

    @PostMapping("/fish/add")
    public String addFish(
        @RequestParam String name,
        @RequestParam int price,
        @RequestParam(required = false) String feature,
        @RequestParam(required = false) String review,
        @RequestParam(required = false) LocalDate history
        ) {
        Fish fish = new Fish();
        fish.setName(name);
        fish.setPrice(price);
        fish.setFeature(feature);
        fish.setReview(review);
        fish.setHistory(history);
        fishRepository.save(fish);
        
        return "redirect:/fish";
    }
    
    @GetMapping("/fish/edit/{id}")
        public String showEditForm(@PathVariable Long id, Model model) {
        Fish fish = fishRepository.findById(id).orElse(null);  // idで検索
        model.addAttribute("fish", fish);
        return "fish-edit"; // 編集用のHTML
}

    @PostMapping("/fish/update")
    public String updateFish(
        @RequestParam Long id,
        @RequestParam String name,
        @RequestParam int price,
        @RequestParam(required = false) String feature,
        @RequestParam(required = false) String review,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate history
        ) {
        Fish fish = fishRepository.findById(id).orElse(null);
        fish.setName(name);
        fish.setPrice(price);
        fish.setFeature(feature);
        fish.setReview(review);
        fish.setHistory(history);
        
        return "redirect:/fish";
    }
    
    @PostMapping("/fish/delete")
    public String deleteFish(@RequestParam Long id) {
        fishRepository.deleteById(id);
        
        return "redirect:/fish";
    }
    
}
