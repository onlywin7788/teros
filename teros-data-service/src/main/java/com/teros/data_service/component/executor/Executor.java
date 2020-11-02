package com.teros.data_service.component.executor;

import com.google.inject.internal.cglib.core.$ProcessArrayCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Executor {

    private final Processor processor;

    public Executor(Processor processor) {
        this.processor = processor;
    }

    public void load(String configPath) throws Exception {
        try {
            processor.load(configPath);
        } catch (Exception e) {
            throw e;
        }
    }

    public void preAssignMessage(String data) throws Exception {
        processor.inputConnectorSetData(data);
    }

    public void execute() throws Exception {
        processor.process();
    }

    public void unload() throws Exception {

        try {
        } catch (Exception e) {
            throw e;
        }

    }

}
