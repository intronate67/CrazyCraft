package com.crazycraft.dev.CrazyCraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * Created by Server on 7/12/2014.
 */
public class UnGod implements CommandExecutor {

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
        if(!p.hasPermission("cc.ungod")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        if(!God.getInstance().isGod.contains(p.getUniqueId())){
            p.sendMessage("You are not godded!");
        }else{
            God.getInstance().isGod.remove(p.getUniqueId());
            p.sendMessage("You are now ungodded!");
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
