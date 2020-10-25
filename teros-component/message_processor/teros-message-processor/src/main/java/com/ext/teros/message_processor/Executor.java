package com.ext.teros.message_processor;


import com.ext.teros.message_processor.spec.MessageProcessorSpec;

public class Executor implements MessageProcessorSpec {

    @Override
    public void initialize() throws Exception {
        System.out.println("INIT:PROCESSOR");
    }

    @Override
    public void open() throws Exception {

    }

    @Override
    public void input() throws Exception {

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
    public void output() throws Exception {

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
