package com.crazycraft.dev.CrazyCraft.teleportation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Server on 7/13/2014.
 */
public class TPToggle implements CommandExecutor{

    public List<UUID> toggle = new ArrayList<UUID>();

    private static TPToggle instance = new TPToggle();

    public static TPToggle getInstance(){
        return instance;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Console cannot toggle your teleportation");
            return true;
        }
        Player p = (Player) sender;
        if(args.length != 0){
            p.sendMessage("Incorrect Usage!");
            return true;
        }
        if(!toggle.contains(p.getUniqueId())){
            p.sendMessage("You have disabled Teleport access.");
            return true;
        }else{
            toggle.remove(p.getUniqueId());
            p.sendMessage("You have re-enabled Teleport access.");
        }
        return true;
    }

}
