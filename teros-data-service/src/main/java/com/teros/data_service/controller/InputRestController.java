package com.teros.data_service.controller;

import com.ctc.wstx.sw.EncodingXmlWriter;
import com.teros.data_service.service.executor.ExecutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class InputRestController {

    private final ExecutorService executorService;

    public InputRestController(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @GetMapping("/**")
    public String inputData(@RequestHeader Map<String, String> headers, @RequestBody String body) {

        log.info("REST GET........!!");

        try {

            executorService.load("TEST");
            executorService.executeAssignData(body);
            executorService.execute();
            executorService.unload();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;

    }
}