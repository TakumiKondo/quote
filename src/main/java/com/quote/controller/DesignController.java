package com.quote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.quote.service.DesignService;

@Controller
public class DesignController {
	@Autowired
	DesignService service;

    @GetMapping("/design")
    public String getList(Model model) {
        model.addAttribute("contents", "design::design_contents");
        model.addAttribute("designs", service.getList());
        return "home/homeLayout";
    }

}
