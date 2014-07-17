package com.crazycraft.dev.CrazyCraft.economy;

import com.crazycraft.dev.CrazyCraft.CrazyCraft;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Server on 7/16/2014.
 */
public class EconManager {

    private static CrazyCraft plugin;

    public EconManager(CrazyCraft instance){
        plugin = instance;
    }

    public static HashMap<String, Double> bal = new HashMap<String, Double>(); // {PlayerName, Balance}

    public static void setBalance(String player, double amount)
    {
        bal.put(player, amount);
    }

    public static Double getBalance(String player)
    {
        return bal.get(player);
    }

    public static boolean hasAccount(String player)
    {
        return bal.containsKey(player);
    }

    public static HashMap<String, Double> getBalanceMap()
    {
        return bal;
    }

    public static CrazyCraft getPlugin()
    {
        return plugin;
    }
    public static void getTopBal(Player p){
        Map.Entry<String, Double> maxEntry = null;
        for(Map.Entry<String, Double> entry : bal.entrySet()){
            if(maxEntry == null || entry.getValue() > maxEntry.getValue()){
                maxEntry = entry;
            }
        }
        String maxName = maxEntry.getKey();
        double maxValue = maxEntry.getValue().doubleValue();
        p.sendMessage(String.format("%s[%sTop Balance%s] " + "%s" + maxName + " %s: %s" + maxValue, ChatColor.DARK_GRAY, ChatColor.BLUE, ChatColor.DARK_GRAY, ChatColor.DARK_RED, ChatColor.DARK_GRAY, ChatColor.GREEN));
        return;
    }

}
