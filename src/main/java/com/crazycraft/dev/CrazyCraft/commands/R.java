package com.crazycraft.dev.CrazyCraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/12/2014.
 */
public class R implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }

}