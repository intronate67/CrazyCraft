package com.crazycraft.dev.CrazyCraft.commands;

import com.crazycraft.dev.CrazyCraft.CrazyCraft;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/12/2014.
 */
public class Home implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length == 0) {
            if (!CrazyCraft.getInstance().homeConf.contains(p.getName())) {
                p.sendMessage("nope");
                return true;
            }
            if (CrazyCraft.getInstance().homeConf.getString("players." + p.getName() + "home") == null) {
                p.sendMessage("You do not have a home!");
                return true;
            }
            FileConfiguration config = CrazyCraft.getInstance().homeConf;
            World world = Bukkit.getWorld(config.getString("players." + p.getName() + "home.world"));
            double x = config.getDouble("players." + p.getName() + "home.x");
            double y = config.getDouble("players." + p.getName() + "home.x");
            double z = config.getDouble("players." + p.getName() + "home.x");
            Location loc = new Location(world, x, y + 1, z);
            p.teleport(loc);
            p.sendMessage("Welcome to your home!");
            return true;
        }
        if(args.length > 1){
            p.sendMessage("Incorrect Command Usage");
            return true;
        }
        if(args[0].equalsIgnoreCase("set")){
            FileConfiguration config = CrazyCraft.getInstance().homeConf;
            Location loc = p.getLocation();
            config.set("players." + p.getName() + "home.world", loc.getWorld().getName());
            config.set("players." + p.getName() + "home.world", loc.getWorld().getName());
            config.set("players." + p.getName() + "home.world", loc.getWorld().getName());
            config.set("players." + p.getName() + "home.world", loc.getWorld().getName());
            p.sendMessage("Home set.");
        }else{
            p.sendMessage("Incorrect command usage!");
        }
        return true;
    }

    public String help(Player p){

        return "";

    }
    public String permission(){

        return "cc.home";

    }

}