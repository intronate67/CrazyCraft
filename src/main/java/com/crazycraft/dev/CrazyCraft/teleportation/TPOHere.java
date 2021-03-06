package com.crazycraft.dev.CrazyCraft.teleportation;

import com.PUUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/13/2014.
 */
public class TPOHere implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Players cannot teleport to console.");
            return true;
        }
        if(args.length != 1){
            sender.sendMessage("Incorrect Usage!");
            return true;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("cc.tpohere")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        String name = null;
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getName().contains(args[0])){
                name = player.getName();
            }
        }
        Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(name));
        if(targetPlayer != null){
            if(TP.getInstance().prevLoc.containsKey(targetPlayer.getUniqueId())){
                Location loc = TP.getInstance().prevLoc.get(targetPlayer.getUniqueId());
                TP.getInstance().prevLoc.remove(targetPlayer.getUniqueId(), loc);
                TP.getInstance().prevLoc.put(targetPlayer.getUniqueId(), targetPlayer.getLocation());
            }else {
                targetPlayer.teleport(p.getLocation());
                targetPlayer.sendMessage("You have teleported to " + p.getName());
                p.sendMessage("You have teleported " + targetPlayer.getName() + " to you.");
            }
            return true;
        }
        p.sendMessage("Player does not exist and/or is not online!");
        return true;
    }

}
