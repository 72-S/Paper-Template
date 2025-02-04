package dev.consti.template;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Constructor;
import java.util.logging.Level;

/**
 * The Main class is the primary entry point for the plugin. It extends JavaPlugin and manages 
 * the plugin lifecycle, including initialization, enabling, and disabling. This class also 
 * dynamically loads the appropriate version-specific implementation of the VersionHandler interface 
 * based on the Minecraft server version.
 * 
 * How It Works:
 * 1. During `onEnable()`:
 *    - The plugin detects the server's Minecraft version using `getServerVersion()`.
 *    - Dynamically loads the appropriate `VersionHandlerImpl` class from the corresponding version package 
 *      (e.g., `dev.consti.template.v1_19.VersionHandlerImpl`).
 *    - Calls the `hello()` method from the loaded implementation.
 * 2. During `onDisable()`:
 *    - Logs a message indicating the plugin is being disabled.
 * 
 */

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

        getLogger().info("Successfully loaded version-specific implementation.");
        versionHandler.hello();
    }

    @Override
    public void onDisable() {
        getLogger().info("Stopping plugin");
    }

    /**
     * Dynamically initializes the version-specific VersionHandler implementation.
     * 
     * @return true if the version-specific implementation was successfully loaded, false otherwise.
     */
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

    /**
     * Retrieves the Minecraft server version and formats it for use in package names.
     * 
     * @return The server version in the format "1_19", "1_20", etc.
     */
    private String getServerVersion() {
        String version = Bukkit.getBukkitVersion().split("-")[0];
        String[] parts = version.split("\\.");

        return parts[0] + "_" + parts[1];
    }

    /**
     * Provides access to the version-specific VersionHandler implementation.
     * 
     * @return The currently loaded VersionHandler instance.
     */
    public static VersionHandler getVersionHandler() {
        return versionHandler;
    }
}
