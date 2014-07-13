package com.crazycraft.dev.CrazyCraft.commands;

import com.crazycraft.dev.CrazyCraft.UUIDGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Hunter Sharpe
 */
public class GameMode implements CommandExecutor {



    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length < 1){
            p.sendMessage("Incorrect command usage!");
            return true;
        }
        if(args.length == 2){
            UUIDGetter getter = new UUIDGetter(Arrays.asList(args[1]));
            Map<String, UUID> response = null;
            try{
                response = getter.call();
            }catch(Exception e){
                e.printStackTrace();
            }

            Player targetPlayer = Bukkit.getPlayer(response.get(args[1]));
            if(!p.hasPermission("cc.gm.other")) return true;
            if(args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("creative")){
                if(targetPlayer.getGameMode().equals(org.bukkit.GameMode.CREATIVE)){
                    return true;
                }
                targetPlayer.setGameMode(org.bukkit.GameMode.CREATIVE);
                targetPlayer.sendMessage(ChatColor.YELLOW + "Your gamemode has been changed!");
                p.sendMessage(ChatColor.YELLOW + "You have changed " + targetPlayer.getName() + "'s gamemode.");
                return true;
            }
            if(args[1].equalsIgnoreCase("0") || args[1].equalsIgnoreCase("survival")){
                if(targetPlayer.getGameMode().equals(org.bukkit.GameMode.SURVIVAL)){
                    return true;
                }
                targetPlayer.setGameMode(org.bukkit.GameMode.SURVIVAL);
                targetPlayer.sendMessage(ChatColor.YELLOW + "Your gamemode has been changed!");
                p.sendMessage(ChatColor.YELLOW + "You have changed " + targetPlayer.getName() + "'s gamemode.");
                return true;
            }
            return true;
        }
        if(args.length == 1){
            if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")){
                if(p.getGameMode().equals(org.bukkit.GameMode.CREATIVE)){
                    p.sendMessage("You are already in creative.");
                    return true;
                }

                p.setGameMode(org.bukkit.GameMode.CREATIVE);
                p.sendMessage("You are now in creative.");
                return true;
            }
            if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")){
                if(p.getGameMode().equals(org.bukkit.GameMode.SURVIVAL)){
                    p.sendMessage("You are already in survival.");
                    return true;
                }

                p.setGameMode(org.bukkit.GameMode.SURVIVAL);
                p.sendMessage("You are now in survival.");
                return true;
            }
        }
        return true;
    }

}
