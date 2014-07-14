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
public class TP implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Only players can Teleport!");
            return true;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("cc.teleport")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        if(args.length < 1 || args.length > 2){
            p.sendMessage("Incorrect Usage!");
            return true;
        }
        if(args.length == 1){
            Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(args[0]));
            if(targetPlayer != null){
                if(TPToggle.getInstance().toggle.contains(targetPlayer.getUniqueId())){
                    p.sendMessage("Player has teleportation disabled!");
                    return true;
                }
                Location loc = targetPlayer.getLocation();
                p.teleport(loc);
                p.sendMessage("Teleported " + p.getName() + " to " + targetPlayer.getName());
                targetPlayer.sendMessage(p.getName() +  " teleported to you.");
            }
            p.sendMessage("Player does not exist an/or is not online!");
            return true;
        }
        if(args.length == 2){
            Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(args[0]));
            Player receivingPlayer = Bukkit.getPlayer(PUUID.getUUID(args[1]));
            if(targetPlayer != null && receivingPlayer != null){
                if(TPToggle.getInstance().toggle.contains(targetPlayer.getUniqueId())
                        || TPToggle.getInstance().toggle.contains(receivingPlayer.getUniqueId())){
                    p.sendMessage("1 or more players have teleportation disabled!");
                    return true;
                }
                return true;
            }
            p.sendMessage("1 or more players do not exist an/or is not online!");
        }
        return true;
    }

}
