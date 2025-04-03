package com.joonseo.cubeenchant;

import org.bukkit.plugin.java.JavaPlugin;

public final class CubeEnchant extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("cube").setExecutor(new ChangeOption());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
