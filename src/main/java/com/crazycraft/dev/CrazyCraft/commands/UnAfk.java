package com.crazycraft.dev.CrazyCraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/12/2014.
 */
public class UnAfk implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(!Afk.getInstance().isAfk.contains(p.getUniqueId())){
            p.sendMessage("You are not afk!");
            return true;
        }
        Afk.getInstance().isAfk.remove(p.getUniqueId());
        p.sendMessage("You are no longer afk");
        Bukkit.getServer().broadcastMessage(p.getName() + " is no longer afk.");
        return true;
    }
}
