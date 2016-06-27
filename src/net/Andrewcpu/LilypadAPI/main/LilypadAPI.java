package net.Andrewcpu.LilypadAPI.main;

import lilypad.client.connect.api.Connect;
import net.Andrewcpu.LilypadAPI.main.listeners.LPMessageListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by stein on 4/7/2016.
 */
public class LilypadAPI {
    private JavaPlugin plugin;
    private LPMessenger messenger;
    private Direct direct;
    private LPMessageListener lpMessageListener;
    private static LilypadAPI lilypadAPI;
    public static LilypadAPI getInstance(){
        return lilypadAPI;
    }
    public LilypadAPI(JavaPlugin plugin){
        lilypadAPI = this;
        this.plugin = plugin;
        init();
    }
    public void init(){
        messenger = new LPMessenger();
        direct = new Direct();
        lpMessageListener=  new LPMessageListener();
        getBukkitConnect().registerEvents(lpMessageListener);
    }

    public LPMessenger getMessenger() {
        return messenger;
    }

    /**
     * @return Returns JavaPlugin that is managing the API
     */
    public JavaPlugin getPlugin() {
        return plugin;
    }

    /**
     * @param plugin Sets the JavaPlugin that is managing the API
     */
    public void setPlugin(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * @param messenger Sets the LPMessenger
     */
    public void setMessenger(LPMessenger messenger) {
        this.messenger = messenger;
    }

    /**
     * @return Returns the instance of the Direct class, the class that manages moving players from server to server
     */
    public Direct getDirect() {
        return direct;
    }

    /**
     * @param direct Sets the Direct instance, the instance that controls moving the players from server to server
     */
    public void setDirect(Direct direct) {
        this.direct = direct;
    }

    public Connect getBukkitConnect() {
        return (Connect)plugin.getServer().getServicesManager().getRegistration(Connect.class).getProvider();
    }

    /**
     * @return Returns the LPMessageListener class, which managers incoming messages and passes it to the listeners
     */

    public LPMessageListener getLPMessageListener() {
        return lpMessageListener;
    }

    /**
     * @param lpMessageListener Set the LPMessageListener class, which managers incoming messages and passes it to the listeners
     */
    public void setLPMessageListener(LPMessageListener lpMessageListener) {
        this.lpMessageListener = lpMessageListener;
    }
}
