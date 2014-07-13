package com.crazycraft.dev.CrazyCraft.commands;

import com.crazycraft.dev.CrazyCraft.CrazyCraft;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Server on 7/12/2014.
 */
public class Seen implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        if(args.length != 1){
            sender.sendMessage("Incorrect command usage.");
        }
        Player p = (Player) sender;
        if(!p.hasPermission("cc.seen")){
            p.sendMessage("You do not have permission.");
            return true;
        }
        p.sendMessage(String.format("%s-------- %sInfo for Player " + args[0] + " %s--------", ChatColor.DARK_GRAY, ChatColor.BLUE, ChatColor.DARK_GRAY));
        String onlineLoc = null;
        String status = null;
        if(p.isOnline()){
            onlineLoc = "-----Login Location----";
            status = ChatColor.GREEN + "ONLINE";
        }else{
            onlineLoc = String.format("%s----%sLogout Location%s----", ChatColor.DARK_GRAY, ChatColor.BLUE, ChatColor.DARK_GRAY);
            status = ChatColor.RED + "OFFLINE";
        }
        p.sendMessage(ChatColor.BLUE + "Status: " + status);
        p.sendMessage(onlineLoc);
        p.sendMessage(ChatColor.BLUE + "World: " + CrazyCraft.getInstance().getConfig().getString("players." + args[0] + ".location.world"));
        p.sendMessage(ChatColor.BLUE + "X: " + CrazyCraft.getInstance().getConfig().getString("players." + args[0] + ".location.X"));
        p.sendMessage(ChatColor.BLUE + "Y: " + CrazyCraft.getInstance().getConfig().getString("players." + args[0] + ".location.Y"));
        p.sendMessage(ChatColor.BLUE + "Z: " + CrazyCraft.getInstance().getConfig().getString("players." + args[0] + ".location.Z"));
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date = CrazyCraft.getInstance().getConfig().getString("players." + args[0] + "date");
        p.sendMessage(ChatColor.BLUE + "Last Joined: " + date);
        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }

}
