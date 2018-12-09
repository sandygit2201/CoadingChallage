package org.cucumber.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateFormattingUtil{
	public static String getDateInHHmmssFormat(){
		Date today = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("HHmmSS");
		return simpleDate.format(today);
	}

}
