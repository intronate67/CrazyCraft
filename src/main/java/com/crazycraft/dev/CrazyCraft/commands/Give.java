package com.crazycraft.dev.CrazyCraft.commands;

import com.PUUID;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

/**
 * Created by Server on 7/12/2014.
 */
public class Give implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length < 2 || args.length > 3){
            p.sendMessage("Nope");
            return true;
        }
        if(args.length == 2){
            if(args[0].equalsIgnoreCase(p.getName())) {
                ItemStack itemStack = new ItemStack(Material.getMaterial(args[1].toUpperCase()), 64);
                p.sendMessage("Gave you 64 of " + args[1]);
                p.getInventory().addItem(itemStack);
                return true;
            }
            Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(args[0]));
            if(targetPlayer != null){
                ItemStack itemStack = new ItemStack((Material.getMaterial(args[1].toUpperCase())), 64);
                targetPlayer.getInventory().addItem(itemStack);
                p.sendMessage("Gave player: " + args[0] + " 64 of " + args[1]);
                return true;
            }
            p.sendMessage("Player is not online...");
            return true;
        }
        if(args.length == 3){
            if(args[0].equalsIgnoreCase(p.getName())){
                ItemStack itemStack = new ItemStack(Material.getMaterial(args[1].toUpperCase()), Integer.parseInt(args[2]));
                p.sendMessage("Gave you " + args[2] + " of " + args[1]);
                p.getInventory().addItem(itemStack);
                return true;
            }
            Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(args[0]));
            if(targetPlayer != null){
                ItemStack itemStack = new ItemStack((Material.getMaterial(args[1].toUpperCase())), Integer.parseInt(args[2]));
                targetPlayer.getInventory().addItem(itemStack);
                p.sendMessage("Gave player: " + args[0] + args[2] + " of " + args[1]);
                return true;
            }
            p.sendMessage("Player is not online...");
            return true;
        }
        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }

}
