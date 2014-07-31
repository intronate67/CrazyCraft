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
        String name = null;
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getName().contains(args[0])){
                name = player.getName();
            }
        }
        Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(name));
        if(targetPlayer != null){
            TPAccept.getInstance().hasRequest.put(p.getUniqueId(), targetPlayer.getName());
            targetPlayer.sendMessage(p.getName() + " has requested to teleport to you.");
            return true;
        }
        p.sendMessage("Player does not exist and/or is not online!");
        return true;
    }

}
