package com.ext.teros.message_connector.spec;

public interface MessageConnectorSpec {

	public void initialize() throws Exception;
	public void connect() throws Exception;
	public void open() throws Exception;
	public void preAcquire() throws Exception;
	public void acquire() throws Exception;
	public void postAcquire() throws Exception;
	public void preDelivery() throws Exception;
	public void delivery() throws Exception;
	public void postDelivery() throws Exception;
	public void commit() throws Exception;
	public void rollback() throws Exception;
	public void close() throws Exception;
	public void disconnect() throws Exception;
	public void uninitialize() throws Exception;
}