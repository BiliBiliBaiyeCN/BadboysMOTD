package net.minecraftbadboys.motd.conf;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.minecraftbadboys.motd.Kernel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class MessageManager {

    private static final Kernel plugin = Kernel.getInstance();

    private static File configF;
    private static Configuration configC;

    public static void register() {
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) dataFolder.mkdirs();

        configF = new File(dataFolder, "messages.yml");
        if (!configF.exists()) {
            try (InputStream in = plugin.getResourceAsStream("messages.yml")) {
                Files.copy(in, configF.toPath());
            } catch (IOException ignored) {
            }
        }
        try {
            configC = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configF);
        } catch (IOException ignored) {
        }
    }

    public static void saveReload() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configC, configF);
        } catch (IOException ignored) {
        }

        try {
            configC = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configF);
        } catch (IOException ignored) {
        }
    }

    public static Configuration getYamlFile() {
        return configC;
    }

}
