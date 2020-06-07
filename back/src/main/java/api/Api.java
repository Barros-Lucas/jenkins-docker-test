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

	/** Function called when the HTTP route "/getViewerCount" is requested to return the viewer Count of a stream to the client
	 * @param username
	 * @param apiType
	 * @return The viewer count, -1 if user not found
 	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@ResponseBody
	@GetMapping("/getViewerCount")
	public int getViewerCount (@RequestParam String username , @RequestParam String apiType){
		genericDataAccess = new GenericDataAccess();
		return genericDataAccess.getViewerCount(username , apiType);
	}

	/** Function called when the HTTP route "/getProfilePict" is requested to return the profile picture of a streamer to the client
	 * @param username
	 * @param apiType
	 * @return the url of the profile pic, null is the user is not found
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@ResponseBody
	@GetMapping("/getProfilePict")
	public String getProfilePict (@RequestParam String username , @RequestParam String apiType){
		genericDataAccess = new GenericDataAccess();
		return genericDataAccess.getProfilePict(username , apiType);
	}

	/** Function called
	 * @param username
	 * @param apiType
	 * @return
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@ResponseBody
	@GetMapping("/getFollowers")
	public int getFollower (@RequestParam String username , @RequestParam String apiType){
		genericDataAccess = new GenericDataAccess();
		return genericDataAccess.getFollowers(username , apiType);
	}
}
