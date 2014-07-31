package com.crazycraft.dev.CrazyCraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Server on 7/30/2014.
 */
public class Mail implements CommandExecutor{

    private static Mail instance = new Mail();

    public static Mail getInstance(){
        return instance;
    }

    private Map<UUID, String> hasMail;

    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length != 1){
            p.sendMessage("Incorrect usage");
            return true;
        }
        if(!p.hasPermission("cc.mail")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        if(!hasMail.containsKey(p.getUniqueId())){
            p.sendMessage("You do not have any mail!");
            return true;
        }
        return true;
    }

}
