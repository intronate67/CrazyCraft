package com.crazycraft.dev.CrazyCraft.teleportation;

import com.PUUID;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/13/2014.
 */
public class TPSilent implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("You cannot do this!");
            return true;
        }
        Player p = (Player) sender;
        if(args.length != 1){
            p.sendMessage("Incorrect usage!");
            return true;
        }
        if(!p.hasPermission("cc.tpsilent")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        String name = null;
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getName().contains(args[0])){
                name = player.getName();
            }
        }
        Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(name));
        if(targetPlayer != null){
            p.teleport(targetPlayer.getLocation());
            p.sendMessage("You have teleported to "+ targetPlayer.getName() + ", but they don't know that... Hopefully ;)");
            return true;
        }
        p.sendMessage("Player does not exist and/or is not online!");
        return true;
    }

}
