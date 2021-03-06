package com.crazycraft.dev.CrazyCraft.commands;

import com.PUUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Server on 7/12/2014.
 */
public class Slay implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length != 1){
            p.sendMessage("Incorrect usage!");
            return true;
        }
        if(!p.hasPermission("cc.slay")){
            p.sendMessage("You do not have permission!");
            return true;
        }

        Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(args[0]));
        targetPlayer.setHealth(0);
        targetPlayer.setFireTicks(10);
        Bukkit.getServer().broadcastMessage(ChatColor.BLUE + p.getName() + ChatColor.GRAY +" has slayed " + ChatColor.BLUE +targetPlayer.getName());
        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }

}
