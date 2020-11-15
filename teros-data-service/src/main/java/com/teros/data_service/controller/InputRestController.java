package com.teros.data_service.controller;

import com.ctc.wstx.sw.EncodingXmlWriter;
import com.teros.data_service.service.executor.ExecutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class InputRestController {

    @Value("${extra.param.teros_home}")
    private String terosHome;

    @Value("${extra.param.interface_id}")
    private String interfaceId;

    private boolean isInit = false;

    private final ExecutorService executorService;

    public InputRestController(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @RequestMapping(value = "/**", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public String inputData(@RequestHeader Map<String, String> headers, @RequestBody String body) {
        try {

            if(isInit == false) {
                executorService.load(terosHome, interfaceId);
                isInit = true;
            }

            executorService.executeAssignData(body);
            executorService.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }
}