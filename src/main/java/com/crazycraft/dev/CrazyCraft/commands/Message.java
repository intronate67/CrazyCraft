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
public class Message implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }

        Player p = (Player) sender;

        UUIDGetter getter = new UUIDGetter(Arrays.asList(args[0]));
        Map<String, UUID> response = null;
        try{
            response = getter.call();
        }catch(Exception e){
            e.printStackTrace();
        }
        Player targetPlayer = Bukkit.getPlayer(response.get(args[0]));

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < args.length; i++){
            str.append(args[i]);
        }
        String msg = str.toString();

        if(!targetPlayer.isOnline()) p.sendMessage("Player is not online");
        //Message to target.
        targetPlayer.sendMessage("From " + p.getName()+ ": " + msg);
        p.sendMessage("To " + targetPlayer.getName() + ": " + msg);
        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }

}
