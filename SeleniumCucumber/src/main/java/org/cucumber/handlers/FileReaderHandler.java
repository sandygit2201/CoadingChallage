package org.cucumber.handlers;

import org.cucumber.utils.ConfigFileReader;

public class FileReaderHandler {
	private static FileReaderHandler fileReaderHandler;
	private ConfigFileReader configFileReader;
	
	private FileReaderHandler(){}
	
	public static FileReaderHandler getInstance(){
		if(fileReaderHandler==null)
			fileReaderHandler = new FileReaderHandler();
		return fileReaderHandler;
	}
	
	public ConfigFileReader getConfigFileReader(){
		return configFileReader==null?configFileReader=new ConfigFileReader():configFileReader;
	}
	
	
}
