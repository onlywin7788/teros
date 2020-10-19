package com.teros.service_registry.controller.v1.info;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;


@RestController
@CrossOrigin(origins="*")
public class InfoController {

    @GetMapping(value = "/v1/apps", produces = "application/json; charset=UTF-8")
    public String getApps() {

        String urlPath = "/eureka/apps";
        String url = "http://localhost:8761" + urlPath;

        LocalDateTime currentDateTime = LocalDateTime.now();
        ResponseEntity<String> entity = RequestRouter(url);

        return entity.getBody();
    }

    public ResponseEntity<String> RequestRouter(String url)
    {
        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
        headerMap.add("Content-Type", MediaType.APPLICATION_XML_VALUE);

        HttpEntity<?> headers = new HttpEntity<>(headerMap);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, headers, String.class);

        return responseEntity;
    }

}
