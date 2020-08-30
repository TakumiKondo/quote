package com.quote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BenefitController {

    @GetMapping("/benefit")
    public String getHome(Model model) {
        model.addAttribute("contents", "benefit::benefit_contents");
        return "home/homeLayout";
    }
}
