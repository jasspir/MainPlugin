package me.jass.mainplugin;

import me.jass.api.API;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class MainPlugin extends JavaPlugin {
    private External api;
    public static String name = "clementine";

    @Override
    public void onEnable() {
        api = new External();
        Bukkit.getServicesManager().register(API.class, api, this, ServicePriority.Normal);
    }

    @Override
    public void onDisable() {
    }
}
