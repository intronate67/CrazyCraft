package com.crazycraft.dev.CrazyCraft.economy.events;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Server on 7/16/2014.
 */
public class BlockMine implements Listener{

    private static BlockMine instance = new BlockMine();

    public static BlockMine getInstance(){
        return instance;
    }

    public Map<UUID, Integer> blocksMined;
    public Map<UUID, Integer> oresMined;

    @EventHandler
    public void onBlockMine(BlockBreakEvent e){
        Block block = e.getBlock();
        if(BlockPlace.getInstance().placedBlocks.contains(block)) return;
        switch(block.getType()){
            case STONE :
                break;
            case COBBLESTONE:
                break;
            case COAL_ORE:
                oresMined.put(e.getPlayer().getUniqueId(), oresMined.get(e.getPlayer().getUniqueId()) + 1);
                break;
            case GOLD_ORE:
                oresMined.put(e.getPlayer().getUniqueId(), oresMined.get(e.getPlayer().getUniqueId()) + 1);
                break;
            case IRON_ORE:
                oresMined.put(e.getPlayer().getUniqueId(), oresMined.get(e.getPlayer().getUniqueId()) + 1);
                break;
            case DIAMOND_ORE:
                oresMined.put(e.getPlayer().getUniqueId(), oresMined.get(e.getPlayer().getUniqueId()) + 1);
                break;
            case OBSIDIAN:
                break;
            case NETHERRACK:
                break;
            case NETHER_BRICK:
                break;
            default:
                break;
        }
        blocksMined.put(e.getPlayer().getUniqueId(), blocksMined.get(e.getPlayer().getUniqueId()) + 1);
    }

}
