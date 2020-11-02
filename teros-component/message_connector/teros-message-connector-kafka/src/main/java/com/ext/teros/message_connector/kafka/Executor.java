package com.ext.teros.message_connector.kafka;

import com.ext.teros.message_connector.kafka.config.Config;
import com.ext.teros.message_connector.spec.MessageConnectorSpec;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Executor implements MessageConnectorSpec {

    Properties properties = null;
    Config config = null;
    Producer kafkaProducer = null;
    String message = "";

    public Executor() {
        properties = new Properties();
        config = new Config();
    }

    @Override
    public void loadConfig(String s) throws Exception {

        config.setConnection("10.10.2.102:9092");
        config.setTopic("teros-kafka-topic");
    }
    @Override
    public void initialize() throws Exception {

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getConnection());
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        kafkaProducer = new KafkaProducer<>(properties);
    }

    @Override
    public void connect() throws Exception {

    }

    @Override
    public void open() throws Exception {

    }

    @Override
    public void preInput() throws Exception {

    }

    @Override
    public void input() throws Exception {

    }

    @Override
    public void postInput() throws Exception {

    }

    @Override
    public void preOutput() throws Exception {

    }

    @Override
    public void output() throws Exception {

        ProducerRecord<String, String> record = new ProducerRecord<>(config.getTopic(), this.message);
        kafkaProducer.send(record, (metadata, exception) -> {
            if (exception != null) {
                // some exception
            }
        });
        kafkaProducer.flush();

    }

    @Override
    public void postOutput() throws Exception {

    }

    @Override
    public void commit() throws Exception {
    }

    @Override
    public void rollback() throws Exception {

    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public void disconnect() throws Exception {

    }

    @Override
    public void uninitialize() throws Exception {

    }

    @Override
    public String getData() throws Exception {
        return message;
    }

    @Override
    public void setData(String s) throws Exception {
        this.message = s;
    }
}
