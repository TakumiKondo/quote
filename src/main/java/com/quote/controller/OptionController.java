package com.quote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OptionController {

    @GetMapping("/option")
    public String getHome(Model model) {
        model.addAttribute("contents", "option::option_contents");
        return "home/homeLayout";
    }
}
