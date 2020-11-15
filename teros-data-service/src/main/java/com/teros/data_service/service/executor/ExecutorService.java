package com.teros.data_service.service.executor;

import com.teros.data_service.component.executor.ExecutorMain;
import org.springframework.stereotype.Service;

@Service
public class ExecutorService {
    private final ExecutorMain executorMain;

    public ExecutorService(ExecutorMain executorMain) {
        this.executorMain = executorMain;
    }

    public void load(String homePath, String interfaceId) throws Exception {
        executorMain.load(homePath, interfaceId);
    }

    public void executeAssignData(String data) throws Exception {
        executorMain.preAssignMessage(data);
    }

    public void execute() throws Exception {
        executorMain.execute();
        executorMain.unload();
    }

    public void unload() throws Exception {
        executorMain.unload();
    }
}
