package com.crazycraft.dev.CrazyCraft.events;

import com.crazycraft.dev.CrazyCraft.CrazyCraft;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Server on 7/12/2014.
 */
public class JoinListener implements Listener{

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e){
        FileConfiguration config = CrazyCraft.getInstance().config;
        if(config.contains(e.getPlayer().getName())){
            return;
        }
        Location loc = e.getPlayer().getLocation();
        config.set("players."  + e.getPlayer().getName() + "location.world", loc.getWorld());
        config.set("players."  + e.getPlayer().getName() + "location.X", loc.getX());
        config.set("players."  + e.getPlayer().getName() + "location.Y", loc.getY());
        config.set("players."  + e.getPlayer().getName() + "location.Z", loc.getZ());
        config.set("players."  + e.getPlayer().getName() + "ip", e.getPlayer().getAddress());
    }

}
