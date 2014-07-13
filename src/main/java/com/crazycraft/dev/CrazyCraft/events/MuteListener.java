package com.crazycraft.dev.CrazyCraft.events;

import com.crazycraft.dev.CrazyCraft.commands.Mute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by Server on 7/12/2014.
 */
public class MuteListener implements Listener{

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        if(!Mute.getInstance().isMuted.contains(e.getPlayer().getUniqueId())) return;
        e.setCancelled(true);
    }

}
