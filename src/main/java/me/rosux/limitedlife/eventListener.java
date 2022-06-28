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
        if(!LimitedLife.mapLives.containsKey(e.getPlayer())){
            lives = defaultLives;
            LimitedLife.mapLives.put(e.getPlayer(), defaultLives);
            LifeCommand.sendLives(e.getPlayer(), lives);
        }else{
            lives = LimitedLife.mapLives.get(e.getPlayer());
            LifeCommand.sendLives(e.getPlayer(), lives);
        }
        if(lives <= 0){
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
            LifeCommand.noLifes(e.getPlayer());
        }
    }
    @EventHandler
    public void OnDeath(PlayerDeathEvent e){
        if(!LimitedLife.mapLives.containsKey(e.getPlayer())){
            lives = defaultLives;
            LimitedLife.mapLives.put(e.getPlayer(), defaultLives);
        }
        lives = LimitedLife.mapLives.get(e.getPlayer()) - 1;
        LimitedLife.mapLives.put(e.getPlayer(), lives);
        if(lives <= 0){
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
            LifeCommand.noLifes(e.getPlayer());
        }else{
            LifeCommand.deathMessage(e.getPlayer(), lives);
        }
    }
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        lives = LimitedLife.mapLives.get(e.getPlayer());
        if(lives <= 0){
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
            LifeCommand.noLifes(e.getPlayer());
        }
    }
}
