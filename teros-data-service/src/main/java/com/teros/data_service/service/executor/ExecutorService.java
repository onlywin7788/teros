package com.teros.data_service.service.executor;

import com.teros.data_service.component.executor.ExecutorMain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExecutorService {

    @Value("${extra.param.teros_home}")
    private String homePath;

    @Value("${extra.param.interface_id}")
    private String interfaceId;

    private final ExecutorMain executorMain;

    public ExecutorService(ExecutorMain executorMain) {
        this.executorMain = executorMain;
    }

    public void load() throws Exception {

        log.info(String.format("property load::homePath=[%s]", homePath));
        log.info(String.format("property load::interface_id=[%s]", interfaceId));

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
