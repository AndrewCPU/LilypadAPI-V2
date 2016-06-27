package net.Andrewcpu.LilypadAPI.main;

import lilypad.client.connect.api.Connect;
import lilypad.client.connect.api.request.RequestException;
import lilypad.client.connect.api.request.impl.MessageRequest;
import lilypad.client.connect.api.result.FutureResult;
import lilypad.client.connect.api.result.impl.MessageResult;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.UnsupportedEncodingException;

/**
 * Created by stein on 4/7/2016.
 */
public class LPMessenger {
    public LPMessenger(){
    }

    /**
     * @param s String to send
     * @param server Target server
     * @return Returns if success
     */
    public boolean send(String s, String server) {
        MessageRequest request = null;
        try {
            request = new MessageRequest(server, "lpapi", s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            LilypadAPI.getInstance().getBukkitConnect().request(request);
        } catch (RequestException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @param s String to send
     * @param server Target server
     * @param channel Messaging channel
     * @return Returns if success
     */
    public boolean send(String s, String server, String channel) {
        MessageRequest request = null;
        try {
            request = new MessageRequest(server, channel, s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            LilypadAPI.getInstance().getBukkitConnect().request(request);
        } catch (RequestException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
