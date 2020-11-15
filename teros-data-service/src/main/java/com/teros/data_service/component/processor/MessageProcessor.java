package com.teros.data_service.component.processor;

public class MessageProcessor {

    String message = "";

    public void loadConfig(String s) throws Exception {
    }

    public void initialize() throws Exception {
    }

    public void open() throws Exception {
    }

    public String inputFilter(String s) throws Exception {
        return s;
    }

    public void input(String s) throws Exception {
        this.message = s;
    }

    public void process() throws Exception {
    }

    public String output() throws Exception {
        return this.message;
    }

    public String outputFilter(String s) throws Exception {
        return s;
    }

    public void commit() throws Exception {
    }

    public void rollback() throws Exception {
    }

    public void close() throws Exception {
    }

    public void uninitialize() throws Exception {
    }
}
