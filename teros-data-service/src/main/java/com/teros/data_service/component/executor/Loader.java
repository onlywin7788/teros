package com.teros.data_service.component.executor;

import com.ext.teros.message_connector.spec.MessageConnectorSpec;
import com.ext.teros.message_processor.spec.MessageProcessorSpec;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Loader {

    // load component
    MessageConnectorSpec inputConnector = null;
    MessageConnectorSpec outputConnector = null;
    MessageProcessorSpec messageProcessor = null;

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

    private void loadComponent() throws Exception {
        try {
            // class dynamic loading
            Class loadInputConnector = Class.forName("com.ext.teros.message_connector.rest.Executor");
            Class loadOutputConnector = Class.forName("com.ext.teros.message_connector.kafka.Executor");
            Class loadMessageProcessor = Class.forName("com.ext.teros.message_processor.Executor");

            Object inputConnectorInstance = loadInputConnector.getDeclaredConstructor().newInstance();
            Object outputConnectorInstance = loadOutputConnector.getDeclaredConstructor().newInstance();
            Object messageProcesorInstance = loadMessageProcessor.getDeclaredConstructor().newInstance();

            // upcasting super class
            inputConnector = (MessageConnectorSpec) inputConnectorInstance;
            outputConnector = (MessageConnectorSpec) outputConnectorInstance;
            messageProcessor = (MessageProcessorSpec) messageProcesorInstance;

        } catch (Exception e) {
            throw e;
        }
    }
}
