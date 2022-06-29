package me.rosux.limitedlife;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class eventListener implements Listener {
    int defaultLives = 50;
    int lives;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {


        if(LimitedLife.instance.getConfig().getString("player." + e.getPlayer().getUniqueId().toString()) == null){ ////////////////
            LimitedLife.instance.getConfig().set("player." + e.getPlayer().getUniqueId().toString(), defaultLives); ////////////////
        }
        LimitedLife.mapLives.put(e.getPlayer().getUniqueId(), LimitedLife.instance.getConfig().getInt("player." + e.getPlayer().getUniqueId().toString())); ////////////////


        lives = LimitedLife.mapLives.get(e.getPlayer().getUniqueId());
        LifeCommand.sendLives(e.getPlayer(), lives);
        if(lives <= 0){
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
            LifeCommand.noLifes(e.getPlayer());
        }
        LimitedLife.instance.saveConfig();
    }
    @EventHandler
    public void OnDeath(PlayerDeathEvent e){
        if(LimitedLife.instance.getConfig().getString("player." + e.getPlayer().getUniqueId().toString()) == null){ ////////////////
            LimitedLife.instance.getConfig().set("player." + e.getPlayer().getUniqueId().toString(), defaultLives); ////////////////
        }
        LimitedLife.mapLives.put(e.getPlayer().getUniqueId(), LimitedLife.instance.getConfig().getInt("player." + e.getPlayer().getUniqueId().toString())); ////////////////
        if(lives > 0){
            lives = LimitedLife.mapLives.get(e.getPlayer().getUniqueId()) - 1;
        }else{
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        LimitedLife.mapLives.put(e.getPlayer().getUniqueId(), lives);
        LifeCommand.sendLives(e.getPlayer(), lives);
        LimitedLife.instance.getConfig().set("player." + e.getPlayer().getUniqueId().toString(),  LimitedLife.mapLives.get(e.getPlayer().getUniqueId())); //////////////////////////////////////
        LimitedLife.instance.saveConfig();
    }
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        lives = LimitedLife.mapLives.get(e.getPlayer().getUniqueId());
        if(lives <= 0){
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
            LifeCommand.noLifes(e.getPlayer());
        }
    }
}
