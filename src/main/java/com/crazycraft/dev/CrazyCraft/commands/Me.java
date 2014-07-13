package com.crazycraft.dev.CrazyCraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/12/2014.
 */
public class Me implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length < 1){
            p.sendMessage("/me <msg>");
            return true;
        }
        StringBuilder builder = new StringBuilder();
        for( int i = 0; i < args.length; i++){
            builder.append(args[i] + " ");
        }
        String msg = builder.toString();
        Bukkit.getServer().broadcastMessage(ChatColor.ITALIC + " * " + ChatColor.GRAY + p.getName() + " " + msg);
        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "cc.me";
    }

}
