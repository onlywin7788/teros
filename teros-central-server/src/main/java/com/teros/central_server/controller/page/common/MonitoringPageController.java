package com.teros.central_server.controller.page.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonitoringPageController {

    @GetMapping("/monitoring/service")
    public String developmentList(Model model) {
        return "contents/monitoring/service/list";
    }
}
