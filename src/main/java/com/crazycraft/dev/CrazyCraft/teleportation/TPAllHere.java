package com.crazycraft.dev.CrazyCraft.teleportation;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/13/2014.
 */
public class TPAllHere implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope.");
            return true;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("cc.tpall")){
            p.sendMessage("You do not have permission!");
            return true;
        }

        for(Player players : Bukkit.getOnlinePlayers()){
            if(TP.getInstance().prevLoc.containsKey(players.getUniqueId())){
                Location loc = TP.getInstance().prevLoc.get(players.getUniqueId());
                TP.getInstance().prevLoc.remove(players.getUniqueId(), loc);
                TP.getInstance().prevLoc.put(players.getUniqueId(), players.getLocation());
            }else{
                TP.getInstance().prevLoc.put(players.getUniqueId(), players.getLocation());
            }
            players.teleport(p.getLocation());
            p.sendMessage("All players on this server have been teleported to you!");
            players.sendMessage("You have been teleported to " + p.getName());
        }
        return true;
    }

}
