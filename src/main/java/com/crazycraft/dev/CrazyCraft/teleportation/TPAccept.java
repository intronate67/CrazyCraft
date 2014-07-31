package com.crazycraft.dev.CrazyCraft.teleportation;

import com.PUUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by Server on 7/13/2014.
 */
public class TPAccept implements CommandExecutor{

    public HashMap<UUID, String> hasRequest = new HashMap<UUID,String>();

    private static TPAccept instance = new TPAccept();

    public static TPAccept getInstance(){
        return instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("You cannot do this!");
            return true;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("cc.tpaccept")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        if(args.length != 0){
            p.sendMessage("Incorrect Usage!");
            return true;
        }
        if(!hasRequest.containsKey(p.getName())){
            p.sendMessage("You do not have any current requests!");
            return true;
        }else{

            Player requestP = Bukkit.getPlayer(hasRequest.get(p.getName()));
            if(TP.getInstance().prevLoc.containsKey(requestP.getUniqueId())){
                Location loc = TP.getInstance().prevLoc.get(requestP.getUniqueId());
                TP.getInstance().prevLoc.remove(requestP.getUniqueId(), loc);
                TP.getInstance().prevLoc.put(requestP.getUniqueId(), requestP.getLocation());
            }else{
                TP.getInstance().prevLoc.put(requestP.getUniqueId(), requestP.getLocation());
            }
            requestP.teleport(p.getLocation());
            requestP.sendMessage("Teleported " + requestP.getName() + " to " + p.getName());
            p.sendMessage(requestP.getName() +  " teleported to you.");
        }
        return true;
    }

}
