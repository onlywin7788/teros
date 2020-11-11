package com.teros.data_service.component.executor;


import com.ext.teros.message_connector.spec.MessageConnectorSpec;
import com.ext.teros.message_processor.spec.MessageProcessorSpec;
import com.teros.data_service.common.parser.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Processor {

    private final String PATTERN_SNDR = "SMDR";
    private final String PATTERN_RCVR = "RCVR";
    private final String PATTERN_REPLY = "REPLY";
    private final String PATTERN_REQUEST = "REQUEST";

    // component
    MessageConnectorSpec inputConnector = null;
    MessageConnectorSpec outputConnector = null;
    MessageProcessorSpec messageProcessor = null;

    private final JsonParser jsonParser;
    private final Loader loader;

    public Processor(JsonParser jsonParser, Loader loader) {
        this.jsonParser = jsonParser;
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

        String contents = loader.getConfigContents();
        loadConfig(contents);
    }

    public void loadConfig(String configContents) throws Exception {

        String inputConfig = jsonParser.getJsonElementFromPath(configContents, "config.interface.input").toString();
        String processorConfig = jsonParser.getJsonElementFromPath(configContents, "config.interface.processor").toString();
        String outputConfig = jsonParser.getJsonElementFromPath(configContents, "config.interface.output").toString();

        // input connector
        inputConnector.loadConfig(inputConfig);
        log.info(String.format("load component::input Connector => type :[%s], version:[%s]"
                , inputConnector.getConnectorType(), inputConnector.getConnectorVersion()));

        // message processor
        messageProcessor.loadConfig(processorConfig);
        log.info(String.format("load component::message processor => version:[%s]"
                , inputConnector.getConnectorVersion()));

        // output connector
        outputConnector.loadConfig(outputConfig);
        log.info(String.format("load component::output Connector => type :[%s], version:[%s]"
                , inputConnector.getConnectorType(), inputConnector.getConnectorVersion()));
    }

    public void initialize() throws Exception {
        inputConnector.initialize();
        outputConnector.initialize();
    }

    public void connect() throws Exception {
        inputConnector.connect();
        outputConnector.connect();
    }

    public void open() throws Exception {
        inputConnector.open();
        outputConnector.open();
    }

    public void disconnect() throws Exception {
        inputConnector.disconnect();
        outputConnector.disconnect();
    }

    public void close() throws Exception {
        inputConnector.close();
        outputConnector.close();
    }


    public void uninitialize() throws Exception {
        inputConnector.uninitialize();
        outputConnector.uninitialize();
    }

    public void inputConnectorSetData(String data) throws Exception {
        inputConnector.setData(data);
    }

    public String inputConnectorGetData() throws Exception {
        return inputConnector.getData();
    }

    public void outputConnectorSetData(String data) throws Exception {
        outputConnector.setData(data);
    }

    public String  outputConnectorGetData(String data) throws Exception {
        return outputConnector.getData();
    }


    public void processSNDR() throws Exception {

        String data = "";


        /*--------------------- input --------------------------*/

        log.info(String.format("Execute input Connector => type :[%s], version:[%s]"
                , inputConnector.getConnectorType(), inputConnector.getConnectorVersion()));

        inputConnector.input();
        data = inputConnector.getData();
        log.info(data);

        /*--------------------- processor --------------------------*/

        log.info(String.format("Execute Message Processor => type :[%s], version:[%s]"
                , messageProcessor.getProcessorType(), messageProcessor.getProcessorVersion()));

        // input filter
        data = messageProcessor.inputFilter(data);

        messageProcessor.input(data);
        messageProcessor.process();
        data = messageProcessor.output();

        // output filter
        data = messageProcessor.outputFilter(data);
        log.info(data);

        /*--------------------- output --------------------------*/

        log.info(String.format("Execute output Connector => type :[%s], version:[%s]"
                , outputConnector.getConnectorType(), outputConnector.getConnectorVersion()));

        outputConnector.setData(data);
        outputConnector.output();
        log.info(data);

    }

    public void processRCVR() throws Exception {
    }

    public void processREPLY() throws Exception {
    }

    public void processREQUEST() throws Exception {
    }

    public void process() throws Exception {

        String pattern = PATTERN_SNDR;

        initialize();
        connect();
        open();

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

        close();
        disconnect();
        uninitialize();
    }
}
