package api;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogHandler {

	public enum logType {
			DEBUG,
			INFO,
			ERROR;
	}
	
	public static void addLog(String s, logType type) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");  
		LocalDateTime now = LocalDateTime.now();  
		String date = dtf.format(now);  
		
		try {			
//			BufferedWriter writer = new BufferedWriter(new FileWriter("Log.dat"));
			String line = "["+type+"]"+" "+date+" "+s+"\n";
			Files.write(Paths.get("Log.dat"), line.getBytes(), StandardOpenOption.APPEND);
//			writer.write(line);
//			writer.close();
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
