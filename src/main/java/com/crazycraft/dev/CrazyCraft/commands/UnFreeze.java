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
public class UnFreeze  implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;

        if(args.length != 1){
            p.sendMessage("Nope");
            return true;
        }
        if(!Freeze.getInstance().isFrozen.contains(UUID.fromString(PUUID.getUUID(args[0])))){
            p.sendMessage("Player is not frozen");
        }
        Freeze.getInstance().isFrozen.remove(UUID.fromString(PUUID.getUUID(args[0])));
        Player targetPlayer = Bukkit.getPlayer(UUID.fromString(PUUID.getUUID(args[0])));
        targetPlayer.sendMessage("You have been un-froze.");
        p.sendMessage("You have un-froze player: " + targetPlayer.getName());
        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }

}