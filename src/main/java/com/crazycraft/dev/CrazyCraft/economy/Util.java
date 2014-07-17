package com.crazycraft.dev.CrazyCraft.economy;

import com.crazycraft.dev.CrazyCraft.CrazyCraft;

/**
 * Created by Server on 7/16/2014.
 */
public class Util {

    private static CrazyCraft plugin = EconManager.getPlugin();

    public static void saveBalances(){
        for(String s : EconManager.getBalanceMap().keySet()){
            plugin.accounts.set("balance." + s, EconManager.getBalanceMap().get(s));
        }
        plugin.saveYaml();
    }
    public static void loadBalances(){
        for(String s : plugin.accounts.getConfigurationSection("balance").getKeys(false)){
            EconManager.setBalance(s, plugin.accounts.getDouble("balance." + s));
        }
    }
}
