package api.dataAccess;


/**
 * Class to manage data get from differents API (thanks to the Connectors) and return to the API
 */
public class GenericDataAccess {

    //change here to connect to the right connector (in the dogenerate)
    Connector apiConnector = new MixerConnector();

    public int getViewerCount(String username){
        try{
            return apiConnector.getCurrentViewers(username);
        }
        catch(Exception e){ // channel don't exist
            return -1;
        }
    }
}