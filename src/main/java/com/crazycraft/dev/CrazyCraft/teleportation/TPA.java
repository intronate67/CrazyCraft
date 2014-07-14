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
public class TPA implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope.");
            return true;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("cc.tpa")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        if(args.length != 1){
            p.sendMessage("Incorrect Usage!");
            return true;
        }
        Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(args[0]));
        if(targetPlayer != null){
            Location loc = targetPlayer.getLocation();
            p.teleport(loc);
            p.sendMessage("Teleported " + p.getName() + " to " + targetPlayer.getName());
            targetPlayer.sendMessage(p.getName() +  " teleported to you.");
            return true;
        }
        p.sendMessage("Player does not exist and/or is not online!");
        return true;
    }

}
