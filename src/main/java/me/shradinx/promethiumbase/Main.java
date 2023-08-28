package me.shradinx.promethiumbase;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info(this.getName() + " Enabled!");

        this.getCommand("givedirt").setExecutor(new GiveDirt());
        this.getCommand("factions").setExecutor(new FactionsCommand());
        this.getCommand("fac").setExecutor(new FactionsCommand());
        this.getCommand("f").setExecutor(new FactionsCommand());
    }
    @Override
    public void onDisable() {
        Bukkit.getLogger().info(this.getName() + " Disabled!");
    }


}


