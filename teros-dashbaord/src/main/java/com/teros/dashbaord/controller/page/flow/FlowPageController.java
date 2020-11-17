package com.teros.dashbaord.controller.page.flow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlowPageController {

    @GetMapping("/flow/design")
    public String flowDesign(Model model) {
        return "contents/flow/development/contents";
    }

    @GetMapping("/flow/module/drawflow")
    public String moduleDrawFlow(Model model) {
        return "contents/flow/development/module/drawflow";
    }
}
