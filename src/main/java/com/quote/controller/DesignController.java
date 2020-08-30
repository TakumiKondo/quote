package com.quote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DesignController {

    @GetMapping("/design")
    public String getHome(Model model) {
        model.addAttribute("contents", "design::design_contents");
        return "home/homeLayout";
    }
}
