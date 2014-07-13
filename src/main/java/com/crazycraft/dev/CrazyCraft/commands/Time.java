package com.crazycraft.dev.CrazyCraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Server on 7/12/2014.
 */
public class Time implements CommandExecutor {

    public HashMap<String, String> isLocked = new HashMap<String, String>();

    private static Time instance = new Time();

    public static Time getInstance(){
        return instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length < 1 || args.length > 2){
            p.sendMessage("Nope");
            return true;
        }
        if(args.length == 2){
            if(args[1].equalsIgnoreCase("-l")){ //Lock/Unlock the time.
                if(isLocked.containsKey(p.getWorld().getName())){
                    isLocked.remove(p.getWorld().getName(), isLocked.get(p.getWorld().getName()));
                    p.sendMessage("You have unlocked the time in your world.");
                }
                if(args[1].contains(Arrays.asList("day", "night", "dawn", "morning","noon", "dusk").toString())){
                    if(args[1].equalsIgnoreCase("day")){ //Set time to day.
                        p.getWorld().setThundering(false);
                        p.getWorld().setTime(8000);
                        isLocked.put(p.getWorld().getName(), args[1]);
                        p.sendMessage("Locked the Time to morning.(8:00 A.M)");
                        return true;
                    }
                    if(args[1].equalsIgnoreCase("night")){
                        p.getWorld().setTime(21000);
                        isLocked.put(p.getWorld().getName(), args[1]);
                        p.sendMessage("Locked the Time to night.(9:00 P.M)");
                        return true;
                    }
                    if(args[1].equalsIgnoreCase("dawn")){
                        p.getWorld().setTime(6000);
                        isLocked.put(p.getWorld().getName(), args[1]);
                        p.sendMessage("Locked the Time to dawn.(6:00 A.M)");
                        return true;
                    }
                    if(args[1].equalsIgnoreCase("noon")){
                        p.getWorld().setTime(12000);
                        isLocked.put(p.getWorld().getName(), args[1]);
                        p.sendMessage("Locked the Time to noon.(12:00 P.M)");
                        return true;
                    }
                    if(args[1].equalsIgnoreCase("dusk")){
                        p.getWorld().setTime(17000);
                        isLocked.put(p.getWorld().getName(), args[1]);
                        p.sendMessage("Locked the Time to night.(5:00 P.M)");
                        return true;
                    }
                    return true;
                }
                p.sendMessage("Not a valid time.");
                return true;
            }
            p.sendMessage("Nope.");
            return true;
        }
        if(args[0].equalsIgnoreCase("day")
                || args[0].equalsIgnoreCase("night")
                || args[0].equalsIgnoreCase("noon")
                || args[0].equalsIgnoreCase("dusk")
                || args[0].equalsIgnoreCase("dawn")){
            if(args[0].equalsIgnoreCase("day")){ //Set time to day.
                p.getWorld().setThundering(false);
                p.getWorld().setTime(8000);
                p.sendMessage("Time set to morning.(8:00 A.M)");
                return true;
            }
            if(args[0].equalsIgnoreCase("night")){
                p.getWorld().setTime(21000);
                p.sendMessage("Time set to night.(9:00 P.M)");
                return true;
            }
            if(args[0].equalsIgnoreCase("dawn")){
                p.getWorld().setTime(6000);
                p.sendMessage("Time set to dawn.(6:00 A.M)");
                return true;
            }
            if(args[0].equalsIgnoreCase("noon")){
                p.getWorld().setTime(12000);
                p.sendMessage("Time set to noon.(12:00 P.M)");
                return true;
            }
            if(args[0].equalsIgnoreCase("dusk")){
                p.getWorld().setTime(17000);
                p.sendMessage("Time set to night.(5:00 P.M)");
                return true;
            }
            return true;
        }
        return true;
    }

}