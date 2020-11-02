package com.teros.data_service.service.executor;

import com.teros.data_service.component.executor.Executor;
import org.springframework.stereotype.Service;

@Service
public class ExecutorService {
    private final Executor executor;

    public ExecutorService(Executor executor) {
        this.executor = executor;
    }

    public void load(String configPath) throws Exception {
        executor.load(configPath);
    }

    public void executeAssignData(String data) throws Exception {
        executor.preAssignMessage(data);
    }

    public void execute() throws Exception {
        executor.execute();
        executor.unload();
    }

    public void unload() throws Exception {
        executor.unload();
    }
}
