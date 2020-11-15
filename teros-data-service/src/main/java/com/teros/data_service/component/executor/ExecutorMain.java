package com.teros.data_service.component.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
public class ExecutorMain {

    private Executor executor;

    public ExecutorMain() {
        this.executor = new Executor();
    }

    public void load(String homePath, String interfaceId) throws Exception {
        try {
            executor.load(homePath, interfaceId);
        } catch (Exception e) {
            throw e;
        }
    }

    public void preAssignMessage(String data) throws Exception {
        executor.inputConnectorSetData(data);
    }

    public void execute() throws Exception {
        executor.process();
    }

    public void unload() throws Exception {

        try {
        } catch (Exception e) {
            throw e;
        }

    }

}
