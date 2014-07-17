package com.crazycraft.dev.CrazyCraft.economy.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

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

    public Map<UUID, Integer> entitiesKilled;

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e){
        if(!(e.getEntity().getKiller() instanceof Player)) return;
        entitiesKilled.put(e.getEntity().getKiller().getUniqueId(), entitiesKilled.get(e.getEntity().getKiller().getUniqueId()) + 1);
    }

}
