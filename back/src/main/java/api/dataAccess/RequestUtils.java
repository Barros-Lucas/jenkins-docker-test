package api.dataAccess;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RequestUtils {

    /** Send a HTTP request and return the answer
     * @param url
     * @param headers
     * @return the answer in a ResponseEntity(Map)
     */
    public static ResponseEntity<Map> SimpleHTTPRequest(String url,HttpHeaders headers) {
        RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
        return response;
    }
}
