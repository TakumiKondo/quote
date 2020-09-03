package com.quote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quote.domain.model.Material;
import com.quote.service.MaterialService;

@Controller
public class MaterialController {
	@Autowired
	MaterialService service;

    @GetMapping("/material")
    public String getMaterial(Model model) {
        model.addAttribute("contents", "material::material_contents");
        model.addAttribute("materials", service.getList());
        System.out.println("service.getList() : " + service.getList());
        return "home/homeLayout";
    }

    @GetMapping("/material_edit")
    public String getMaterialEdit(Model model) {
        model.addAttribute("contents", "material_edit::material_contents");
        Material material = new Material();
        model.addAttribute("material", material);
        return "home/homeLayout";
    }

    @PostMapping("/material_edit")
    public String postMaterialEdit(@ModelAttribute Material material, Model model) {
//        model.addAttribute("contents", "material_edit::material_contents");
//        model.addAttribute("material", material);
        return getMaterial(model);
    }
}
