package com.teros.data_control_manager.controller;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class InputRestController {

    @GetMapping("/**")
    public String inputData(@RequestHeader Map<String, String> headers, @RequestBody String body) {

        headers.forEach((key, value) -> {
            log.info(String.format("Header '%s' = %s", key, value));
        });

        return body;

    }
}