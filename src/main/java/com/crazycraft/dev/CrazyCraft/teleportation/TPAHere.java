package com.crazycraft.dev.CrazyCraft.teleportation;

import com.PUUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/13/2014.
 */
public class TPAHere implements CommandExecutor{

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
        if(!p.hasPermission("cc.tpahere")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(args[0]));
        if(targetPlayer != null){
            if(TP.getInstance().prevLoc.containsKey(targetPlayer.getUniqueId())){
                Location loc = TP.getInstance().prevLoc.get(targetPlayer.getUniqueId());
                TP.getInstance().prevLoc.remove(targetPlayer.getUniqueId(), loc);
                TP.getInstance().prevLoc.put(targetPlayer.getUniqueId(), targetPlayer.getLocation());
            }else {
                TPAccept.getInstance().hasRequest.put(p.getUniqueId(), targetPlayer.getName());
                targetPlayer.sendMessage(p.getName() + " has requested you teleport to them.");
                return true;
            }
        }
        p.sendMessage("Player does not exist and/or is not online!");
        return true;
    }

}
