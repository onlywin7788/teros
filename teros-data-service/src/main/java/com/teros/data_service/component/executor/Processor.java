package com.teros.data_service.component.executor;


import com.ext.teros.message_connector.spec.MessageConnectorSpec;
import com.ext.teros.message_processor.spec.MessageProcessorSpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Processor{

    private final String PATTERN_SNDR = "SMDR";
    private final String PATTERN_RCVR = "RCVR";
    private final String PATTERN_REPLY = "REPLY";
    private final String PATTERN_REQUEST = "REQUEST";

    // component
    MessageConnectorSpec inputConnector = null;
    MessageConnectorSpec outputConnector = null;
    MessageProcessorSpec messageProcessor = null;

    private final Loader loader;

    public Processor(Loader loader) {
        this.loader = loader;
    }

    public Loader getLoader() {
        return this.loader;
    }

    public void load(String configPath) throws Exception {
        loader.load(configPath);

        inputConnector = loader.getInputConnector();
        messageProcessor = loader.getMessageProcessor();
        outputConnector = loader.getOutputConnector();

    }

    public void initialize() throws Exception {
        inputConnector.initialize();
        outputConnector.initialize();
    }

    public void connect() throws Exception {
        inputConnector.connect();
        outputConnector.connect();
    }

    public void disconnect() throws Exception {
        inputConnector.disconnect();
        outputConnector.disconnect();
    }

    public void uninitialize() throws Exception {
        inputConnector.uninitialize();
        outputConnector.uninitialize();
    }

    public void processSNDR() throws Exception {
    }

    public void processRCVR() throws Exception {
    }

    public void processREPLY() throws Exception {
    }

    public void processREQUEST() throws Exception {
    }

    public void process() throws Exception {

//        String pattern = loader.getInterfacePattern();

        String pattern = PATTERN_SNDR;

        if (pattern.equals(PATTERN_SNDR) == true) {
            processSNDR();
        } else if (pattern.equals(PATTERN_SNDR) == true) {
            processSNDR();
        } else if (pattern.equals(PATTERN_SNDR) == true) {
            processSNDR();
        } else if (pattern.equals(PATTERN_SNDR) == true) {
            processSNDR();
        } else {
            log.error(String.format("unknown interface pattern : [%s]", pattern));
        }
    }
}
