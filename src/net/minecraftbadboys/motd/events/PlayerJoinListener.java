package net.minecraftbadboys.motd.events;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.minecraftbadboys.motd.sys.Permission;
import net.minecraftbadboys.motd.sys.Variable;

public class PlayerJoinListener extends Variable implements Listener {

    @EventHandler
    public void onJoin(PostLoginEvent e) {
        ProxiedPlayer player = e.getPlayer();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MaintenanceKickMessage.size(); i++) {
            sb.append(MaintenanceKickMessage.get(i) + "\n");
        }

        if (MaintenanceMode() == true) {
            if (!(player.hasPermission(Permission.MaintenanceBypass) || player.hasPermission(Permission.Op))) {
                player.disconnect(new TextComponent(color(sb.toString())));
            }
        }

    }

}
