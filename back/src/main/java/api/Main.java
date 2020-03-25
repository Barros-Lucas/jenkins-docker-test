package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "api" })
public class Main {
	
	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);
	
	}

	/**
	 * used to test continue intgration
	 * @return 12
	 */
	public static int return12(){
		return 12;
	}
}