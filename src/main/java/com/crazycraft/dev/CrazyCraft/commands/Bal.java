package com.crazycraft.dev.CrazyCraft.commands;

import com.crazycraft.dev.CrazyCraft.economy.EconManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/16/2014.
 */

public class Bal implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Console cannot have a balance!");
            return true;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("cc.bal")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        if(args.length > 1){
            p.sendMessage(String.format("%sRequired %s- %sOptional", ChatColor.RED, ChatColor.DARK_GRAY, ChatColor.GREEN));
            p.sendMessage(String.format("%s/bal %s[%splayername%s]", ChatColor.RED, ChatColor.GREEN, ChatColor.RED, ChatColor.GREEN));
            return true;
        }
        if(args.length == 1){
            if(!p.hasPermission("cc.bal.other")){
                p.sendMessage("You do not have permission!");
                return true;
            }
            if(!EconManager.hasAccount(args[0])){
                p.sendMessage("Player does not have an account!");
                return true;
            }
            p.sendMessage(args[0] + "'s balance is: " + EconManager.getBalance(args[0]));
        }else{
            if(!EconManager.hasAccount(p.getName())){
                p.sendMessage("You do not have an account!");
                return true;
            }
            p.sendMessage("Your current balance is: " + EconManager.getBalance(p.getName()));
        }
        return true;
    }

}
