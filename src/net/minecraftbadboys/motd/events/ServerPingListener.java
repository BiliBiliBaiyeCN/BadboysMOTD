package net.minecraftbadboys.motd.events;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.minecraftbadboys.motd.sys.Variable;
import net.minecraftbadboys.motd.utils.PunishmentUtils;

import java.util.Random;
import java.util.UUID;

public class ServerPingListener extends Variable implements Listener {

    @EventHandler
    public void onPing(ProxyPingEvent e) {
        UUID playerUUID = e.getConnection().getUniqueId();

        System.out.println("[DEBUG] [" + playerUUID + "] pinged to the proxy.");

        ServerPing ping = e.getResponse();
        ServerPing.Protocol protocol = ping.getVersion();
        ServerPing.Players players = ping.getPlayers();

        if (PunishmentUtils.isBannedPlayer(playerUUID)) {
            ping.setDescriptionComponent(new TextComponent(color(FirstMotd(MaintenanceMode()) + "\n" + BannedSecondList)));
        } else {
            if (MaintenanceMode() == true) {
                protocol.setProtocol(2);
                protocol.setName(MaintenanceVer);
                ping.setDescriptionComponent(new TextComponent(color(FirstMotd(MaintenanceMode()) + "\n" + SecondMaintenanceMotd)));
                ping.setPlayers(players);
                ping.setVersion(protocol);
            } else {
                int index = random(SecondMotdList.size());
                ping.setDescriptionComponent(new TextComponent(color(FirstMotd(MaintenanceMode()) + "\n" + SecondMotdList.get(index))));
            }
        }

        e.setResponse(ping);
    }

    public int random(int listSize) {
        Random random = new Random();
        return random.nextInt(listSize);
    }

}
