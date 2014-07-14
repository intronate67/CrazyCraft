package com.crazycraft.dev.CrazyCraft.teleportation;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/13/2014.
 */
public class TPBack implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("You cannot do this!");
            return true;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("cc.tpback")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        if(args.length != 0){
            p.sendMessage("Incorrect Usage!");
            return true;
        }
        if(!TP.getInstance().prevLoc.containsKey(p.getUniqueId())){
            p.sendMessage("Go back to where?");
            return true;
        }
        Location loc = TP.getInstance().prevLoc.get(p.getUniqueId());
        TP.getInstance().prevLoc.remove(p.getUniqueId());
        p.teleport(loc);
        p.sendMessage("You have been brought back!");
        return true;
    }

}
