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
public class UnMute implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length != 1){
            p.sendMessage("Incorrent usage!");
            return true;
        }
        if(!p.hasPermission("cc.unmute")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        Player targetPlayer = Bukkit.getPlayer(UUID.fromString(PUUID.getUUID(args[0])));
        if(!Mute.getInstance().isMuted.contains(targetPlayer.getUniqueId())){
            p.sendMessage("Player is not muted!");
        }else{
            Mute.getInstance().isMuted.remove(targetPlayer.getUniqueId());
            targetPlayer.sendMessage("You are no longer muted!");
            p.sendMessage("You have unmuted player " + targetPlayer.getName());
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
