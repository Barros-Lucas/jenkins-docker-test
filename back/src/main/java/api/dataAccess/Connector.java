package api.dataAccess;


/**
 * Define the behaviour of the specific Connector
 */
public interface Connector {
    public int getCurrentViewers (String username) throws Exception;
    public String getProfilePict (String username) throws Exception;
    public int getFollower (String username) throws Exception;
}
