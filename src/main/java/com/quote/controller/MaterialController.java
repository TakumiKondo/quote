package com.quote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quote.domain.model.Material;
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


    @GetMapping(value="/material/add")
    public String getEditAdd(@ModelAttribute MaterialForm materialForm, Model model) {
        model.addAttribute("contents", "material_add::material_contents");
        model.addAttribute("form", "material_form::material_form");
        model.addAttribute("materialForm", materialForm);
        model.addAttribute("action", "insert");
        return "home/homeLayout";
    }


    @GetMapping(value="/material/edit/{cd:.+}")
    public String getEditUpdate(@ModelAttribute MaterialForm materialForm, Model model) {
    	//TODO 存在しないコードがリクエストされた場合に、403ページを表示する
    	materialForm = service.selectOne(materialForm);
    	return getEdit(materialForm, model);
    }


    /**
     * BindingResultを保持するために、Modelが上書きされないよう別のメソッドで編集画面に戻す
     * @param materialForm
     * @param model
     * @return
     */
    private String getEditError(@ModelAttribute MaterialForm materialForm, Model model) {
        return getEdit(materialForm, model);
    }


    private String getEdit(MaterialForm materialForm, Model model) {
        model.addAttribute("contents", "material_edit::material_contents");
        model.addAttribute("form", "material_form::material_form");
        model.addAttribute("materialForm", materialForm);
        model.addAttribute("action", "update");
        return "home/homeLayout";
    }

	@PostMapping("/material/create")
    public String postMaterialCreate(@ModelAttribute @Validated MaterialForm form, BindingResult error, Model model) {
		if(service.existCd(form))
			error.rejectValue("cd", "", "既に登録済みの材料コードです。");
		if(error.hasErrors())
			return getEditAdd(form, model);
		service.insert(form);
        return getMaterial(model);
    }


	@PostMapping("/material/update")
    public String postUpdate(@ModelAttribute @Validated MaterialForm form, BindingResult error, Model model) {
		if(error.hasErrors())
			return getEditError(form, model);

		try {
			service.update(form);
		} catch (ObjectOptimisticLockingFailureException e) {
			error.rejectValue("cd", "", "既に他のユーザが更新済みです。一覧に戻ってご確認下さい。");
			return getEditError(form, model);
		}
        return "redirect:/material";
    }


	@PostMapping("/material/delete")
    public String postDelete(@ModelAttribute MaterialForm form, @Validated Material m, BindingResult error, Model model) {
		try {
			service.delete(form);
		} catch (ObjectOptimisticLockingFailureException e) {
			model.addAttribute("isUpdated", "既に他のユーザが更新済みです。");
		}
        return getMaterial(model);
    }
}
