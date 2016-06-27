package net.Andrewcpu.LilypadAPI.main;

import lilypad.client.connect.api.Connect;
import lilypad.client.connect.api.request.impl.RedirectRequest;
import lilypad.client.connect.api.result.FutureResultListener;
import lilypad.client.connect.api.result.Result;
import lilypad.client.connect.api.result.StatusCode;
import lilypad.client.connect.api.result.impl.RedirectResult;
import org.bukkit.entity.Player;

/**
 * Created by stein on 4/7/2016.
 */
public class Direct {
    /**
     * @param p Target player
     * @param serv Target server
     */
    public static void directPlayer(Player p, String serv) {
        try {
            Connect c = LilypadAPI.getInstance().getBukkitConnect();
            c.request(new RedirectRequest(serv, p.getName())).registerListener(new FutureResultListener() {
                public void onResult(Result redirectResult) {
                    if (((RedirectResult)redirectResult).getStatusCode() == StatusCode.SUCCESS) {
                        return;
                    }
                    p.sendMessage("Could not connect");
                }
            });
            c = null;
        } catch (Exception exception) {
            p.sendMessage("Could not connect");
        }
    }
}
