package com.crazycraft.dev.CrazyCraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

/**
 * Created by Server on 7/12/2014.
 */
public class PlayerTime implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args[0].equalsIgnoreCase("day")
                || args[0].equalsIgnoreCase("night")
                || args[0].equalsIgnoreCase("noon")
                || args[0].equalsIgnoreCase("dusk")
                || args[0].equalsIgnoreCase("dawn")){
            if(args[0].equalsIgnoreCase("day")){ //Set time to day.
                p.getWorld().setThundering(false);
                p.setPlayerTime(2000, true);
                p.sendMessage("Time set to morning.(8:00 A.M)");
                return true;
            }
            if(args[0].equalsIgnoreCase("night")){
                p.setPlayerTime(15000, true);
                p.sendMessage("Time set to night.(9:00 P.M)");
                return true;
            }
            if(args[0].equalsIgnoreCase("dawn")){
                p.setPlayerTime(0000, true);
                p.sendMessage("Time set to dawn.(6:00 A.M)");
                return true;
            }
            if(args[0].equalsIgnoreCase("noon")){
                p.setPlayerTime(6000, true);
                p.sendMessage("Time set to noon.(12:00 P.M)");
                return true;
            }
            if(args[0].equalsIgnoreCase("dusk")){
                p.setPlayerTime(11000, true);
                p.sendMessage("Time set to night.(5:00 P.M)");
                return true;
            }
            return true;
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
