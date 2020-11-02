package com.teros.api_gateway.service.schedule;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RouteUpdateSchedule {

    @Value("${extra.env.teros_home}")
    private String baseHome;

    public String getConfigRoutePath() {
        String configPath = baseHome + File.separator + "config"
                + File.separator + "data-service" + File.separator + "data-service-router.json";
        return configPath;
    }

    @Scheduled(fixedDelay = 3000)
    public void createRoute() throws Exception {

        String configPath = getConfigRoutePath();

        if (fileExist(configPath) == true) {
            String contents = readFile(configPath);
        }
    }



    public String RequestRouter(String url) {
        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
        headerMap.add("Content-Type", MediaType.APPLICATION_XML_VALUE);

        HttpEntity<?> headers = new HttpEntity<>(headerMap);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, headers, String.class);

        return responseEntity.getBody();
    }

    public boolean fileExist(String filePath) {
        if (Files.exists(Paths.get(filePath)))
            return true;
        else
            return false;
    }

    public String readFile(String ConfigPath) {
        String contents = "";
        try {
            File file = new File(ConfigPath);
            contents = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
    }

}
