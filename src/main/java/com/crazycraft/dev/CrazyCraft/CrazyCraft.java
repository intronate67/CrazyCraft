package com.crazycraft.dev.CrazyCraft;

import com.crazycraft.dev.CrazyCraft.commands.*;
import com.crazycraft.dev.CrazyCraft.events.JoinListener;
import com.crazycraft.dev.CrazyCraft.events.MuteListener;
import com.crazycraft.dev.CrazyCraft.events.PlayerMoveTimeLock;
import com.crazycraft.dev.CrazyCraft.events.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

/**
 * @Author Hunter Sharpe
 */
public class CrazyCraft extends JavaPlugin{

    private static CrazyCraft instance;

    public static CrazyCraft getInstance(){
        return instance;
    }

    public File homeFile;
    public FileConfiguration config = getConfig();
    public FileConfiguration homeConf;

    @Override
    public void onEnable(){
        instance = this;
        if(!getDataFolder().exists()){
            getDataFolder().mkdir();
            saveDefaultConfig();
            saveConfig();
        }
        homeFile = new File(getDataFolder(), "homes.yml");

        //Registering events
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Freeze(), this);
        pm.registerEvents(new God(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new PlayerMoveTimeLock(), this);
        pm.registerEvents(new MuteListener(), this);

        //Command Executors
        getCommand("give").setExecutor(new Give());
        getCommand("afk").setExecutor(new Afk());
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
        //Config below

        try{
            loadConfig();
        }catch(Exception e){
            e.printStackTrace();
        }
        homeConf = new YamlConfiguration();
        homeConf.options().copyDefaults(true);
        config.options().copyDefaults(true);
        loadYamls();
        saveConfig();

    }
    @Override
    public void onDisable(){
        saveConfig();
    }

    private void loadConfig() throws Exception{
        if(!homeFile.exists()){
            homeFile.getParentFile().mkdirs();
            copy(getResource("homes.yml"), homeFile);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveYaml(){
        try{
            homeConf.save(homeFile);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
