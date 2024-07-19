package me.jass.mainplugin;

import me.jass.api.API;
import me.jass.api.SneakEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class MainPlugin extends JavaPlugin implements Listener {
    private External api;
    public static String name = "clementine";

    @Override
    public void onEnable() {
        api = new External();
        Bukkit.getServicesManager().register(API.class, api, this, ServicePriority.Normal);
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void sneakEvent(PlayerToggleSneakEvent event) {
        //this will be called when a player toggles sneak
        boolean sneaking = event.isSneaking();

        //now we make our own custom sneak event
        SneakEvent sneakEvent = new SneakEvent(sneaking);
        Bukkit.getPluginManager().callEvent(sneakEvent);
    }
}
