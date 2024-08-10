package net.minecraftbadboys.motd.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import net.minecraftbadboys.motd.conf.ConfigManager;
import net.minecraftbadboys.motd.conf.MessageManager;
import net.minecraftbadboys.motd.sys.Permission;
import net.minecraftbadboys.motd.sys.Variable;

public class ReloadConfigurationCommand extends Command {

    public ReloadConfigurationCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission(Permission.Op)) {
            ConfigManager.saveReload();
            MessageManager.saveReload();
            sender.sendMessage(new TextComponent(color(Variable.prefix + Variable.reloaded)));
        } else {
            sender.sendMessage(new TextComponent(color(Variable.prefix + Variable.no_perm)));
        }
    }

    public static String color(String source) {
        return ChatColor.translateAlternateColorCodes('&', source);
    }
}
