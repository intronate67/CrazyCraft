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
public class TPReject implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Players cannot teleport to console.");
            return true;
        }
        if(args.length != 1){
            sender.sendMessage("Incorrect Usage!");
            return true;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("cc.tpreject")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        if(!TPAccept.getInstance().hasRequest.containsKey(p.getName())){
            p.sendMessage("You do not have a request!");
            return true;
        }
        Player targetPlayer = Bukkit.getPlayer(TPAccept.getInstance().hasRequest.get(p.getName()));
        if(targetPlayer != null){
            targetPlayer.sendMessage(p.getName() + " has denied your request!");
        }else{
            p.sendMessage("Player does not exist and/or is not online!");
        }
        return true;
    }

}
