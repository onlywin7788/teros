package com.teros.data_service.component.executor;

import com.ext.teros.message_connector.spec.MessageConnectorSpec;
import com.ext.teros.message_processor.spec.MessageProcessorSpec;
import com.teros.data_service.common.file.CommonFile;
import com.teros.data_service.common.parser.JsonParser;
import com.teros.data_service.component.executor.config.model.GlobalOption;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Loader {

    private final CommonFile commonFile;
    private final JsonParser jsonParser;

    GlobalOption inputGlobalOption = new GlobalOption();
    GlobalOption outputGlobalOption = new GlobalOption();
    GlobalOption processorGlobalOption = new GlobalOption();

    String configContents = "";

    // load component
    MessageConnectorSpec inputConnector = null;
    MessageConnectorSpec outputConnector = null;
    MessageProcessorSpec messageProcessor = null;

    // global Option
    String interfaceName;
    String interfaceVersion;
    String interfacePattern;

    public Loader(CommonFile commonFile
            , JsonParser jsonParser) {
        this.commonFile = commonFile;
        this.jsonParser = jsonParser;
    }

    public void load(String filePath) throws Exception {
        try {
            loadConfig(filePath);
            loadComponent();
        } catch (Exception e) {
            throw e;
        }
    }

    public String getConfigContents() {
        return configContents;
    }

    private void loadConfig(String filePath) throws Exception {
        configContents = commonFile.readFile(filePath);
        String optionValue = "";

        // global option - input component
        optionValue = jsonParser.getJsonElementFromPath(configContents, "config.interface.input.component.path").getAsString();
        inputGlobalOption.setPath(optionValue);

        // global option - output component
        optionValue = jsonParser.getJsonElementFromPath(configContents, "config.interface.output.component.path").getAsString();
        outputGlobalOption.setPath(optionValue);

        // global option - message processor
        optionValue = jsonParser.getJsonElementFromPath(configContents, "config.interface.processor.component.path").getAsString();
        processorGlobalOption.setPath(optionValue);

    }

    private void loadComponent() throws Exception {
        try {
            // class dynamic loading
            Class loadInputConnector = Class.forName(inputGlobalOption.getPath());
            Class loadOutputConnector = Class.forName(outputGlobalOption.getPath());
            Class loadMessageProcessor = Class.forName(processorGlobalOption.getPath());

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
