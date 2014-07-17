package com.crazycraft.dev.CrazyCraft.commands;

import com.PUUID;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * Created by Server on 7/12/2014.
 */
public class Mute implements CommandExecutor {

    private static Mute instance = new Mute();

    public static Mute getInstance(){
        return instance;
    }

    public List<UUID> isMuted = new ArrayList<UUID>();

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length != 1){
            p.sendMessage("Nope");
        }
        Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(args[0]));
        if(!targetPlayer.isOnline()){
            p.sendMessage("Player is not online.");
            return true;
        }
        isMuted.add(targetPlayer.getUniqueId());
        p.sendMessage("Muted player " + targetPlayer.getName());
        targetPlayer.sendMessage("You have been muted.");
        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }

}
