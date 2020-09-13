package com.quote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quote.form.DesignForm;
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


    @GetMapping("/design/add")
    public String getAdd(@ModelAttribute DesignForm form, Model model) {
        model.addAttribute("contents", "design_add::design_contents");
        model.addAttribute("form", "design_form::design_form");
        model.addAttribute("designForm", form);
        model.addAttribute("action", "insert");
        return "home/homeLayout";
    }


    @PostMapping("/design/create")
    public String postCreate(@ModelAttribute @Validated DesignForm form, BindingResult error, Model model) {
    	if(error.hasErrors())
    		return getAdd(form, model);
    	service.insert(form);
        return getList(model);
    }


    @GetMapping("/design/edit/{cd:.+}")
    public String getEdit(@ModelAttribute DesignForm form, Model model) {
    	form = service.selectOne(form);
    	model.addAttribute("contents", "design_edit::design_contents");
        model.addAttribute("form", "design_form::design_form");
        model.addAttribute("designForm", form);
        model.addAttribute("action", "update");
        return "home/homeLayout";
    }


    @PostMapping("/design/update")
    public String postUpdate(@ModelAttribute @Validated DesignForm form, BindingResult error, Model model) {
    	if(service.isUpdated(form))
    		error.rejectValue("cd", "", "既に他のユーザが更新済みです。");
    	if(error.hasErrors()) {
        	model.addAttribute("contents", "design_edit::design_contents");
            model.addAttribute("form", "design_form::design_form");
            model.addAttribute("designForm", form);
            model.addAttribute("action", "update");
            return "home/homeLayout";
    	}
    	service.update(form);
    	return getList(model);
    }


    @PostMapping("/design/delete")
    public String postDelete(@ModelAttribute @Validated DesignForm form, BindingResult error, Model model) {
    	if(service.isUpdated(form)) {
    		model.addAttribute("isUpdated", "既に他のユーザが更新済みのため、削除できませんでした。");
    		return getList(model);
    	}
    	service.delete(form);
    	return getList(model);
    }
}
