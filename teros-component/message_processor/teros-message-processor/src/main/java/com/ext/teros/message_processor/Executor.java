package com.ext.teros.message_processor;

import com.ext.teros.message_processor.information.ProgramInformation;
import com.ext.teros.message_processor.spec.MessageProcessorSpec;

public class Executor implements MessageProcessorSpec {

    String message = "";

    //extra
    private ProgramInformation programInformation;

    public Executor() {
        programInformation = new ProgramInformation();
    }

    @Override
    public void loadConfig(String s) throws Exception {
    }

    @Override
    public void initialize() throws Exception {

    }

    @Override
    public void open() throws Exception {

    }

    @Override
    public String inputFilter(String s) throws Exception {
        return s;
    }

    @Override
    public void input(String s) throws Exception {
        this.message = s;
    }

    @Override
    public void process() throws Exception {
    }

    @Override
    public String output() throws Exception {
        return this.message;
    }

    @Override
    public String outputFilter(String s) throws Exception {
        return s;
    }

    @Override
    public void commit() throws Exception {

    }

    @Override
    public void rollback() throws Exception {

    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public void uninitialize() throws Exception {

    }

    @Override
    public String getProcessorType() throws Exception {
        return programInformation.getType();
    }

    @Override
    public String getProcessorVersion() throws Exception {
        return programInformation.getVersion();
    }
}
