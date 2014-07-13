package com.crazycraft.dev.CrazyCraft.commands;

import com.PUUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.UUID;

/**
 * Created by Server on 7/12/2014.
 */
public class Slap implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("cc.slap")){
            p.sendMessage("You do not have permission.");
            return true;
        }
        if(args.length < 1 || args.length > 2){
            p.sendMessage("Incorrect Usage");
        }

        if(Bukkit.getPlayer(UUID.fromString(PUUID.getUUID(args[0]))) != null){
            Player targetPlayer = Bukkit.getPlayer(UUID.fromString(PUUID.getUUID(args[0])));
            if(args.length != 2){
                targetPlayer.setVelocity(new Vector(0, 2, 20));
                Bukkit.broadcastMessage(ChatColor.BLUE + p.getName() + ChatColor.GRAY + " slapped "+ ChatColor.BLUE + targetPlayer.getName());
                return true;
            }
            if(args[1].contains("-")){
                if(args[1].equalsIgnoreCase("-h")){
                    targetPlayer.setVelocity(new Vector(0, 4, 40));
                    Bukkit.broadcastMessage(ChatColor.BLUE + p.getName() + ChatColor.GRAY + " slapped "+ ChatColor.BLUE + targetPlayer.getName() + ChatColor.GRAY +", hard.");
                    return true;
                }
                if(args[1].equalsIgnoreCase("-d")){
                    targetPlayer.setVelocity(new Vector(0, 2, 20));
                    targetPlayer.setHealth(targetPlayer.getHealth() - 2);
                    Bukkit.broadcastMessage(ChatColor.BLUE + p.getName() + ChatColor.GRAY + " slapped "+ ChatColor.BLUE + targetPlayer.getName());
                    return true;
                }
                if(args[1].equalsIgnoreCase("-v")){
                    targetPlayer.setVelocity(new Vector(0, 2, 20));
                    Bukkit.broadcastMessage(ChatColor.BLUE + p.getName() + ChatColor.GRAY + " slapped "+ ChatColor.BLUE + targetPlayer.getName() + ChatColor.GRAY + ", very hard.");
                    return true;
                }
                if(args[1].equalsIgnoreCase("-s")){
                    targetPlayer.setVelocity(new Vector(0, 2, 20));
                    return true;
                }
                return true;
            }
            p.sendMessage("Invalid usage!");
        }else{
            p.sendMessage("Player is invalid an/or not online.");
        }
        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }

}
