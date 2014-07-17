package com.crazycraft.dev.CrazyCraft.events;

import com.PUUID;
import com.crazycraft.dev.CrazyCraft.CrazyCraft;
import com.crazycraft.dev.CrazyCraft.economy.EconManager;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Server on 7/12/2014.
 */
public class JoinListener implements Listener{

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e){
        FileConfiguration config = CrazyCraft.getInstance().config;
        FileConfiguration accounts = CrazyCraft.getInstance().accounts;
        if(config.contains(e.getPlayer().getName())){
            return;
        }
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
        if(EconManager.hasAccount(e.getPlayer().getName())) return;
        EconManager.setBalance(e.getPlayer().getName(), 250D);
    }

}
