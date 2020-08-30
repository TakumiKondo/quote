package com.quote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JewelyController {

    @GetMapping("/jewely")
    public String getHome(Model model) {
        model.addAttribute("contents", "jewely::jewely_contents");
        return "home/homeLayout";
    }
}
