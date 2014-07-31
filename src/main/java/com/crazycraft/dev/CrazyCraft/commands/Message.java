package com.crazycraft.dev.CrazyCraft.commands;

import com.PUUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

        Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(args[0]));

        StringBuilder str = new StringBuilder();
        for(int i = 1; i < args.length; i++){
            str.append(args[i] + " ");
        }
        String msg = str.toString();

        if(!targetPlayer.isOnline()) p.sendMessage("Player is not online");
        //Message to target.
        R.getInstance().hasMessage.put(targetPlayer.getUniqueId(), p.getName());
        R.getInstance().hasMessage.put(p.getUniqueId(), targetPlayer.getName());
        targetPlayer.sendMessage(ChatColor.AQUA + "[" + ChatColor.DARK_AQUA +"From " + ChatColor.DARK_RED + p.getName()+ ChatColor.AQUA + "]: " + ChatColor.RED +msg);
        p.sendMessage(ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "To " + ChatColor.DARK_RED +targetPlayer.getName() + ChatColor.AQUA +"]: " + ChatColor.RED + msg);
        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }

}
