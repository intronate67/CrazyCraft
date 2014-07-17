package com.crazycraft.dev.CrazyCraft.economy.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Server on 7/16/2014.
 */
public class PlayerKill implements Listener{

    private static PlayerKill instance = new PlayerKill();

    public static PlayerKill getInstance(){
        return instance;
    }

    public Map<UUID, Integer> playersKilled;

    @EventHandler
    public void onPlayeryDeath(PlayerDeathEvent e){
        if(!(e.getEntity().getKiller() instanceof Player)) return;
        playersKilled.put(e.getEntity().getKiller().getUniqueId(), playersKilled.get(e.getEntity().getKiller().getUniqueId()) + 1);
    }

}
