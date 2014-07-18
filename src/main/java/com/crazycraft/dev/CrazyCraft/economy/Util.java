package com.crazycraft.dev.CrazyCraft.economy;

import com.crazycraft.dev.CrazyCraft.CrazyCraft;

/**
 * Created by Server on 7/16/2014.
 */
public class Util {

    public static void saveBalances(){
        for(String s : EconManager.getBalanceMap().keySet()){
            CrazyCraft.getInstance().getConfig().set("balance." + s, EconManager.getBalanceMap().get(s));
        }
        CrazyCraft.getInstance().saveYaml();
    }
    public static void loadBalances(){
        if(CrazyCraft.getInstance().getConfig().getConfigurationSection("balance").equals(null)) return;
        for(String s : CrazyCraft.getInstance().getConfig().getConfigurationSection("balance").getKeys(false)){
            EconManager.setBalance(s, CrazyCraft.getInstance().getConfig().getDouble("balance." + s));
        }
    }
}
