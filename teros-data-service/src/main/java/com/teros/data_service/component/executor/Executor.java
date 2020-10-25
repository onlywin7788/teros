package com.teros.data_service.component.executor;

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

    public void execute() throws Exception {

        processor.initialize();
        processor.connect();
        processor.process();
        processor.disconnect();
        processor.uninitialize();

    }

    public void unload() throws Exception {

        try {
        } catch (Exception e) {
            throw e;
        }

    }

}
