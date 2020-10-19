package com.teros.central_server.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DevelopmentPageController {

    @GetMapping("/development/api")
    public String developmentList(Model model) {
        return "contents/development/api/list";
    }

    @GetMapping("/development/api/create")
    public String developmentCreate(Model model) {
        model.addAttribute("update", 0);
        return "contents/development/api/contents";
    }

    @GetMapping("/development/api/{id}")
    public String developmentUpdate(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("update", 1);

        return "contents/development/api/contents";
    }

    @GetMapping("/development/api/module/input_method")
    public String developmentAPIModuleInputMethod(Model model) {
        return "contents/development/api/module/input_method";
    }
}
