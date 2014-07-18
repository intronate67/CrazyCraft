package com.crazycraft.dev.CrazyCraft.economy.events;

import com.crazycraft.dev.CrazyCraft.economy.EconManager;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Server on 7/16/2014.
 */
public class BlockPlace implements Listener{

    private static BlockPlace instance = new BlockPlace();

    public static BlockPlace getInstance(){
        return instance;
    }

    public List<Block> placedBlocks = new ArrayList<Block>();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        if(!EconManager.hasAccount(e.getPlayer().getName())) return;
        Player p = e.getPlayer();
        if(p.getGameMode().equals(GameMode.CREATIVE)) return;
        Block block = e.getBlock();
        placedBlocks.add(block);
    }

}
