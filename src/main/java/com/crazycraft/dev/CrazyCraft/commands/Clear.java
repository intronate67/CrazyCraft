package com.crazycraft.dev.CrazyCraft.commands;

import com.crazycraft.dev.CrazyCraft.UUIDGetter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Server on 7/12/2014.
 */
public class Clear implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length == 0){
            p.setItemInHand(null);
            p.sendMessage("Cleared the item in your hand.");
            return true;
        }
        if(args.length == 1){
            if(args[0].equalsIgnoreCase("-a")){
                p.sendMessage("Cleared your inventory.");
                p.getInventory().clear();
                return true;
            }
            p.sendMessage("Nope.");
            return true;
        }
        if(args.length == 2){
            if(!p.hasPermission("cc.clear.other")) return true;
            UUIDGetter getter = new UUIDGetter(Arrays.asList(args[1]));
            Map<String, UUID> response = null;
            try{
                response = getter.call();
            }catch(Exception e){
                e.printStackTrace();
            }
            Player targetPlayer = Bukkit.getPlayer(response.get(args[1]));
            targetPlayer.getInventory().clear();
            targetPlayer.sendMessage("You inventory has been cleared by: " + p.getName() + " ;)");
            return true;
        }

        return true;
    }

    public String help(Player p){
        return "clear an inventory";
    }
    public String permission(){
        return "cc.inv";
    }

}
