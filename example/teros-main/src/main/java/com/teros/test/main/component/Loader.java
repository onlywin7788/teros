package com.teros.test.main.component;

import com.component.teros.connector.spec.MessageConnectorSpec;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class Loader {

    // global Option
    String interfaceName;
    String interfaceVersion;
    String interfacePattern;

    public void load(String filePath) throws Exception{
        try {
            loadConfig(filePath);
            loadComponent();
        } catch (Exception e) {
            throw e;
        }
    }

    private void loadConfig(String filePath) throws Exception {
    }

    public void loadComponent() throws Exception {
        try {

            Class loadInputConnector = Class.forName("com.component.teros.connector.rest.Executor");
            Object inputConnectorInstance = loadInputConnector.getDeclaredConstructor().newInstance();
            MessageConnectorSpec inputConnector = (MessageConnectorSpec) inputConnectorInstance;
            inputConnector.initialize();

        } catch (Exception e) {
            throw e;
        }
    }
}
