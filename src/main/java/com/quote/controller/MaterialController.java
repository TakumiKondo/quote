package com.quote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MaterialController {

    @GetMapping("/material")
    public String getHome(Model model) {
        model.addAttribute("contents", "material::material_contents");
        return "home/homeLayout";
    }
}
