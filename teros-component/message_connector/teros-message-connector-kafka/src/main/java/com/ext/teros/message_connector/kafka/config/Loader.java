package com.ext.teros.message_connector.kafka.config;

import com.ext.teros.message_connector.kafka.common.parser.JsonParser;
import com.ext.teros.message_connector.kafka.config.model.Connection;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Loader {

    private Connection connection;
    private JsonParser jsonParser;

    public Loader() {
        connection = new Connection();
        jsonParser = new JsonParser();
    }

    public void loadConfig(String configString) {

        String configValue = "";

        configValue = jsonParser.getJsonElementFromPath(configString, "connection.host").getAsString();
        connection.setHost(configValue);
        configValue = jsonParser.getJsonElementFromPath(configString, "connection.port").getAsString();
        connection.setPort(configValue);
        configValue = jsonParser.getJsonElementFromPath(configString, "connection.topic").getAsString();
        connection.setTopic(configValue);
    }
}
