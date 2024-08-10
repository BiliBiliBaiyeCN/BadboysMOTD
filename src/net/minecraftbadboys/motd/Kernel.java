package net.minecraftbadboys.motd;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.minecraftbadboys.motd.commands.MaintenanceCommand;
import net.minecraftbadboys.motd.commands.ReloadConfigurationCommand;
import net.minecraftbadboys.motd.conf.ConfigManager;
import net.minecraftbadboys.motd.conf.MessageManager;
import net.minecraftbadboys.motd.events.PlayerJoinListener;
import net.minecraftbadboys.motd.events.ServerPingListener;

public class Kernel extends Plugin {

    private static Kernel instance;

    @Override
    public void onEnable() {
        instance = this;

        ConfigManager.register();
        MessageManager.register();

        registerCommand(new MaintenanceCommand("maintenance"));
        registerCommand(new ReloadConfigurationCommand("motd-reload"));

        registerListener(new PlayerJoinListener());
        registerListener(new ServerPingListener());

        getProxy().getConsole().sendMessage(new TextComponent("§a§m----------------------------------------"));
        getProxy().getConsole().sendMessage(new TextComponent("§aPlugin [BadboysMOTD] enabled."));
        getProxy().getConsole().sendMessage(new TextComponent("§7Author: §5Byakuya_sora §7(Aurarts Studios, Boat Team)"));
        getProxy().getConsole().sendMessage(new TextComponent("§7Version: §6" + getDescription().getVersion()));
        getProxy().getConsole().sendMessage(new TextComponent("§a§m----------------------------------------"));
    }

    @Override
    public void onDisable() {
        getProxy().getConsole().sendMessage(new TextComponent("§c§m----------------------------------------"));
        getProxy().getConsole().sendMessage(new TextComponent("§cPlugin [BadboysMOTD] disbaled."));
        getProxy().getConsole().sendMessage(new TextComponent("§7Author: §5Byakuya_sora §7(Aurarts Studios, Boat Team)"));
        getProxy().getConsole().sendMessage(new TextComponent("§7Version: §6" + getDescription().getVersion()));
        getProxy().getConsole().sendMessage(new TextComponent("§c§m----------------------------------------"));
    }

    public static Kernel getInstance() {
        return instance;
    }

    public void registerCommand(Command command) {
        getProxy().getPluginManager().registerCommand(this, command);
    }

    public void registerListener(Listener listener) {
        getProxy().getPluginManager().registerListener(this, listener);
    }
}
