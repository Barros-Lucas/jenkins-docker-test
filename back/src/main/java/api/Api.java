package api;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import api.dataAccess.GenericDataAccess;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.lingala.zip4j.ZipFile;

/**
 * Spring Boot Application
 * Back-end log-viewer application
 * We can upload directory or just an url to show log message
 */
@CrossOrigin(origins = "*")
@RestController
public class Api {
	GenericDataAccess genericDataAccess;
		
	@RequestMapping("/hello/world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@ResponseBody
	@GetMapping("/getViewerCount")
	public int getViewerCount (@RequestParam String username, @RequestParam String boxname){
		genericDataAccess = new GenericDataAccess();
		return genericDataAccess.getViewerCount(username);
	}
}
