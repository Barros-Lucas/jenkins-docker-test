package api.dataAccess;

import com.mixer.api.MixerAPI;
import com.mixer.api.resource.channel.MixerChannel;
import com.mixer.api.services.impl.ChannelsService;

import api.LogHandler;
import api.LogHandler.logType;

import java.util.concurrent.ExecutionException;

/**
 * MixerConnector (get data from mixer api)
 */
public class MixerConnector implements Connector{
    public static MixerAPI mixer;

    /**
     * Constructor used when user will use his own mixer account
     * @param token
     */
    public MixerConnector(String token){
        mixer = new MixerAPI(token);
        LogHandler.addLog("MixerConnector Initialized", logType.INFO);
    }

    /**
     * Constructor used during development with a hardcoded token
     */
    public MixerConnector(){
        this("672ea81c4d2b8094103259476952c16cab45a16aad0d0e69");
    }

    /** Get current viewer of a streamer on Mixer
     * @param username : the streamer
     * @return The current amout of viewer, -1 if viewer not found
     */
    public int getCurrentViewers(String username) throws ExecutionException, InterruptedException {
        MixerChannel channel = mixer.use(ChannelsService.class).findOneByToken(username).get();
        int viewers = channel.viewersCurrent;
        LogHandler.addLog("Viewers for user "+username+" : "+ viewers, logType.INFO);
        return viewers;
    }

    /** Get the profile picture of a streamer of Mixer
     * @param username user requested
     * @return url of the profile picture, null if user not found
     */
    @Override
    public String getProfilePict(String username) throws ExecutionException, InterruptedException {
        MixerChannel channel = mixer.use(ChannelsService.class).findOneByToken(username).get();
        String url = "https://mixer.com/api/v1/users/" + channel.user.id + "/avatar" ;
        LogHandler.addLog("Follower for user "+username+" :" + url , logType.INFO);
        return url;
    }

    /** Get the amout of follower of a streamer on Mixer
     * @param username user requested
     * @return The amount of follower, -1 if user not found
     */
    public int getFollower(String username) throws ExecutionException, InterruptedException {
        MixerChannel channel = mixer.use(ChannelsService.class).findOneByToken(username).get();
        int followers = channel.numFollowers;
        LogHandler.addLog("Follower for user "+username+" : " + followers, logType.INFO);
        return followers;
    }


}