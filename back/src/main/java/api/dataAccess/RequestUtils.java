package api.dataAccess;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RequestUtils {

    public static ResponseEntity<String> SimpleHTTPRequest(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://data.toulouse-metropole.fr/api/records/1.0/search/?dataset=api-temps-reel-tisseo";
        ResponseEntity<String> response = restTemplate.getForEntity(url , String.class);
        return response;
    }

    //672ea81c4d2b8094103259476952c16cab45a16aad0d0e69
}
