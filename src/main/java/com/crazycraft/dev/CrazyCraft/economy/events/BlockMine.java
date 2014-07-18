package com.crazycraft.dev.CrazyCraft.economy.events;

import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.HashMap;
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

    public Map<UUID, Integer> blocksMined = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> oresMined = new HashMap<UUID, Integer>();

    @EventHandler
    public void onBlockMine(BlockBreakEvent e){
        Block block = e.getBlock();
        Player p = e.getPlayer();
        if(p.getGameMode().equals(GameMode.CREATIVE)) return;
        if(BlockPlace.getInstance().placedBlocks.contains(block)) return;
        switch(block.getType()){
            case GRASS:

                break;
            case DIRT:
                break;
            case STONE :
                if(blocksMined.containsKey(e.getPlayer().getUniqueId())){
                    blocksMined.put(e.getPlayer().getUniqueId(), blocksMined.get(e.getPlayer().getUniqueId()) + 1);
                    return;
                }
                blocksMined.put(e.getPlayer().getUniqueId(), 1);
                break;
            case COBBLESTONE:
                if(blocksMined.containsKey(e.getPlayer().getUniqueId())){
                    blocksMined.put(e.getPlayer().getUniqueId(), blocksMined.get(e.getPlayer().getUniqueId()) + 1);
                    return;
                }
                blocksMined.put(e.getPlayer().getUniqueId(), 1);
                break;
            case COAL_ORE:
                if(oresMined.containsKey(e.getPlayer().getUniqueId())){
                    oresMined.put(e.getPlayer().getUniqueId(), oresMined.get(e.getPlayer().getUniqueId()) + 1);
                    return;
                }
                oresMined.put(e.getPlayer().getUniqueId(), 1);
                break;
            case GOLD_ORE:
                if(oresMined.containsKey(e.getPlayer().getUniqueId())){
                    oresMined.put(e.getPlayer().getUniqueId(), oresMined.get(e.getPlayer().getUniqueId()) + 1);
                    return;
                }
                oresMined.put(e.getPlayer().getUniqueId(), 1);
                break;
            case IRON_ORE:
                if(oresMined.containsKey(e.getPlayer().getUniqueId())){
                    oresMined.put(e.getPlayer().getUniqueId(), oresMined.get(e.getPlayer().getUniqueId()) + 1);
                    return;
                }
                oresMined.put(e.getPlayer().getUniqueId(), 1);
                break;
            case DIAMOND_ORE:
                if(oresMined.containsKey(e.getPlayer().getUniqueId())){
                    oresMined.put(e.getPlayer().getUniqueId(), oresMined.get(e.getPlayer().getUniqueId()) + 1);
                    return;
                }
                oresMined.put(e.getPlayer().getUniqueId(), 1);
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
        if(blocksMined.containsKey(e.getPlayer().getUniqueId())){
            blocksMined.put(e.getPlayer().getUniqueId(), blocksMined.get(e.getPlayer().getUniqueId()) + 1);
            return;
        }
        blocksMined.put(e.getPlayer().getUniqueId(), 1);
    }

}
