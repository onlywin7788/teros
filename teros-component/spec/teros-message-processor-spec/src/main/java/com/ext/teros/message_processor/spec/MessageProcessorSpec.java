package com.ext.teros.message_processor.spec;

public interface MessageProcessorSpec {

	public void loadConfig(String str) throws Exception;
	public void initialize() throws Exception;
	public void open() throws Exception;
	public void input(String str) throws Exception;
	public void preFilter() throws Exception;
	public void filter() throws Exception;
	public void postFilter() throws Exception;
	public String output() throws Exception;
	public void commit() throws Exception;
	public void rollback() throws Exception;
	public void close() throws Exception;
	public void uninitialize() throws Exception;
}
