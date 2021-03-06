package com.crazycraft.dev.CrazyCraft.commands;

import com.PUUID;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.*;

/**
 * Created by Server on 7/12/2014.
 */
public class Freeze implements Listener, CommandExecutor{

    private static Freeze instance = new Freeze();

    public static Freeze getInstance(){
        return instance;
    }

    public List<UUID> isFrozen = new ArrayList<UUID>();

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length != 1){
            p.sendMessage("Nope.");
            return true;
        }

        Player targetPlayer = Bukkit.getPlayer(PUUID.getUUID(args[0]));
        isFrozen.add(targetPlayer.getUniqueId());
        targetPlayer.sendMessage("You are now frozen.");
        p.sendMessage("You have frozen player: " + targetPlayer.getName());
        return true;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        if(isFrozen.contains(e.getPlayer().getUniqueId())){
            e.setTo(e.getFrom());
            e.setCancelled(true);
        }
    }
}