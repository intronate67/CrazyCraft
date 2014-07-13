package com.crazycraft.dev.CrazyCraft.events;

import com.crazycraft.dev.CrazyCraft.commands.Time;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Created by Server on 7/12/2014.
 */
public class PlayerMoveTimeLock implements Listener{

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        if(!Time.getInstance().isLocked.containsKey(e.getPlayer().getWorld().getName())) return;
        if(Time.getInstance().isLocked.get(e.getPlayer().getName()).equals("dawn")){
            if(e.getPlayer().getWorld().getTime() != 6000){
                e.getPlayer().getWorld().setTime(6000);
            }else{
                return;
            }
        }
        if(Time.getInstance().isLocked.get(e.getPlayer().getName()).equals("day")){
            if(e.getPlayer().getWorld().getTime() != 8000){
                e.getPlayer().getWorld().setTime(8000);
            }else{
                return;
            }
        }
        if(Time.getInstance().isLocked.get(e.getPlayer().getName()).equals("noon")){
            if(e.getPlayer().getWorld().getTime() != 12000){
                e.getPlayer().getWorld().setTime(12000);
            }else{
                return;
            }
        }
        if(Time.getInstance().isLocked.get(e.getPlayer().getName()).equals("dusk")){
            if(e.getPlayer().getWorld().getTime() != 17000){
                e.getPlayer().getWorld().setTime(17000);
            }else{
                return;
            }
        }
        if(Time.getInstance().isLocked.get(e.getPlayer().getName()).equals("night")){
            if(e.getPlayer().getWorld().getTime() != 21000){
                e.getPlayer().getWorld().setTime(21000);
            }else{
                return;
            }
        }
    }

}
