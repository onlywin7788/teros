package com.teros.central_server.controller.page.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPageController {

    @GetMapping("/")
    public String hello(Model model){
        return "contents/index/index";
    }

    @GetMapping("/temp")
    public String temp(Model model){
        return "contents/temp/temp";
    }

}
