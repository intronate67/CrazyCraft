package com.crazycraft.dev.CrazyCraft.events;

import com.crazycraft.dev.CrazyCraft.CrazyCraft;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Server on 7/12/2014.
 */
public class QuitListener implements Listener{

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        FileConfiguration config = CrazyCraft.getInstance().config;
        Location loc = e.getPlayer().getLocation();
        config.set("players." + e.getPlayer().getName() + ".location.world", loc.getWorld().getName());
        config.set("players." + e.getPlayer().getName() + ".location.X", loc.getX());
        config.set("players." + e.getPlayer().getName() + ".location.Y", loc.getY());
        config.set("players." + e.getPlayer().getName() + ".location.Z", loc.getZ());
        config.set("players." + e.getPlayer().getName() + ".ip", e.getPlayer().getAddress().getHostName());
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        config.set("players." + e.getPlayer().getName() + ".time.month", now.getMonth());
        config.set("players." + e.getPlayer().getName() + ".time.day", now.getDay());
        config.set("players." + e.getPlayer().getName() + ".time.hour", now.getHours());
        config.set("players." + e.getPlayer().getName() + ".time.minute", now.getMinutes());
        config.set("players." + e.getPlayer().getName() + ".time.second", now.getSeconds());
        CrazyCraft.getInstance().saveConfig();
    }

}
