package net.minecraftbadboys.motd.utils;

import me.leoko.advancedban.manager.PunishmentManager;

import java.util.UUID;

public class PunishmentUtils {

    public static boolean isBannedPlayer(UUID uuid) {
        return PunishmentManager.get().isBanned(String.valueOf(uuid));
    }

}
