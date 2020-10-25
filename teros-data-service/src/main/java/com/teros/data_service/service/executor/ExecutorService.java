package com.teros.data_service.service.executor;

import com.teros.data_service.component.executor.Executor;
import org.springframework.stereotype.Service;

@Service
public class ExecutorService {
    private final Executor executor;

    public ExecutorService(Executor executor) {
        this.executor = executor;
    }

    public void execute(String configPath) throws Exception {
        executor.load(configPath);
        executor.execute();
        executor.unload();
    }
}
