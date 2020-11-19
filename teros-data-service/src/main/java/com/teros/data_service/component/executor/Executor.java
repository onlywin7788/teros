package com.teros.data_service.component.executor;


import com.ext.teros.message_connector.spec.MessageConnectorSpec;
import com.ext.teros.message_processor.spec.MessageProcessorSpec;
import com.teros.data_service.common.parser.JsonParser;
import com.teros.data_service.component.executor.config.model.FlowNode;
import com.teros.data_service.component.processor.MessageProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class Executor {

    private final String PATTERN_SNDR = "SMDR";
    private final String PATTERN_RCVR = "RCVR";
    private final String PATTERN_REPLY = "REPLY";
    private final String PATTERN_REQUEST = "REQUEST";

    // component
    MessageConnectorSpec inputConnector = null;
    MessageConnectorSpec outputConnector = null;
    MessageProcessor messageProcessor = null;

    private JsonParser jsonParser;
    private Loader loader;

    // load flow node
    ArrayList<FlowNode> flowNodelist = null;

    public Executor() {
        this.messageProcessor = new MessageProcessor();
        this.jsonParser = new JsonParser();
        this.loader = new Loader();
    }

    public Loader getLoader() {
        return this.loader;
    }

    public void load(String HomePath, String interfaceId) throws Exception {
        loader.load(HomePath, interfaceId);

        flowNodelist = loader.getFlowNodelist();
        inputConnector = loader.getInputConnector();
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

    public String outputConnectorGetData(String data) throws Exception {
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

        log.info("Execute Message Processor");
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
