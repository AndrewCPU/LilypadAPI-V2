package net.Andrewcpu.LilypadAPI.main.listeners;

import lilypad.client.connect.api.event.MessageEvent;

/**
 * Created by stein on 4/7/2016.
 */
public interface MessageListener {
    void onMessage(MessageEvent event);
    void onMessage(String sender, String channel, String message);
}
