package dev.consti.template;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Constructor;
import java.util.logging.Level;

public class Main extends JavaPlugin {
    private static VersionHandler versionHandler;
    
    @Override
    public void onEnable() {
        getLogger().info("Starting Plugin");

        if (!initalizeVersionHandler()) {
            getLogger().severe("Unsupported Minecraft version! Disabling plugin.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getLogger().info("Successfully loaded version specific implementation.");
        versionHandler.doSomething();
    }

    @Override
    public void onDisable() {
        getLogger().info("Stopping plugin");
    }

    private boolean initalizeVersionHandler() {
        String version = getServerVersion();
        getLogger().info("Detected Minecraft version: " + version);

        String packageName = "dev.consti.template.v" + version;

        try {
            Class<?> clazz = Class.forName(packageName + ".VersionHandlerImpl");
            Constructor<?> constructor = clazz.getConstructor();
            versionHandler = (VersionHandler) constructor.newInstance();

            return true;
        } catch (Exception e) {
            getLogger().log(Level.SEVERE, "Could not load version-specific implementation for " + version, e);

            return false;
        }
    }

    private String getServerVersion() {
        String version = Bukkit.getBukkitVersion().split("-")[0];
        String[] parts = version.split("\\.");

        return parts[0] + "_" + parts[1];
    }

    public static VersionHandler getVersionHandler() {
        return versionHandler;
    }
}
