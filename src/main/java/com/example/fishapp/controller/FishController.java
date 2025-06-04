package com.example.fishapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.fishapp.repository.FishRepository;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FishController {
    private FishRepository fishRepository = new FishRepository();

    @GetMapping("/fish")
    public String listFish(Model model) {
        model.addAttribute("fishList", fishRepository.findAll());
        return "fish-list";
    }
    
}
