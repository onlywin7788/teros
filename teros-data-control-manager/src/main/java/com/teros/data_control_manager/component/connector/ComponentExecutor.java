package com.teros.data_control_manager.component.connector;

import com.teros.data_control_manager.component.spec.ConnectorComponent;
import com.teros.data_control_manager.component.spec.ProcessDataComponent;
import org.springframework.stereotype.Component;

@Component
public class ComponentExecutor{

    ConnectorComponent inputConnector = null;
    ConnectorComponent outputConnector = null;
    ProcessDataComponent processData = null;

    String config = null;

    public void loadConfig(String filePath) throws Exception
    {

    }

    public void loadComponent() throws Exception
    {
        try {
            // class dynamic loading
            Class loadInputConnector = Class.forName("com.zenca.service.test.PreComponentImpl");
            Class loadOutputConnector = Class.forName("com.zenca.service.test.PostComponentImpl");

            Object dynamicPreComponentInstance = dynamicPreComponentClass.getDeclaredConstructor().newInstance();
            Object dynamicPostComponentInstance = dynamicPostComponentClass.getDeclaredConstructor().newInstance();

            // upcasting super class
            inputConnector = (PreComponentImpl) dynamicPreComponentInstance;
            outputConnector = (PostComponentImpl) dynamicPostComponentInstance;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
