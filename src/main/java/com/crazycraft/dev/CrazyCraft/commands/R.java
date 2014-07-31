package com.crazycraft.dev.CrazyCraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Server on 7/12/2014.
 */
public class R implements CommandExecutor {

    private static R instance = new R();

    public static R getInstance(){
        return instance;
    }

    public Map<UUID, String> hasMessage;

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length < 0){
            p.sendMessage("");
            return true;
        }
        if(!hasMessage.containsKey(p.getUniqueId())){
            p.sendMessage("You are not messaging someone");
            return true;
        }
        Player player = Bukkit.getPlayer(hasMessage.get(p.getUniqueId()));
        if(player == null || !player.isOnline()){
            p.sendMessage("Player is not online anymore");
        }
        StringBuilder str = new StringBuilder();
        for(int i = 1; i < args.length; i++){
            str.append(args[i] + " ");
        }
        String msg = str.toString();
        player.sendMessage(ChatColor.AQUA + "[" + ChatColor.DARK_AQUA +"From " + ChatColor.DARK_RED + p.getName()+ ChatColor.AQUA + "]: " + ChatColor.RED +msg);
        p.sendMessage(ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "To " + ChatColor.DARK_RED + player.getName() + ChatColor.AQUA +"]: " + ChatColor.RED + msg);
        return true;
    }

}