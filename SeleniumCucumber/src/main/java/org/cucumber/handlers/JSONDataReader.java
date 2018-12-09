package org.cucumber.handlers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.cucumber.dataobjects.NewDocument;
import org.cucumber.dataobjects.TransmittalMailDataObject;

import com.google.gson.Gson;

public class JSONDataReader {
	private static final String jsonTestDataPath = FileReaderHandler.getInstance().getConfigFileReader().getJSONTestDataPath();
	private NewDocument newDocument;
	private TransmittalMailDataObject transmittalMailDataObject;
	
	public NewDocument getNewDocumentDataFromJSON(String fileName){
		if(newDocument==null){
			Gson gson = new Gson();
			String customerFilePath = jsonTestDataPath + "/" + fileName;
			try{
				BufferedReader bufferReader = new BufferedReader(new FileReader(customerFilePath));
				newDocument = gson.fromJson(bufferReader, NewDocument.class);
			}catch(IOException io){
				throw new RuntimeException(io.getMessage());
			}
		}
		return newDocument;
	}
	
	public NewDocument getNewDocumentDataFromJSON(){
		return newDocument;
	}
	
	public TransmittalMailDataObject getTransmittalMailDataObject(String fileName){
		if(transmittalMailDataObject==null){
			Gson gson = new Gson();
			String customerFilePath = jsonTestDataPath + "/" + fileName;
			try{
				BufferedReader bufferReader = new BufferedReader(new FileReader(customerFilePath));
				transmittalMailDataObject = gson.fromJson(bufferReader, TransmittalMailDataObject.class);
			}catch(IOException io){
				throw new RuntimeException(io.getMessage());
			}
		}
		return transmittalMailDataObject;
	}

	public TransmittalMailDataObject getTransmittalMailDataObject() {
		return transmittalMailDataObject;
	}
	



}
