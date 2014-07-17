package com.crazycraft.dev.CrazyCraft;

import com.crazycraft.dev.CrazyCraft.commands.*;
import com.crazycraft.dev.CrazyCraft.economy.EconManager;
import com.crazycraft.dev.CrazyCraft.economy.Util;
import com.crazycraft.dev.CrazyCraft.economy.events.BlockMine;
import com.crazycraft.dev.CrazyCraft.economy.events.EntityDeath;
import com.crazycraft.dev.CrazyCraft.economy.events.PlayerKill;
import com.crazycraft.dev.CrazyCraft.events.*;
import com.crazycraft.dev.CrazyCraft.teleportation.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;

/**
 * @Author Hunter Sharpe
 */
public class CrazyCraft extends JavaPlugin{

    private static CrazyCraft instance;

    public static CrazyCraft getInstance(){
        return instance;
    }

    private int countdown = 0;

    public File homeFile;
    public File accountsFile;
    public FileConfiguration config = getConfig();
    public FileConfiguration homeConf;
    public FileConfiguration accounts;

    @Override
    public void onEnable(){
        instance = this;
        if(!getDataFolder().exists()){
            getDataFolder().mkdir();
            saveDefaultConfig();
            saveConfig();
        }
        homeFile = new File(getDataFolder(), "homes.yml");
        accountsFile = new File(getDataFolder(), "accounts.yml");
        //Registering events
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Freeze(), this);
        pm.registerEvents(new God(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new PlayerMoveTimeLock(), this);
        pm.registerEvents(new MuteListener(), this);
        pm.registerEvents(new PlayerInteract(), this);

        //Command Executors
        getCommand("give").setExecutor(new Give());
        getCommand("afk").setExecutor(new Afk());
        getCommand("bal").setExecutor(new Bal());
        getCommand("balance").setExecutor(new Bal());
        getCommand("clear").setExecutor(new Clear());
        getCommand("fly").setExecutor(new Fly());
        getCommand("freeze").setExecutor(new Freeze());
        getCommand("gm").setExecutor(new GameMode());
        getCommand("god").setExecutor(new God());
        getCommand("home").setExecutor(new Home());
        getCommand("kit").setExecutor(new Kit());
        getCommand("me").setExecutor(new Me());
        getCommand("msg").setExecutor(new Message());
        getCommand("mute").setExecutor(new Mute());
        getCommand("playertime").setExecutor(new PlayerTime());
        getCommand("r").setExecutor(new R());
        getCommand("seen").setExecutor(new Seen());
        getCommand("slap").setExecutor(new Slap());
        getCommand("slay").setExecutor(new Slay());
        getCommand("spawnmob").setExecutor(new SpawnMob());
        getCommand("speed").setExecutor(new Speed());
        getCommand("time").setExecutor(new Time());
        getCommand("tppos").setExecutor(new Tppos());
        getCommand("unafk").setExecutor(new UnAfk());
        getCommand("unfreeze").setExecutor(new UnFreeze());
        getCommand("ungod").setExecutor(new UnGod());
        getCommand("tp").setExecutor(new TP());
        getCommand("tpa").setExecutor(new TPA());
        getCommand("tpaccept").setExecutor(new TPAccept());
        getCommand("tpahere").setExecutor(new TPAHere());
        getCommand("tpallhere").setExecutor(new TPAllHere());
        getCommand("tpback").setExecutor(new TPBack());
        getCommand("tphere").setExecutor(new TPHere());
        getCommand("tpo").setExecutor(new TPO());
        getCommand("tpohere").setExecutor(new TPOHere());
        getCommand("tpreject").setExecutor(new TPReject());
        getCommand("tpsilent").setExecutor(new TPSilent());
        getCommand("tptoggle").setExecutor(new TPToggle());
        getCommand("who").setExecutor(new Who());
        getCommand("list").setExecutor(new Who());
        //Config below

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new BukkitRunnable() {
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){

                    int blocksMined = BlockMine.getInstance().blocksMined.get(p.getUniqueId());
                    int oresMined = BlockMine.getInstance().oresMined.get(p.getUniqueId());
                    int playersKilled = PlayerKill.getInstance().playersKilled.get(p.getUniqueId());
                    int entitiesKilled = EntityDeath.getInstance().entitiesKilled.get(p.getUniqueId());
                    double payday = blocksMined * 0.09 + oresMined * 0.34 + playersKilled * 20 + entitiesKilled * 10;
                    p.sendMessage("[Economy] Blocks Mined: "
                            + blocksMined
                            + " Ores Mined: "
                            + oresMined
                            + " Players Killed: "
                            + playersKilled
                            + " Entities Killed: "
                            + entitiesKilled
                            + " Paycheck: " + payday);
                    EconManager.setBalance(p.getName(), EconManager.getBalance(p.getName()) + payday);
                }
            }
        }, 0L, 12000L);

        new EconManager(this);

        Util.loadBalances();

        try{
            loadConfig();
        }catch(Exception e){
            e.printStackTrace();
        }
        homeConf = new YamlConfiguration();
        homeConf.options().copyDefaults(true);
        accounts = new YamlConfiguration();
        accounts.options().copyDefaults(true);
        config.options().copyDefaults(true);
        loadYamls();
        saveConfig();
        new EconManager(this);

        Util.loadBalances();

    }
    @Override
    public void onDisable(){
        Util.saveBalances();
        saveConfig();
        saveYaml();
    }

    private void loadConfig() throws Exception{
        if(!homeFile.exists()){
            homeFile.getParentFile().mkdirs();
            copy(getResource("homes.yml"), homeFile);
        }
        if(!accountsFile.exists()){
            accountsFile.getParentFile().mkdirs();
            copy(getResource("accounts.yml"), accountsFile);
        }
    }
    private void copy(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadYamls() {
        try {//loads the contents of the File to its FileConfiguration
            homeConf.load(homeFile);
            accounts.load(accountsFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveYaml(){
        try{
            homeConf.save(homeFile);
            accounts.save(accountsFile);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //TODO: If current payday doesnt work, recode it.
}
