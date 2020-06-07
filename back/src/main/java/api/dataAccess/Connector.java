package api.dataAccess;

/**
 * Define the behaviour of the specific Connector
 */

public interface Connector {

    /**
     * Get the current number of viewers watching the stream
     * @param username : the streamer
     * @return number of streamer, -1 if user is not found or offline
     */
    public int getCurrentViewers (String username) throws Exception;

    /** Get the profile picture of the user
     * @param username user requested
     * @return url of the profile picture , null if user if not found
     */
    public String getProfilePict (String username) throws Exception;

    /** Get amount of follower of a user
     * @param username user requested
     * @return the amount of follower, -1 if the user is not found
     */
    public int getFollower (String username) throws Exception;
}
