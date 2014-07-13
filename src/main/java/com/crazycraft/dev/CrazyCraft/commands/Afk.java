package com.crazycraft.dev.CrazyCraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Server on 7/12/2014.
 */
public class Afk implements CommandExecutor{

    private static Afk instance = new Afk();

    public static Afk getInstance(){
        return instance;
    }

    public List<UUID> isAfk = new ArrayList<UUID>();

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(isAfk.contains(p.getUniqueId())){
            p.sendMessage("You are already afk!");
            return true;
        }
        isAfk.add(p.getUniqueId());
        p.sendMessage("You are now afk");
        Bukkit.getServer().broadcastMessage(p.getName() + " is now afk.");
        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "cc.afk";
    }

}
