package net.minecraftbadboys.motd.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import net.minecraftbadboys.motd.sys.Maintenance;
import net.minecraftbadboys.motd.sys.Permission;
import net.minecraftbadboys.motd.sys.Variable;

public class MaintenanceCommand extends Command {

    public MaintenanceCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission(Permission.Op)) {
            if (args.length == 0) {
                sender.sendMessage(new TextComponent(color("&c&m-------------------")));
                sender.sendMessage(new TextComponent(color("&c/maintenance [on/off]")));
                sender.sendMessage(new TextComponent(color("&c&m-------------------")));
            } else {
                if (args[0].equals("off")) {
                    if (Variable.MaintenanceMode() == true) {
                        Maintenance.off();
                        sender.sendMessage(new TextComponent(color(Variable.prefix + Variable.main_off)));
                    } else {
                        sender.sendMessage(new TextComponent(color(Variable.prefix + Variable.main_already_off)));
                    }
                } else if (args[0].equals("on")) {
                    if (Variable.MaintenanceMode() == false) {
                        Maintenance.on();
                        sender.sendMessage(new TextComponent(color(Variable.prefix + Variable.main_on)));
                    } else {
                        sender.sendMessage(new TextComponent(color(Variable.prefix + Variable.main_already_on)));
                    }
                }
            }
        } else {
            sender.sendMessage(new TextComponent(color(Variable.prefix + Variable.no_perm)));
        }
    }

    public static String color(String source) {
        return ChatColor.translateAlternateColorCodes('&', source);
    }
}
