package api.dataAccess;


/**
 * Define the behaviour of the specific Connector
 */
public interface Connector {
    public int getCurrentViewers (String username) throws Exception;
}
