package com.teros.data_service;

import com.teros.data_service.component.executor.ExecutorMain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestExecutor {

    @Test
    public void test() {
        try {

            ExecutorMain executorMain = new ExecutorMain();
            executorMain.load("e:/teros_home", "REST_TO_KAFKA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
