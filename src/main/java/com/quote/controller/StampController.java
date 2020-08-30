package com.quote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StampController {

    @GetMapping("/stamp")
    public String getHome(Model model) {
        model.addAttribute("contents", "stamp::stamp_contents");
        return "home/homeLayout";
    }
}
