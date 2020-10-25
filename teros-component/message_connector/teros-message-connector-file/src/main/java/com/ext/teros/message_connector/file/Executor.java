package com.ext.teros.message_connector.file;

import com.ext.teros.message_connector.spec.MessageConnectorSpec;

public class Executor implements MessageConnectorSpec {
    @Override
    public void initialize() throws Exception {
        System.out.println("INIT:FILE");
    }

    @Override
    public void connect() throws Exception {
    }

    @Override
    public void open() throws Exception {

    }

    @Override
    public void preAcquire() throws Exception {

    }

    @Override
    public void acquire() throws Exception {

    }

    @Override
    public void postAcquire() throws Exception {

    }

    @Override
    public void preDelivery() throws Exception {

    }

    @Override
    public void delivery() throws Exception {

    }

    @Override
    public void postDelivery() throws Exception {

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
    public void disconnect() throws Exception {

    }

    @Override
    public void uninitialize() throws Exception {

    }
}
