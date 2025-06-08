package com.example.fishapp.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.fishapp.model.Fish;
import com.example.fishapp.repository.FishRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;






@Controller
public class FishController {
    @Autowired
    private FishRepository fishRepository;

    @GetMapping("/fish")
    public String listFish(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        Model model) {
            org.springframework.data.domain.Page<Fish> fishPage = fishRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("fishPage", fishPage);
        return "fish-list";
    }
    
    @GetMapping("/fish/add")
    public String showAddForm(Model model) {
        model.addAttribute("fish", new Fish());
        return "fish-add";
    }

    @PostMapping("/fish/add")
    public String addFish(
        @Valid Fish fish, BindingResult bindingResult, Model model,
        @RequestParam String name,
        @RequestParam int price,
        @RequestParam(required = false) String feature,
        @RequestParam(required = false) String review,
        @RequestParam(required = false) LocalDate history
        ) {
        if (bindingResult.hasErrors()) {
            return "fish-add";
        }
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
        Fish fish = fishRepository.findById(id).orElseThrow();  // idで検索
        model.addAttribute("fish", fish);
        return "fish-edit"; // 編集用のHTML
}

    @PostMapping("/fish/update")
    public String updateFish(
        @Valid Fish fish, BindingResult bindingResult, Model model,
        @RequestParam Long id,
        @RequestParam String name,
        @RequestParam int price,
        @RequestParam(required = false) String feature,
        @RequestParam(required = false) String review,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate history
        ) {
        Fish updateFish = fishRepository.findById(id).orElse(null);
        updateFish.setName(name);
        updateFish.setPrice(price);
        updateFish.setFeature(feature);
        updateFish.setReview(review);
        updateFish.setHistory(history);
        fishRepository.save(updateFish);
        
        return "redirect:/fish";
    }
    
    @PostMapping("/fish/delete")
    public String deleteFish(@RequestParam Long id) {
        fishRepository.deleteById(id);
        
        return "redirect:/fish";
    }

    @GetMapping("/fish/search")
    public String searchFish(@RequestParam String keyword,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int size,
                            Model model) {
        org.springframework.data.domain.Page<Fish> fishPage = fishRepository.findByNameContaining(keyword, PageRequest.of(page, size));
        model.addAttribute("fishPage", fishPage);
        model.addAttribute("keyword", keyword);
        return "fish-list";
    }
    
    
}
