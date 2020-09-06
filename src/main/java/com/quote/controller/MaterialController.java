package com.quote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quote.form.MaterialForm;
import com.quote.service.MaterialService;
@Controller
public class MaterialController {
	@Autowired
	MaterialService service;

    @GetMapping("/material")
    public String getMaterial(Model model) {
        model.addAttribute("contents", "material::material_contents");
        model.addAttribute("materials", service.getList());
        return "home/homeLayout";
    }

    @GetMapping(value="/material_edit", params="insert")
    public String getMaterialEdit(@ModelAttribute MaterialForm materialForm, Model model) {
        model.addAttribute("contents", "material_edit::material_contents");
        model.addAttribute("materialForm", materialForm);
        model.addAttribute("action", "insert");
        return "home/homeLayout";
    }

	@PostMapping("/material_edit")
    public String postMaterialEdit(@ModelAttribute @Validated MaterialForm form, BindingResult error, Model model) {
		if(service.existCd(form))
			error.rejectValue("cd", "", "既に登録済みの材料コードです。");
		if(error.hasErrors())
			return getMaterialEdit(form, model);

		service.insert(form);
        return getMaterial(model);
    }
}
