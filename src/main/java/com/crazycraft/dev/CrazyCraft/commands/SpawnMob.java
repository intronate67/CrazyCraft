package com.crazycraft.dev.CrazyCraft.commands;

import org.apache.commons.lang.enums.ValuedEnum;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Created by Server on 7/12/2014.
 */
public class SpawnMob implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd,String lable ,String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope");
            return true;
        }
        Player p = (Player) sender;
        if(args.length != 1){
            p.sendMessage("Incorrect Usage!");
            return true;
        }
        if(!p.hasPermission("cc.spawnmob")){
            p.sendMessage("You do not have permission!");
            return true;
        }
        double x = p.getTargetBlock(null, 100).getLocation().getX();
        double y = p.getTargetBlock(null, 100).getLocation().getY() + 1;
        double z = p.getTargetBlock(null, 100).getLocation().getZ();
        Location loc = new Location(p.getWorld(), x, y, z);
        String mob = args[0];
        Mob mobType = Mob.valueOf(args[0]);
        switch (mobType){
            case ZOMBIE:
                p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                p.sendMessage("Spawned 1 " + mob);
                break;
            case SPIDER:
                p.getWorld().spawnEntity(loc, EntityType.SPIDER);
                p.sendMessage("Spawned 1 " + mob);
                break;
            case CREEPER:
                p.getWorld().spawnEntity(loc, EntityType.CREEPER);
                p.sendMessage("Spawned 1 " + mob);
                break;
            case SKELETON:
                p.getWorld().spawnEntity(loc, EntityType.SKELETON);
                p.sendMessage("Spawned 1 " + mob);
                break;
            case ENDERMAN:
                p.getWorld().spawnEntity(loc, EntityType.ENDERMAN);
                p.sendMessage("Spawned 1 " + mob);
                break;
            case WITCH:
                p.getWorld().spawnEntity(loc, EntityType.WITCH);
                p.sendMessage("Spawned 1 " + mob);
                break;
            case SLIME:
                p.getWorld().spawnEntity(loc, EntityType.SLIME);
                p.sendMessage("Spawned 1 " + mob);
                break;
            case GHAST:
                p.getWorld().spawnEntity(loc, EntityType.GHAST);
                p.sendMessage("Spawned 1 " + mob);
                break;
            case ZOMBIE_PIGMAN:
                p.getWorld().spawnEntity(loc, EntityType.PIG_ZOMBIE);
                p.sendMessage("Spawned 1 " + mob);
                break;
            case BLAZE:
                p.getWorld().spawnEntity(loc, EntityType.BLAZE);
                p.sendMessage("Spawned 1 " + mob);
                break;
            case MAGMA_CUBE:
                p.getWorld().spawnEntity(loc, EntityType.MAGMA_CUBE);
                p.sendMessage("Spawned 1 " + mob);
                break;
            case BAT:
                p.sendMessage("Spawned 1 " + mob);
                p.getWorld().spawnEntity(loc, EntityType.BAT);
                break;
            case PIG:
                p.sendMessage("Spawned 1 " + mob);
                p.getWorld().spawnEntity(loc, EntityType.PIG);
                break;
            case SHEEP:
                p.sendMessage("Spawned 1 " + mob);
                p.getWorld().spawnEntity(loc, EntityType.SHEEP);
                break;
            case MOOSHROOM:
                p.sendMessage("Spawned 1 " + mob);
                p.getWorld().spawnEntity(loc, EntityType.MUSHROOM_COW);
                break;
            case COW:
                p.sendMessage("Spawned 1 " + mob);
                p.getWorld().spawnEntity(loc, EntityType.COW);
                break;
            case VILLAGER:
                p.sendMessage("Spawned 1 " + mob);
                p.getWorld().spawnEntity(loc, EntityType.VILLAGER);
                break;
            case CHICKEN:
                p.sendMessage("Spawned 1 " + mob);
                p.getWorld().spawnEntity(loc, EntityType.CHICKEN);
                break;
            case OCELOT:
                p.sendMessage("Spawned 1 " + mob);
                p.getWorld().spawnEntity(loc, EntityType.OCELOT);
                break;
            case HORSE:
                p.sendMessage("Spawned 1 " + mob);
                p.getWorld().spawnEntity(loc, EntityType.HORSE);
                break;
            case WOLF:
                p.sendMessage("Spawned 1 " + mob);
                p.getWorld().spawnEntity(loc, EntityType.WOLF);
                break;
            case WITHER:
                p.sendMessage("Spawned 1 " + mob);
                p.getWorld().spawnEntity(loc, EntityType.WITHER);
                break;
            case ENDER_DRAGON:
                p.sendMessage("Spawned 1 " + mob);
                p.getWorld().spawnEntity(loc, EntityType.ENDER_DRAGON);
                break;
            default:
                p.sendMessage("Invalid Mob Type");
                break;

        }


        return true;
    }

    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }
    private enum Mob{
        ZOMBIE,
        SPIDER,
        CREEPER,
        SKELETON,
        ENDERMAN,
        WITCH,
        SLIME,
        GHAST,
        ZOMBIE_PIGMAN,
        BLAZE,
        MAGMA_CUBE,
        BAT,
        VILLAGER,
        PIG,
        SHEEP,
        MOOSHROOM,
        COW,
        CHICKEN,
        OCELOT,
        HORSE,
        WOLF,
        WITHER,
        ENDER_DRAGON;
    }
}