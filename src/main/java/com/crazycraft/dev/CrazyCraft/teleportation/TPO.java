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
public class TPO implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope.");
            return true;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("cc.tpo")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        if(args.length != 1){
            p.sendMessage("Incorrect Usage!");
            return true;
        }
        String name = null;
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getName().contains(args[0])){
                name = player.getName();
            }
        }
        Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(name));
        if(Bukkit.getOnlinePlayers().contains(targetPlayer)){
            if(TP.getInstance().prevLoc.containsKey(p.getUniqueId())){
                Location loc = TP.getInstance().prevLoc.get(p.getUniqueId());
                TP.getInstance().prevLoc.remove(p.getUniqueId(), loc);
                TP.getInstance().prevLoc.put(p.getUniqueId(), p.getLocation());
            }else{
                TP.getInstance().prevLoc.put(p.getUniqueId(), p.getLocation());
            }
            if(TP.getInstance().prevLoc.containsKey(targetPlayer.getUniqueId())){
                Location loc = TP.getInstance().prevLoc.get(targetPlayer.getUniqueId());
                TP.getInstance().prevLoc.remove(targetPlayer.getUniqueId(), loc);
                TP.getInstance().prevLoc.put(targetPlayer.getUniqueId(), targetPlayer.getLocation());
            }else {
                Location loc = targetPlayer.getLocation();
                p.teleport(loc);
                p.sendMessage("Teleported " + p.getName() + " to " + targetPlayer.getName());
                targetPlayer.sendMessage(p.getName() + " teleported to you.");
                return true;
            }
            return true;
        }
        p.sendMessage("Player does not exist and/or is not online!");
        return true;
    }

}
