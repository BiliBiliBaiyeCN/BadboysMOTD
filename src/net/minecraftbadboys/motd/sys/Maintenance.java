package net.minecraftbadboys.motd.sys;

import net.md_5.bungee.config.Configuration;
import net.minecraftbadboys.motd.conf.ConfigManager;

public class Maintenance extends Variable{

    static Configuration c = ConfigManager.getYamlFile();

    public static void on() {
        c.set(configSource.MaintenanceMode, true);
        ConfigManager.saveReload();
    }

    public static void off() {
        c.set(configSource.MaintenanceMode, false);
        ConfigManager.saveReload();
    }

}
