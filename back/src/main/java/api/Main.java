package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import api.LogHandler.logType;

@SpringBootApplication(scanBasePackages = { "api" })
public class Main {
	
	public static void main(String[] args) {
		LogHandler.addLog("Server Starting", logType.INFO);
		SpringApplication.run(Main.class, args);
	}

	/**
	 * used to test continue integration
	 * @return 12
	 */
	public static int return12(){
		return 12;
	}
}