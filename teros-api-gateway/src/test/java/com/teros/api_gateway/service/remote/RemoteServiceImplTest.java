package com.teros.api_gateway.service.remote;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RemoteServiceImplTest {

    private final RemoteServiceImpl remoteServiceImpl;

    public RemoteServiceImplTest(RemoteServiceImpl remoteServiceImpl) {
        this.remoteServiceImpl = remoteServiceImpl;
    }

    @Test
    void getRoute() {
        String a= "b";
        String b= "b";

        assertThat(a).isEqualTo(b);
    }
}