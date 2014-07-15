package com.crazycraft.dev.CrazyCraft.events;

import com.crazycraft.dev.CrazyCraft.commands.God;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Server on 7/15/2014.
 */
public class PlayerInteract implements Listener{

    @EventHandler
    public void onEntutyInteract(EntityDamageByEntityEvent e){
        if(!(e.getEntity() instanceof Player)) return;
        Player p = (Player) e.getEntity();
        if(!God.getInstance().isGod.contains(p.getUniqueId())) return;
        e.setDamage(0D);
        e.setCancelled(true);
    }

}
