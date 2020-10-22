package com.teros.central_server.controller.page.apim;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class APIMPageController {

    @GetMapping("/apim/api/development")
    public String developmentList(Model model) {
        return "contents/apim/api/development/list";
    }

    @GetMapping("/apim/api/development/create")
    public String developmentCreate(Model model) {
        model.addAttribute("update", 0);
        return "contents/apim/api/development/contents";
    }

    @GetMapping("/apim/api/development/{id}")
    public String developmentUpdate(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("update", 1);

        return "contents/apim/api/development/contents";
    }

    @GetMapping("/apim/api/development/module/input_method")
    public String developmentAPIModuleInputMethod(Model model) {
        return "contents/apim/api/development/module/input_method";
    }
}
