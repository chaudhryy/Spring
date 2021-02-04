package com.yash.windows.core.utils;

import com.yash.windows.core.utils.beans.FileOraganizer;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;

public class App {

	private static final Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		String fromPath = "C:\\Users\\t827090\\OneDrive - Spark New Zealand\\Spark\\Journeys";//args[0];
		String toPath = "C:\\Users\\t827090\\OneDrive - Spark New Zealand\\Spark\\Documents\\";
		String toCodePath = "C:\\Users\\t827090\\OneDrive - Spark New Zealand\\Spark\\Documents";

		FileOraganizer oraganizer = new FileOraganizer(fromPath,toPath,toCodePath);
		oraganizer.process();
	}

}
