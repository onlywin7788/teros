package com.teros.data_service.component.executor;

import com.ext.teros.message_connector.spec.MessageConnectorSpec;
import com.ext.teros.message_processor.spec.MessageProcessorSpec;
import com.teros.data_service.common.file.CommonFile;
import com.teros.data_service.common.parser.JsonParser;
import com.teros.data_service.common.parser.XmlParser;
import com.teros.data_service.component.executor.config.model.FlowNode;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.ArrayList;

@Getter
@Setter
@Component
public class Loader {

    private final String BASE_CONFIG_NAME = "interface-main.xml";

    private final String FLOW_TYPE_INPUT_CONNECTOR = "input";
    private final String FLOW_TYPE_OUTPUT_CONNECTOR = "output";
    private final String FLOW_TYPE_INPUT_FILTER = "output-filter";
    private final String FLOW_TYPE_OUTPUT_FILTER = "output-filter";

    private String configBasePath = null;

    private CommonFile commonFile;
    private JsonParser jsonParser;
    private XmlParser xmlParser;

    // load component
    MessageConnectorSpec inputConnector = null;
    MessageConnectorSpec outputConnector = null;

    // load flow node
    ArrayList<FlowNode> flowNodelist = null;

    public Loader() {
        this.flowNodelist = new ArrayList<FlowNode>();
        this.commonFile = new CommonFile();
        this.jsonParser = new JsonParser();
        this.xmlParser = new XmlParser();
    }

    public void load(String homePath, String interfaceId) throws Exception {
        try {
            this.configBasePath = homePath + File.separator + "config" + File.separator + "data-service"
                    + File.separator + "interface" + File.separator + interfaceId;

            String baseConfig = configBasePath + File.separator + BASE_CONFIG_NAME;
            String xmlFlowPath = "/config/flow/node";

            xmlParser.loadFile(baseConfig);
            NodeList nodeList = xmlParser.getNodeList(xmlFlowPath);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                String nodeFile = xmlParser.getNodeAttrFromNode(node, "file");
                String nodeType = xmlParser.getNodeAttrFromNode(node, "type");

                if (nodeType.equals(FLOW_TYPE_INPUT_CONNECTOR) == true
                        || nodeType.equals(FLOW_TYPE_OUTPUT_CONNECTOR) == true) {
                    loadComponent(nodeFile, nodeType);
                }

                // save flow node
                FlowNode flowNode = new FlowNode();
                flowNode.setFile(nodeFile);
                flowNode.setType(nodeType);

                flowNodelist.add(flowNode);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void loadComponent(String nodeFileName, String nodeType) throws Exception {
        try {
            XmlParser xmlParserProp = new XmlParser();

            String nodeConfigPath = this.configBasePath + File.separator + "flow" + File.separator + nodeFileName;
            String nodeComponentPath = "/node/properties/param";
            String nodeComponentPathName = "component.path";
            String componentPath = "";

            xmlParserProp.loadFile(nodeConfigPath);
            NodeList nodeList = xmlParserProp.getNodeList(nodeComponentPath);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                String paramName = xmlParserProp.getNodeAttrFromNode(node, "name");
                if (paramName.equals(nodeComponentPathName) == true) {
                    componentPath = xmlParserProp.getNodeAttrFromNode(node, "value");
                    break;
                }
            }

            // class dynamic loading
            Class loadClass = Class.forName(componentPath);
            Object loadInstance = loadClass.getDeclaredConstructor().newInstance();

            // upcasting super class
            if (nodeType.equals(FLOW_TYPE_INPUT_CONNECTOR)) {
                this.inputConnector = (MessageConnectorSpec) loadInstance;
                this.inputConnector.loadConfig(nodeConfigPath);
            }
            if (nodeType.equals(FLOW_TYPE_OUTPUT_CONNECTOR)) {
                this.outputConnector = (MessageConnectorSpec) loadInstance;
                this.outputConnector.loadConfig(nodeConfigPath);
            }

        } catch (Exception e) {
            throw e;
        }
    }
}
