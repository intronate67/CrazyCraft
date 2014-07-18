package com.crazycraft.dev.CrazyCraft.economy.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Server on 7/16/2014.
 */
public class EntityDeath implements Listener{

    private static EntityDeath instance = new EntityDeath();

    public static EntityDeath getInstance(){
        return instance;
    }

    public Map<UUID, Integer> entitiesKilled = new HashMap<UUID, Integer>();

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e){
        if(!(e.getEntity().getKiller() instanceof Player)) return;
        Player p = e.getEntity().getKiller();
        if(p.getGameMode().equals(GameMode.CREATIVE)) return;
        if(entitiesKilled.containsKey(e.getEntity().getKiller().getUniqueId())) {
            entitiesKilled.put(e.getEntity().getKiller().getUniqueId(), entitiesKilled.get(e.getEntity().getKiller().getUniqueId()) + 1);
            return;
        }
        entitiesKilled.put(e.getEntity().getKiller().getUniqueId(), 1);
    }

}
