package api.dataAccess;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class TwitchConnector implements Connector{
    String BASE_URL = "https://api.twitch.tv/";


    /** Get current viewer of a streamer on Twitch
     * @param username : the streamer
     * @return The current amout of viewer, -1 if viewer not found
     */
    @Override
    public int getCurrentViewers(String username) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Client-ID" , "gp762nuuoqcoxypju8c569th9wz7q5");
        headers.add("Authorization" , "Bearer u1jm8x3t9hnj3ayfiazrej8cswmrih");
        ResponseEntity<Map> result = RequestUtils.SimpleHTTPRequest(BASE_URL + "helix/streams?user_login=" + username, headers);
        Object data = ((ArrayList<LinkedHashMap<String,Object>>) result.getBody().get("data")).get(0).get("viewer_count");
        Integer viewerCount = (Integer) data;
        return viewerCount.intValue();
    }

    /** Get the profile picture of a streamer of Twitch
     * @param username user requested
     * @return url of the profile picture, null if user not found
     */
    @Override
    public String getProfilePict(String username) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Client-ID" , "gp762nuuoqcoxypju8c569th9wz7q5");
        headers.add("Authorization" , "Bearer u1jm8x3t9hnj3ayfiazrej8cswmrih");
        ResponseEntity<Map> result = RequestUtils.SimpleHTTPRequest(BASE_URL + "helix/users?login=" + username, headers);
        Object data = ((ArrayList<LinkedHashMap<String,Object>>) result.getBody().get("data")).get(0).get("profile_image_url");
        String profilePic = (String) data;
        return profilePic;
    }


    /** Get the amout of follower of a streamer on Twitch
     * @param username user requested
     * @return The amount of follower, -1 if user not found
     */
    @Override
    public int getFollower(String username) throws Exception {
        //First request to get UserId
        HttpHeaders headers = new HttpHeaders();
        headers.add("Client-ID" , "gp762nuuoqcoxypju8c569th9wz7q5");
        headers.add("Authorization" , "Bearer u1jm8x3t9hnj3ayfiazrej8cswmrih");
        ResponseEntity<Map> result = RequestUtils.SimpleHTTPRequest(BASE_URL + "helix/streams?user_login=" + username, headers);
        Object userIdObj = ((ArrayList<LinkedHashMap<String,Object>>) result.getBody().get("data")).get(0).get("user_id");
        String userId = userIdObj.toString();
        //Second to get follower number
        headers.add("Accept" , "application/vnd.twitchtv.v5+json");
        result = RequestUtils.SimpleHTTPRequest(BASE_URL + "kraken/channels/"+userId+"/follows", headers);
        Object nbFollowers = result.getBody().get("_total");
        Integer followerCount = (Integer) nbFollowers;
        return followerCount.intValue();
    }
}
