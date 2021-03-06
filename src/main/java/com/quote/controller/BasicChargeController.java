package com.quote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quote.domain.model.BasicCharge;
import com.quote.service.BasicChargeService;

@Controller
public class BasicChargeController {

	@Autowired
	BasicChargeService service;

    @GetMapping("/basic_charge")
    public String getBasicCharge(Model model) {
        model.addAttribute("contents", "basic_charge::contents");
        model.addAttribute("basicCharge", getOne());
        return "home/homeLayout";
    }

    @GetMapping("/basic_charge_edit")
    public String getBasicChargeEdit(Model model) {
        model.addAttribute("contents", "basic_charge_edit::contents");
        model.addAttribute("basicCharge", getOne());
        return "home/homeLayout";
    }

    @PostMapping("/basic_charge_edit")
    public String postBasicChargeEdit(@ModelAttribute BasicCharge basicCharge, Model model) {
    	service.update(basicCharge);
    	return getBasicCharge(model);
    }

    /**
     * 基本料金を取得
     * @return
     */
    private BasicCharge getOne() {
    	BasicCharge basicCharge = service.getOne();
    	return basicCharge;
    }
}
