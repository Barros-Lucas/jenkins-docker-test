package api.dataAccess;

import api.LogHandler;
import api.LogHandler.logType;

/**
 * Class to manage data get from differents API (thanks to the Connectors) and return to the API
 */
public class GenericDataAccess {

    //change here to connect to the right connector (in the dogenerate)
    Connector apiConnector = new MixerConnector();

    public int getViewerCount(String username){
        LogHandler.addLog("Requesting for the current viewer count for user "+username, logType.INFO);
        try{
            return apiConnector.getCurrentViewers(username);
        }
        catch(Exception e){ // channel don't exist
            LogHandler.addLog(e.getMessage(), logType.ERROR);

            LogHandler.addLog("Error while fetching current viewer count for user "+username+"\n error : " + e.getMessage(), logType.ERROR);
            return -1;
        }
    }

    public String getProfilePict(String username){
        LogHandler.addLog("Requesting for the profile picture user "+username, logType.INFO);
        try{
            return apiConnector.getProfilePict(username);
        }
        catch(Exception e){ // channel don't exist
            LogHandler.addLog("Error while fetching profile picture for user "+username+"\n error : " + e.getMessage(), logType.ERROR);
            return "ERROR";
        }
    }

    public int getFollowers(String username){
        LogHandler.addLog("Requesting for the current viewer count for user "+username, logType.INFO);
        try{
            return apiConnector.getFollower(username);
        }
        catch(Exception e){ // channel don't exist
            LogHandler.addLog("Error while fetching followers for user "+username+"\n error : " + e.getMessage(), logType.ERROR);
            return -1;
        }
    }
}