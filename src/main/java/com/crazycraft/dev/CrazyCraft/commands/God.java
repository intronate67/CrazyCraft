package com.crazycraft.dev.CrazyCraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Server on 7/12/2014.
 */
public class God implements Listener, CommandExecutor{

    public List<UUID> isGod = new ArrayList<UUID>();

    private static God instance = new God(); //xD Creating a "new God" ;)

    public static God getInstance(){
        return instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(isGod.contains(p.getUniqueId())){
            p.sendMessage("You are already god.");
            return true;
        }
        isGod.add(p.getUniqueId());
        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "cc.god";
    }

    @EventHandler
    public void onDamageEvent(EntityDamageEvent e){
        if(!(e.getEntity()instanceof Player)) return;
        Player p = ((Player) e.getEntity()).getPlayer();
        if(isGod.contains(p.getUniqueId())){
            e.setCancelled(true);
            e.setDamage(0D);
        }
    }

}
