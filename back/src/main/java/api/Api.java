package api;

import api.LogHandler.logType;
import api.dataAccess.GenericDataAccess;
import org.springframework.web.bind.annotation.*;

/**
 * Spring Boot Application
 * Back-end log-viewer application
 * We can upload directory or just an URL to show log message
 */
@CrossOrigin(origins = "*")
@RestController
public class Api {
	GenericDataAccess genericDataAccess;
		
	@RequestMapping("/hello/world")
	public String helloWorld() {
		LogHandler.addLog("Requesting Hello world", logType.INFO);
		return "Hello World";
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@ResponseBody
	@GetMapping("/getViewerCount")
	public int getViewerCount (@RequestParam String username, @RequestParam String boxname){
		genericDataAccess = new GenericDataAccess();
		return genericDataAccess.getViewerCount(username);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@ResponseBody
	@GetMapping("/getProfilePict")
	public String getProfilePict (@RequestParam String username, @RequestParam String boxname){
		genericDataAccess = new GenericDataAccess();
		return genericDataAccess.getProfilePict(username);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@ResponseBody
	@GetMapping("/getFollower")
	public int getFollower (@RequestParam String username, @RequestParam String boxname){
		genericDataAccess = new GenericDataAccess();
		return genericDataAccess.getFollower(username);
	}
}
