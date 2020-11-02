package com.ext.teros.message_processor;

import com.ext.teros.message_processor.spec.MessageProcessorSpec;

public class Executor implements MessageProcessorSpec {

    String processMessage = "";

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
    public void input(String s) throws Exception {
        this.processMessage = s;
    }

    @Override
    public void preFilter() throws Exception {

    }

    @Override
    public void filter() throws Exception {

    }

    @Override
    public void postFilter() throws Exception {

    }

    @Override
    public String output() throws Exception {
        return this.processMessage;
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
}
