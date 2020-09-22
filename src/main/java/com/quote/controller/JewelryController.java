package com.quote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.quote.service.JewelryService;

@Controller
public class JewelryController {
	@Autowired
	JewelryService service;

    @GetMapping("/jewelry")
    public String getList(Model model) {
        model.addAttribute("contents", "jewelry::jewelry_contents");
        model.addAttribute("jewelries", service.getList());
        return "home/homeLayout";
    }
}
