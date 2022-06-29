package me.rosux.limitedlife;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.UUID;

public final class LimitedLife extends JavaPlugin implements Listener {
    public static int defaultLives = 50;
    public static HashMap<UUID, Integer> mapLives = new HashMap<>();
    public static LimitedLife instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        instance.saveDefaultConfig();
        System.out.println("Life counter started");
        getCommand("limitedlife").setExecutor(new LifeCommand());
        getServer().getPluginManager().registerEvents(new eventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("life counter ended");
        instance.saveConfig();
    }

}
