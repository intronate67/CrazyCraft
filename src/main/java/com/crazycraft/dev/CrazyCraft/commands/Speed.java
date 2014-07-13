package com.crazycraft.dev.CrazyCraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/12/2014.
 */
public class Speed implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length != 1){
            p.sendMessage("Incorrect Usage!");
            return true;
        }
        if(!p.hasPermission("cc.speed")){
            p.sendMessage("You do not haver permission!");
            return true;
        }
        if(p.isFlying()){
            p.setFlySpeed(Float.parseFloat(args[0]));
            p.sendMessage("Set your fly speed to: " + args[0]);
            return true;
        }else{
            p.setWalkSpeed(Float.parseFloat(args[0]));
            p.sendMessage("Set your walk speed to: " + args[0]);
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
