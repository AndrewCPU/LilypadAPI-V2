package net.Andrewcpu.LilypadAPI.main.listeners;

import lilypad.client.connect.api.event.EventListener;
import lilypad.client.connect.api.event.MessageEvent;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stein on 4/7/2016.
 */
public class LPMessageListener {
    private List<MessageListener> messageListeners=  new ArrayList<>();
    public void registerListener(MessageListener messageListener){
        messageListeners.add(messageListener);
    }
    public void unregisterListener(MessageListener messageListener){
        messageListeners.remove(messageListener);
    }
    @EventListener
    public void onMessage(MessageEvent event){
        for(MessageListener messageListener : messageListeners){
            messageListener.onMessage(event);
            try {
                messageListener.onMessage(event.getSender(),event.getChannel(),event.getMessageAsString());
            } catch (UnsupportedEncodingException e) {
                System.out.println("Unable to get message as string...");
            }
        }
    }
}
