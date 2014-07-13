package com.crazycraft.dev.CrazyCraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/12/2014.
 */
public class Who implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length != 0){
            p.sendMessage("Nope");
            return true;
        }
        int players = Bukkit.getServer().getOnlinePlayers().size();
        int maxPlayers = Bukkit.getServer().getMaxPlayers();

        p.sendMessage("Online players: " + players + "/" + maxPlayers);

        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }

}