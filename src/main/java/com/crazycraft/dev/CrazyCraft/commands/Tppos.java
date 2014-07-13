package com.crazycraft.dev.CrazyCraft.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/12/2014.
 */
public class Tppos implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length != 3){
            p.sendMessage("Nope");
            return true;
        }
        Location loc = new Location(p.getWorld(), Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        p.teleport(loc);
        return true;
    }
    private boolean isInteger(){
        return false;
    }
    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }

}
