package com.crazycraft.dev.CrazyCraft.events;

import com.crazycraft.dev.CrazyCraft.CrazyCraft;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Server on 7/12/2014.
 */
public class QuitListener implements Listener{

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        FileConfiguration config = CrazyCraft.getInstance().config;
        Location loc = e.getPlayer().getLocation();
        config.set("players."  + e.getPlayer().getName() + ".location.world", loc.getWorld().getName());
        config.set("players."  + e.getPlayer().getName() + ".location.X", loc.getX());
        config.set("players."  + e.getPlayer().getName() + ".location.Y", loc.getY());
        config.set("players."  + e.getPlayer().getName() + ".location.Z", loc.getZ());
        config.set("players."  + e.getPlayer().getName() + ".ip", e.getPlayer().getAddress().getHostName());
        CrazyCraft.getInstance().saveConfig();
    }

}
