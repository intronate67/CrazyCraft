package com.crazycraft.dev.CrazyCraft.commands;

import com.PUUID;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Server on 7/12/2014.
 */
public class Message implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }

        Player p = (Player) sender;

        Player targetPlayer = Bukkit.getPlayer(UUID.fromString(PUUID.getUUID(args[0])));

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < args.length; i++){
            str.append(args[i]);
        }
        String msg = str.toString();

        if(!targetPlayer.isOnline()) p.sendMessage("Player is not online");
        //Message to target.
        targetPlayer.sendMessage("From " + p.getName()+ ": " + msg);
        p.sendMessage("To " + targetPlayer.getName() + ": " + msg);
        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }

}
