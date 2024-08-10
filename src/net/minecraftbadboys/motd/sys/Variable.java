package net.minecraftbadboys.motd.sys;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.config.Configuration;
import net.minecraftbadboys.motd.conf.ConfigManager;
import net.minecraftbadboys.motd.conf.MessageManager;

import java.util.List;

public class Variable {

    public static String prefix = "&7[&bBadboys&3Motd&7] ";

    static Configuration c = ConfigManager.getYamlFile();
    static Configuration m = MessageManager.getYamlFile();

    // config.yml
    public static String FirstMotd(boolean maintenanceMode) {
        if (maintenanceMode) {
            return c.getString(configSource.Maintenance.FirstMotd);
        } else {
            return c.getString(configSource.FirstMotd);
        }
    }
    public static List<String> SecondMotdList = c.getStringList(configSource.SecondMotd);
    public static String BannedSecondList = c.getString(configSource.BannedSecondMotd);

    public static boolean MaintenanceMode() {
        return c.getBoolean(configSource.MaintenanceMode);
    }
    public static String SecondMaintenanceMotd = c.getString(configSource.Maintenance.SecondMotd);
    public static String MaintenanceVer = c.getString(configSource.Maintenance.Version);
    public static List<String> MaintenanceKickMessage = c.getStringList(configSource.Maintenance.kickMsg);

    public static class configSource {
        public static final String MaintenanceMode = "Maintenance-mode";
        public static final String FirstMotd = "First-Normal-Motd";
        public static final String SecondMotd = "Second-Normal-Motd";
        public static final String BannedSecondMotd = "Banned-Second-Motd";

        public static class Maintenance {
            public static final String FirstMotd = "First-Maintenance-Motd";
            public static final String SecondMotd = "Second-Maintenance-Motd";
            public static final String Version = "Maintenance-Version-Name";
            public static final String kickMsg = "Maintenance-Kick-Message";
        }
    }

    // messages.yml
    public static String main_on = m.getString(MessageSource.main_on);
    public static String main_off = m.getString(MessageSource.main_off);
    public static String main_already_on = m.getString(MessageSource.main_already_on);
    public static String main_already_off = m.getString(MessageSource.main_already_off);
    public static String no_perm = m.getString(MessageSource.no_perm);
    public static String reloaded = m.getString(MessageSource.reloaded);

    public static class MessageSource {
        public static final String main_on = "Maintenance-On";
        public static final String main_off = "Maintenance-Off";
        public static final String main_already_on = "Maintenance-Already-On";
        public static final String main_already_off = "Maintenance-Already-Off";

        public static final String no_perm = "no-permission";
        public static final String reloaded = "Reloaded-Yaml-Files";
    }

    public static String color(String source) {
        return ChatColor.translateAlternateColorCodes('&', source);
    }

}
