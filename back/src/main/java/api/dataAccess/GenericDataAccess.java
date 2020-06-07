package api.dataAccess;

import api.LogHandler;
import api.LogHandler.logType;

/**
 * Class to manage data get from differents API (thanks to the Connectors) and return to the API
 */
public class GenericDataAccess {

    /**
     * The connector to the twitch API
     */
    Connector twitchConnector = new TwitchConnector();

    /**
     * The connector to the mixer API
     */
    Connector mixerConnector = new MixerConnector();

    /** Get the viewer count of the user on the selected streaming platform
     * @param username user requested
     * @param apiType api requested ("mixer" or "twitch")
     * @return The viewer count or -1 if user not found
     */
    public int getViewerCount(String username , String apiType){
        LogHandler.addLog("Requesting for the current viewer count for user "+username, logType.INFO);
        try{
            return getConnector(apiType).getCurrentViewers(username);
        }
        catch(Exception e){ // channel don't exist
            LogHandler.addLog(e.getMessage(), logType.ERROR);

            LogHandler.addLog("Error while fetching current viewer count for user "+username+"\n error : " + e.getMessage(), logType.ERROR);
            return -1;
        }
    }

    /** Get the profile picture of the user
     * @param username user requested
     * @param apiType api requested ("mixer" or "twitch")
     * @return url of the profile picture or null if user not found
     */
    public String getProfilePict(String username , String apiType){
        LogHandler.addLog("Requesting for the profile picture user "+username, logType.INFO);
        try{
            return getConnector(apiType).getProfilePict(username);
        }
        catch(Exception e){ // channel don't exist
            LogHandler.addLog("Error while fetching profile picture for user "+username+"\n error : " + e.getMessage(), logType.ERROR);
            return "ERROR";
        }
    }

    /** Get amount of follower of a user
     * @param username user requested
     * @param apiType api requested ("mixer" or "twitch")
     * @return the amount of follower, -1 if the user is not found
     */
    public int getFollowers(String username , String apiType){
        LogHandler.addLog("Requesting for the current viewer count for user "+username, logType.INFO);
        try{
            return getConnector(apiType).getFollower(username);
        }
        catch(Exception e){ // channel don't exist
            LogHandler.addLog("Error while fetching followers for user "+username+"\n error : " + e.getMessage(), logType.ERROR);
            return -1;
        }
    }


    /** Get the connector used for request
     * @param apiType String
     * @return Connector, the right instance of Connector depending on the apiType given
     */
    private Connector getConnector (String apiType){
        return apiType.equals("mixer") ? this.mixerConnector : this.twitchConnector;
    }
}